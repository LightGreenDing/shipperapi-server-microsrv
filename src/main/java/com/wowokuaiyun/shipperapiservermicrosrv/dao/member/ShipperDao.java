package com.wowokuaiyun.shipperapiservermicrosrv.dao.member;

import com.wowokuaiyun.shipperapiservermicrosrv.entity.member.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 货主Dao
 * @author DingJie on 2018/11/15
 */
@Repository
public interface ShipperDao extends JpaRepository<Shipper, Long> {

}
