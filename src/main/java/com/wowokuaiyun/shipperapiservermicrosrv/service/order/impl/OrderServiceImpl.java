package com.wowokuaiyun.shipperapiservermicrosrv.service.order.impl;

import com.wowokuaiyun.shipperapiservermicrosrv.dao.order.OrderDao;
import com.wowokuaiyun.shipperapiservermicrosrv.entity.order.Order;
import com.wowokuaiyun.shipperapiservermicrosrv.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单实现类
 *
 * @author DingJie on 2018/11/15
 */
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findOrdersByShipperId(Long shipperId) {
        return orderDao.findByShipperId(shipperId);
    }
}
