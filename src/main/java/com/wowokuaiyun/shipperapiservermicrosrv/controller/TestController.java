package com.wowokuaiyun.shipperapiservermicrosrv.controller;

import com.wowokuaiyun.shipperapiservermicrosrv.entity.member.Shipper;
import com.wowokuaiyun.shipperapiservermicrosrv.entity.order.Order;
import com.wowokuaiyun.shipperapiservermicrosrv.service.order.OrderService;
import com.wowokuaiyun.shipperapiservermicrosrv.service.shipper.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试类
 *
 * @author DingJie on 2018/11/19
 */
@RestController
public class TestController {
    @Autowired
    private ShipperService shipperService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/hi")
    public ResponseEntity test(Long id) {
        Shipper shipper = shipperService.findShipperById(id);
        List<Order> orders = orderService.findOrdersByShipperId(id);
        Map<String, Object> map = new HashMap<>();
        map.put("shipper", shipper);
        map.put("orders", orders);
        return ResponseEntity.ok(map);
    }
}
