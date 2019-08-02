package com.gdut.order.vo.order;

import com.gudt.common.vo.BaseVo;

import java.math.BigDecimal;

/**
 * @Auther: lyf
 * @Date: 2019-06-27 17:13
 * @Description:
 */
public class OrderVo extends BaseVo {

    private Integer id;

    private BigDecimal amount;

    private String message;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
