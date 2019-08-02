package com.gdut.product.service.product.impl;

import com.gdut.product.entity.Product;
import com.gdut.product.repository.ProductRepository;
import com.gdut.product.service.product.ProductService;
import com.gudt.product.common.ResultCode;
import com.gudt.product.req.product.ProductInsertFormReq;
import com.gudt.product.req.product.ProductSelectReq;
import com.gudt.product.req.product.ProductUpdateFormReq;
import com.gudt.product.resp.product.ProductInsertResp;
import com.gudt.product.resp.product.ProductSelectResp;
import com.gudt.product.resp.product.ProductUpdateResp;
import com.gudt.product.vo.product.ProductVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Optional;

/**
 * @Auther: lyf
 * @Date: 2019-06-24 15:06
 * @Description:
 */
@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    //进行商品的插入操作
    @Override
    public ProductInsertResp insertProductRecord(ProductInsertFormReq req) {
        ProductInsertResp resp = new ProductInsertResp();
        try {
            Product record = new Product();
            BeanUtils.copyProperties(req, record);
            record = productRepository.save(record);
            //将操作字段进行回填
            resp.setOperationId(record.getId());
        } catch (Exception e) {
            resp.setCode(ResultCode.INSERT_RECORD_FAIL);
            resp.setMessage("插入用户信息失败");
            logger.info("---insertProductRecord插入用户信息失败---:" + e);
            //进行数据的手动回滚操作
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return resp;
    }

    //进行商品的更新操作
    @Override
    public ProductUpdateResp updateProductRecord(ProductUpdateFormReq req) {
        ProductUpdateResp resp = new ProductUpdateResp();
        try {
            Optional<Product> recordOptional = productRepository.findById(req.getId());
            if (!recordOptional.isPresent()) {
                resp.setCode(ResultCode.RECORD_NOT_EXISTS);
                resp.setMessage("所操作的记录不存在");
                return resp;
            }
            Product record = recordOptional.get();
            //将需要修改的字段直接赋值给record
            BeanUtils.copyProperties(record, record);
            record = productRepository.save(record);
            //将操作成功的id进行回填
            resp.setOperationId(record.getId());
        } catch (Exception e) {
            resp.setCode(ResultCode.UPDATE_RECORD_FAIL);
            resp.setMessage("更新记录失败");
            logger.info("---updateProductRecord更新记录失败---:" + e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return resp;
    }

    //进行商品的查询操作
    @Override
    public ProductSelectResp selectProductRecord(ProductSelectReq req) {
        ProductSelectResp resp = new ProductSelectResp();
        try {
            Product record = productRepository.getOne(req.getId());
            ProductVo vo = new ProductVo();
            if (record != null) {
                BeanUtils.copyProperties(record, vo);
            }
            resp.setData(vo);
        } catch (Exception e) {
            resp.setCode(ResultCode.SELECT_RECORD_FAIL);
            resp.setMessage("查询信息失败");
            logger.info("---selectProductRecord查询信息失败---:" + e);
        }
        return resp;
    }
}
