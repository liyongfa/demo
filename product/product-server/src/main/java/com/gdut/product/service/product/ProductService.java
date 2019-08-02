package com.gdut.product.service.product;

import com.gdut.product.service.BaseService;
import com.gudt.product.req.product.ProductInsertFormReq;
import com.gudt.product.req.product.ProductSelectReq;
import com.gudt.product.req.product.ProductUpdateFormReq;
import com.gudt.product.resp.product.ProductInsertResp;
import com.gudt.product.resp.product.ProductSelectResp;
import com.gudt.product.resp.product.ProductUpdateResp;

public interface ProductService extends BaseService {
    //插入商品记录
    ProductInsertResp insertProductRecord(ProductInsertFormReq req);
    //更新商品信息
    ProductUpdateResp updateProductRecord(ProductUpdateFormReq req);
    //使用id号进行商品信息的查询
    ProductSelectResp selectProductRecord(ProductSelectReq req);
}
