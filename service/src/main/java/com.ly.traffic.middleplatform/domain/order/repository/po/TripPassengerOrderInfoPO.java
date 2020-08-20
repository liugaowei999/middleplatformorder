package com.ly.traffic.middleplatform.domain.order.repository.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 乘客行程信息表(TripPassengerOrderInfoPO)实体类
 *
 * @author makejava
 * @since 2020-08-20 14:11:35
 */
public class TripPassengerOrderInfoPO implements Serializable {
    private static final long serialVersionUID = 904386893143175383L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 主订单流水号
    */
    private String mainOrderInfo;
    /**
    * 出行订单流水号
    */
    private String tripOrderNo;
    /**
    * 出行订单流水号
    */
    private String passengerOrderNo;
    /**
    * 关联具体的行程信息：行程流水号
    */
    private String tripSerial;
    /**
    * 车票的状态 0:未出票 1:已出票
    */
    private Integer ticketFlag;
    /**
    * 对应乘客流水号
    */
    private String passengerSerialNo;
    /**
    * 乘客姓名
    */
    private String passengerName;
    /**
    * 乘客类型:1:成人 2:儿童 3:学生
    */
    private Integer passengerType;
    /**
    * 证件类型:(0:其他,1:身份证,2:护照,3:台胞证,4:港澳通行证)
    */
    private Integer certificateType;
    /**
    * 证件号码
    */
    private String certificateNo;
    /**
    * 性别 1 男性 2女性 0 未知
    */
    private Integer sex;
    /**
    * 票记录信息流水号
    */
    private String ticketSerial;
    /**
    * 票信息摘要
    */
    private String ticketSummary;
    /**
    * 退票状态：0默认，1受理中，2受理完成，3驳回退票，4无法线上退票
    */
    private String refundStatus;
    /**
    * 是否改签单 0：正常订单，1：改签单
    */
    private Integer isChangeTicket;
    /**
    * 当前订单改签类型：0:改签前订单 1:改签后新订单
    */
    private Integer orderChangeType;
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

    public String getMainOrderInfo() {
        return mainOrderInfo;
    }

    public void setMainOrderInfo(String mainOrderInfo) {
        this.mainOrderInfo = mainOrderInfo;
    }

    public String getTripOrderNo() {
        return tripOrderNo;
    }

    public void setTripOrderNo(String tripOrderNo) {
        this.tripOrderNo = tripOrderNo;
    }

    public String getPassengerOrderNo() {
        return passengerOrderNo;
    }

    public void setPassengerOrderNo(String passengerOrderNo) {
        this.passengerOrderNo = passengerOrderNo;
    }

    public String getTripSerial() {
        return tripSerial;
    }

    public void setTripSerial(String tripSerial) {
        this.tripSerial = tripSerial;
    }

    public Integer getTicketFlag() {
        return ticketFlag;
    }

    public void setTicketFlag(Integer ticketFlag) {
        this.ticketFlag = ticketFlag;
    }

    public String getPassengerSerialNo() {
        return passengerSerialNo;
    }

    public void setPassengerSerialNo(String passengerSerialNo) {
        this.passengerSerialNo = passengerSerialNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Integer getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(Integer passengerType) {
        this.passengerType = passengerType;
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTicketSerial() {
        return ticketSerial;
    }

    public void setTicketSerial(String ticketSerial) {
        this.ticketSerial = ticketSerial;
    }

    public String getTicketSummary() {
        return ticketSummary;
    }

    public void setTicketSummary(String ticketSummary) {
        this.ticketSummary = ticketSummary;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getIsChangeTicket() {
        return isChangeTicket;
    }

    public void setIsChangeTicket(Integer isChangeTicket) {
        this.isChangeTicket = isChangeTicket;
    }

    public Integer getOrderChangeType() {
        return orderChangeType;
    }

    public void setOrderChangeType(Integer orderChangeType) {
        this.orderChangeType = orderChangeType;
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
