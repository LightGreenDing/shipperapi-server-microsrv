package com.wowokuaiyun.shipperapiservermicrosrv.service.shipper.impl;

import com.wowokuaiyun.shipperapiservermicrosrv.dao.member.ShipperDao;
import com.wowokuaiyun.shipperapiservermicrosrv.entity.member.Shipper;
import com.wowokuaiyun.shipperapiservermicrosrv.service.shipper.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 货主实现类
 *
 * @author DingJie on 2018/11/15
 */
@Service
public class ShipperServiceImpl implements ShipperService {
    @Autowired
    private ShipperDao shipperDao;

    @Override
    public Shipper findShipperById(Long id) {
        Optional<Shipper> byId = shipperDao.findById(id);
        return byId.get();
    }
}
