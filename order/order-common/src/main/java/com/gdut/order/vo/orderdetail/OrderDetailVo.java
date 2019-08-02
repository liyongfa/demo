package com.gdut.order.vo.orderdetail;

import com.gudt.common.vo.BaseVo;

import java.math.BigDecimal;

/**
 * @Auther: lyf
 * @Date: 2019-06-27 18:18
 * @Description:
 */
public class OrderDetailVo extends BaseVo {

    private Integer id;

    private String productName;

    private BigDecimal price;

    private Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
