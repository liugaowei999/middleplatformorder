package com.ly.traffic.middleplatform.domain.createorder.repository.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单出行信息表(TripOrderInfoPO)实体类
 *
 * @author makejava
 * @since 2020-08-20 14:11:35
 */
public class TripOrderInfoPO implements Serializable {
    private static final long serialVersionUID = -43104349099087898L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 主订单流水号
    */
    private String mainOrderNo;
    /**
    * 出行订单流水号
    */
    private String tripOrderNo;
    /**
    * 关联具体的行程信息：行程流水号
    */
    private String tripSerial;
    /**
    * 此订单在行程中的顺序(默认0)
    */
    private Integer indexNo;
    /**
    * 订单类型: 1-火车票, 2-用车, 3-飞机, 4-汽车, 7-火车抢票 8-电子客票 9-港铁
    */
    private Integer orderType;
    /**
    * 付款状态 0：未付款 1：已付款
    */
    private Integer payStatus;
    /**
    * 订单状态:10-待支付,11-支付中| 20-待占座,21-占座中,22-占座成功,23-占座失败| 30-待出票,31-出票中,32-出票完成,33-出票失败| 62-用户取消,63-过期取消|91-下单失败
    */
    private Integer orderStatus;
    /**
    * 是否已出行 0-未出行 1-已出行
    */
    private Integer travelFlag;
    /**
    * 票价单价
    */
    private Double ticketUnitPrice;
    /**
    * 票价总额: 票价单价*人数 + 服务费单价*人数
    */
    private Double ticketTotalPrice;
    /**
    * 服务费单价
    */
    private Double serviceUnitPrice;
    /**
    * 服务费总额
    */
    private Double serviceTotalPrice;
    /**
    * 供应商id
    */
    private String supplierId;
    /**
    * 是否合单支付: 0--非合单支付, 1--合单支付
    */
    private Integer unionPay;
    /**
    * 微信代扣状态 0-微信支付 1，2-微信代扣 3-微信代扣转微信支付
    */
    private Integer withHoldStatus;
    /**
    * 代扣失败原因
    */
    private String withHoldFailReason;
    /**
    * 申请占座时间
    */
    private Date applyPlaceTime;
    /**
    * 占座回写时间
    */
    private Date placeCallbackTime;
    /**
    * 申请出票时间
    */
    private Date applyIssueTime;
    /**
    * 出票时间
    */
    private Date issueTime;
    /**
    * 占座或出票失败原因
    */
    private String rejectApplyRemark;
    /**
    * 扩展信息
    */
    private String extendContent;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainOrderNo() {
        return mainOrderNo;
    }

    public void setMainOrderNo(String mainOrderNo) {
        this.mainOrderNo = mainOrderNo;
    }

    public String getTripOrderNo() {
        return tripOrderNo;
    }

    public void setTripOrderNo(String tripOrderNo) {
        this.tripOrderNo = tripOrderNo;
    }

    public String getTripSerial() {
        return tripSerial;
    }

    public void setTripSerial(String tripSerial) {
        this.tripSerial = tripSerial;
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getTravelFlag() {
        return travelFlag;
    }

    public void setTravelFlag(Integer travelFlag) {
        this.travelFlag = travelFlag;
    }

    public Double getTicketUnitPrice() {
        return ticketUnitPrice;
    }

    public void setTicketUnitPrice(Double ticketUnitPrice) {
        this.ticketUnitPrice = ticketUnitPrice;
    }

    public Double getTicketTotalPrice() {
        return ticketTotalPrice;
    }

    public void setTicketTotalPrice(Double ticketTotalPrice) {
        this.ticketTotalPrice = ticketTotalPrice;
    }

    public Double getServiceUnitPrice() {
        return serviceUnitPrice;
    }

    public void setServiceUnitPrice(Double serviceUnitPrice) {
        this.serviceUnitPrice = serviceUnitPrice;
    }

    public Double getServiceTotalPrice() {
        return serviceTotalPrice;
    }

    public void setServiceTotalPrice(Double serviceTotalPrice) {
        this.serviceTotalPrice = serviceTotalPrice;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getUnionPay() {
        return unionPay;
    }

    public void setUnionPay(Integer unionPay) {
        this.unionPay = unionPay;
    }

    public Integer getWithHoldStatus() {
        return withHoldStatus;
    }

    public void setWithHoldStatus(Integer withHoldStatus) {
        this.withHoldStatus = withHoldStatus;
    }

    public String getWithHoldFailReason() {
        return withHoldFailReason;
    }

    public void setWithHoldFailReason(String withHoldFailReason) {
        this.withHoldFailReason = withHoldFailReason;
    }

    public Date getApplyPlaceTime() {
        return applyPlaceTime;
    }

    public void setApplyPlaceTime(Date applyPlaceTime) {
        this.applyPlaceTime = applyPlaceTime;
    }

    public Date getPlaceCallbackTime() {
        return placeCallbackTime;
    }

    public void setPlaceCallbackTime(Date placeCallbackTime) {
        this.placeCallbackTime = placeCallbackTime;
    }

    public Date getApplyIssueTime() {
        return applyIssueTime;
    }

    public void setApplyIssueTime(Date applyIssueTime) {
        this.applyIssueTime = applyIssueTime;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public String getRejectApplyRemark() {
        return rejectApplyRemark;
    }

    public void setRejectApplyRemark(String rejectApplyRemark) {
        this.rejectApplyRemark = rejectApplyRemark;
    }

    public String getExtendContent() {
        return extendContent;
    }

    public void setExtendContent(String extendContent) {
        this.extendContent = extendContent;
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
