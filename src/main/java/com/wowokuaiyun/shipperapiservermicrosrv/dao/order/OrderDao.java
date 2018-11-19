package com.wowokuaiyun.shipperapiservermicrosrv.dao.order;

import com.wowokuaiyun.shipperapiservermicrosrv.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DingJie on 2018/11/15
 */
@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
    List<Order> findByShipperId(Long shipperId);
}
