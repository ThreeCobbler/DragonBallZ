package com.dragon.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_order")
public class OrderEO {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 订单金额
     */
    @Column(name = "order_amount")
    private Double orderAmount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 上次修改时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 流水单号
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单号
     *
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取订单状态
     *
     * @return status - 订单状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置订单状态
     *
     * @param status 订单状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取订单金额
     *
     * @return order_amount - 订单金额
     */
    public Double getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置订单金额
     *
     * @param orderAmount 订单金额
     */
    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取上次修改时间
     *
     * @return last_update_time - 上次修改时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置上次修改时间
     *
     * @param lastUpdateTime 上次修改时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 获取流水单号
     *
     * @return trade_no - 流水单号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置流水单号
     *
     * @param tradeNo 流水单号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}