package com.gdut.order.req.order;

import com.gudt.common.req.BaseReq;

/**
 * @Auther: lyf
 * @Date: 2019-06-27 17:11
 * @Description:
 */
public class OrderUpdateReq extends BaseReq {

    private Integer id;

    //订单状态
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
