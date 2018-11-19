package com.wowokuaiyun.shipperapiservermicrosrv.service.order;

import com.wowokuaiyun.shipperapiservermicrosrv.entity.order.Order;

import java.util.List;

/**
 * 订单接口
 *
 * @author DingJie on 2018/11/15
 */
public interface OrderService {
    List<Order> findOrdersByShipperId(Long shipperId);
}
