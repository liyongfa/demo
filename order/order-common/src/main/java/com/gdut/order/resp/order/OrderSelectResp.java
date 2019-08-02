package com.gdut.order.resp.order;

import com.gdut.order.vo.order.OrderVo;
import com.gudt.common.resp.BaseResp;

/**
 * @Auther: lyf
 * @Date: 2019-06-27 18:17
 * @Description:
 */
public class OrderSelectResp extends BaseResp {

    private OrderVo data;

    public OrderVo getData() {
        return data;
    }

    public void setData(OrderVo data) {
        this.data = data;
    }
}
