package com.ly.traffic.middleplatform.domain.order.repository.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 支付任务订单表(PayOrderInfoPO)实体类
 *
 * @author makejava
 * @since 2020-08-25 18:22:05
 */
public class PayOrderInfoPO implements Serializable {
    private static final long serialVersionUID = 620760474027766026L;
    /**
    * 订单自增ID（主键）
    */
    private Integer id;
    /**
    * 合单支付订单号
    */
    private String unionPayOrderNo;
    /**
    * 购买主订单流水号
    */
    private String mainOrderNo;
    /**
    * 被支付的子订单流水号
    */
    private String childOrderNo;
    /**
    * 子订单类型: 0-出行订单 1-营收商品订单
    */
    private Integer childOrderType;
    /**
    * 状态: 0-任务取消，1-支付中，2-支付成功， 3-支付失败
    */
    private Integer status;
    /**
    * 支付失败原因
    */
    private String payFailReason;
    /**
    * 金额
    */
    private Double amount;
    /**
    * 统一支付流水号
    */
    private String paySerialNo;
    /**
    * 创建日期
    */
    private Date createDate;
    /**
    * 创建人
    */
    private String createUser;
    /**
    * 更新日期
    */
    private Date updateDate;
    /**
    * 更新人
    */
    private String updateUser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnionPayOrderNo() {
        return unionPayOrderNo;
    }

    public void setUnionPayOrderNo(String unionPayOrderNo) {
        this.unionPayOrderNo = unionPayOrderNo;
    }

    public String getMainOrderNo() {
        return mainOrderNo;
    }

    public void setMainOrderNo(String mainOrderNo) {
        this.mainOrderNo = mainOrderNo;
    }

    public String getChildOrderNo() {
        return childOrderNo;
    }

    public void setChildOrderNo(String childOrderNo) {
        this.childOrderNo = childOrderNo;
    }

    public Integer getChildOrderType() {
        return childOrderType;
    }

    public void setChildOrderType(Integer childOrderType) {
        this.childOrderType = childOrderType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPayFailReason() {
        return payFailReason;
    }

    public void setPayFailReason(String payFailReason) {
        this.payFailReason = payFailReason;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaySerialNo() {
        return paySerialNo;
    }

    public void setPaySerialNo(String paySerialNo) {
        this.paySerialNo = paySerialNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}
