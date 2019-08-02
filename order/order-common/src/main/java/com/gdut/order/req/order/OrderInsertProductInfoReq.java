package com.gdut.order.req.order;

import com.gudt.common.req.BaseReq;

/**
 * @Auther: lyf
 * @Date: 2019-06-27 17:11
 * @Description:
 */
public class OrderInsertProductInfoReq extends BaseReq {

    private Integer productId;

    private Integer number;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
