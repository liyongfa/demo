package com.gudt.product.vo.product;

import com.gudt.common.vo.BaseVo;

import java.math.BigDecimal;

/**
 * @Auther: lyf
 * @Date: 2019-06-21 17:43
 * @Description:
 */
public class ProductVo extends BaseVo {

    private Integer id;

    private String name;

    private BigDecimal price;

    private Integer stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
