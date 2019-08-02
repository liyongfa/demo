package com.gdut.product.client;

import com.gdut.product.client.InvokeProxyClient;
import com.gdut.product.service.product.ProductService;
import com.gudt.product.req.product.ProductInsertFormReq;
import com.gudt.product.req.product.ProductSelectReq;
import com.gudt.product.req.product.ProductUpdateFormReq;
import com.gudt.product.resp.product.ProductInsertResp;
import com.gudt.product.resp.product.ProductSelectResp;
import com.gudt.product.resp.product.ProductUpdateResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: lyf
 * @Date: 2019-06-27 15:12
 * @Description:
 */
@Component
public class ProductClient {

    @Autowired
    private ProductService productService;

    //插入商品记录
    public ProductInsertResp insertProductRecord(ProductInsertFormReq req) {
        return (ProductInsertResp) InvokeProxyClient.invoke(productService, "insertProductRecord", req);
    }

    //更新商品信息
    public ProductUpdateResp updateProductRecord(ProductUpdateFormReq req) {
        return (ProductUpdateResp) InvokeProxyClient.invoke(productService, "", req);
    }

    //使用id号进行商品信息的查询
    public ProductSelectResp selectProductRecord(ProductSelectReq req) {
        return (ProductSelectResp) InvokeProxyClient.invoke(productService, "", req);
    }
}
