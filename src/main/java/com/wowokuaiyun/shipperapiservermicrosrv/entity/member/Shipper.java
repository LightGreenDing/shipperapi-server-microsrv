package com.wowokuaiyun.shipperapiservermicrosrv.entity.member;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 货主
 *
 * @author DingJie on 2018/11/15
 */
@Entity
@Table(name = "wo_shipper")
public class Shipper implements Serializable {
    /**
     * 姓名
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipperid")
    private Long shipperId;
    /**
     * 姓名
     */

    @Column(name = "username")
    private String username;
    /**
     * 手机号
     */
    @Column(name = "mobile")
    private String mobile;
    /**
     * 身份证
     */
    @Column(name = "idcard")
    private String idCard;

    public Long getShipperId() {
        return shipperId;
    }

    public void setShipperId(Long shipperId) {
        this.shipperId = shipperId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Shipper{" +
                "shipperId=" + shipperId +
                ", username='" + username + '\'' +
                ", mobile='" + mobile + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
