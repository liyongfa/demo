package com.gudt.product.resp.product;

import com.gudt.product.resp.BaseResp;
import com.gudt.product.vo.product.ProductVo;

/**
 * @Auther: lyf
 * @Date: 2019-06-21 19:14
 * @Description:
 */
public class ProductSelectResp extends BaseResp {

    private ProductVo data;

    public ProductVo getData() {
        return data;
    }

    public void setData(ProductVo data) {
        this.data = data;
    }
}
