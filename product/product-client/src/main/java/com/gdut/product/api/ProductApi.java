package com.gdut.product.api;

import com.gudt.product.req.product.ProductInsertFormReq;
import com.gudt.product.req.product.ProductSelectReq;
import com.gudt.product.req.product.ProductUpdateFormReq;
import com.gudt.product.resp.product.ProductInsertResp;
import com.gudt.product.resp.product.ProductSelectResp;
import com.gudt.product.resp.product.ProductUpdateResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @Auther: lyf
 * @Date: 2019-06-27 15:57
 * @Description:
 */
@FeignClient(value = "/product")
public interface ProductApi {

    /**
     * 添加商品
     *
     * @param req
     * @param errors
     * @return
     */
    @PostMapping
    ProductInsertResp insertProductRecord(@RequestBody @Valid ProductInsertFormReq req, Errors errors);

    /**
     * 修改商品信息
     *
     * @param req
     * @param errors
     * @return
     */
    @PutMapping
    ProductUpdateResp updateProductRecord(@RequestBody @Valid ProductUpdateFormReq req, Errors errors);


    /**
     * 修改商品信息
     *
     * @param req
     * @param errors
     * @return
     */
    @GetMapping
    ProductSelectResp selectProductRecord(@RequestBody @Valid ProductSelectReq req, Errors errors);

}
