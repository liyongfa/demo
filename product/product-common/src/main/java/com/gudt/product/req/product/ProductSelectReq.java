package com.gudt.product.req.product;

import com.gudt.common.req.BaseReq;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Auther: lyf
 * @Date: 2019-06-21 17:42
 * @Description:
 */
public class ProductSelectReq extends BaseReq {

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
