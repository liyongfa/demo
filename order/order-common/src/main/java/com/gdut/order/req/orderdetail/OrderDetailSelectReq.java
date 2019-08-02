package com.gdut.order.req.orderdetail;

import com.gudt.common.req.BaseReq;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Auther: lyf
 * @Date: 2019-06-27 18:16
 * @Description:
 */
public class OrderDetailSelectReq extends BaseReq {

    @NotNull
    @Min(value = 1)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
