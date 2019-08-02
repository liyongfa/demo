package com.gdut.product.controller;

import com.gdut.product.client.ManagerLoggerClient;
import com.gdut.product.client.ProductClient;
import com.gudt.product.common.OperationType;
import com.gudt.product.common.ResultCode;
import com.gudt.product.req.product.ProductInsertFormReq;
import com.gudt.product.req.product.ProductSelectReq;
import com.gudt.product.req.product.ProductUpdateFormReq;
import com.gudt.product.resp.BaseResp;
import com.gudt.product.resp.product.ProductInsertResp;
import com.gudt.product.resp.product.ProductSelectResp;
import com.gudt.product.resp.product.ProductUpdateResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Auther: lyf
 * @Date: 2019-06-27 15:17
 * @Description:
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductClient productClient;

    //添加商品
    @PostMapping
    public ProductInsertResp insertProductRecord(@RequestBody @Valid ProductInsertFormReq req, Errors errors) {
        ProductInsertResp resp = new ProductInsertResp();
        //进行表单验证
        if (errors.hasErrors()) {
            paramValidate(errors, resp);
            return resp;
        }
        resp = productClient.insertProductRecord(req);
        //操作成功需要进行日志记录
        if (resp.getCode() == 0) {
            ManagerLoggerClient.insertLog("/product", "post", OperationType.INSERT, req, resp.getOperationId());
        }
        return resp;
    }

    //修改商品信息
    @PutMapping
    public ProductUpdateResp updateProductRecord(@RequestBody @Valid ProductUpdateFormReq req, Errors errors) {
        ProductUpdateResp resp = new ProductUpdateResp();
        if (errors.hasErrors()) {
            paramValidate(errors, resp);
            return resp;
        }
        resp = productClient.updateProductRecord(req);
        if (resp.getCode() == 0) {
            ManagerLoggerClient.insertLog("/product", "put", OperationType.UPDATE, req, resp.getOperationId());
        }
        return resp;
    }


    //获取商品信息
    @GetMapping
    public ProductSelectResp selectProductRecord(@RequestBody @Valid ProductSelectReq req, Errors errors) {
        ProductSelectResp resp = new ProductSelectResp();
        if (errors.hasErrors()) {
            paramValidate(errors, resp);
            return resp;
        }
        return productClient.selectProductRecord(req);
    }

    //进行参数的校验操作
    private void paramValidate(Errors errors, BaseResp resp) {
        errors.getFieldErrors().stream().forEach(error -> resp.getParamErrors().put(error.getField(), error.getDefaultMessage()));
        resp.setCode(ResultCode.PARAM_ERROR);
        resp.setMessage("参数存在错误");
    }
}
