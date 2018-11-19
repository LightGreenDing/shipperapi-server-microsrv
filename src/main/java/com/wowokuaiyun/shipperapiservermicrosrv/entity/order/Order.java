package com.wowokuaiyun.shipperapiservermicrosrv.entity.order;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 *
 * @author DingJie on 2018/11/15
 */
@Entity
@Table(name = "wo_order")
public class Order implements Serializable {
    //订单号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Long orderId;
    //创建时间
    @Column(name = "create_time")
    private Date createTime;
    //发货人ID
    @Column(name = "shipperid")
    private Long shipperId;
    //发货人姓名
    @Column(name = "shippername")
    private String shipperName;
    //收货人
    @Column(name = "consigneename")
    private String consigneeName;
    //订单状态
    @Column(name = "state")
    private String state;
    //订单名称
    @Column(name = "ordername")
    private String orderName;
    //订单金额
    @Column(name = "totalmoney")
    private String totalMoney;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getShipperId() {
        return shipperId;
    }

    public void setShipperId(Long shipperId) {
        this.shipperId = shipperId;
    }


    public String getConsigneeName() {
        return consigneeName;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", createTime=" + createTime +
                ", shipperId=" + shipperId +
                ", shipperName='" + shipperName + '\'' +
                ", consigneeName='" + consigneeName + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
