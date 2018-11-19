package com.wowokuaiyun.shipperapiservermicrosrv.service.shipper;

import com.wowokuaiyun.shipperapiservermicrosrv.entity.member.Shipper;

/**
 * 货主服务
 *
 * @author DingJie on 2018/11/15
 */
public interface ShipperService {
    /**
     * 通过id获取货主
     *
     * @param id 货主id
     * @return 货主
     */
    Shipper findShipperById(Long id);
}
