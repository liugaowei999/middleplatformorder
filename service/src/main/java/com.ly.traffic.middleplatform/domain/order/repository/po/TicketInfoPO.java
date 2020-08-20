package com.ly.traffic.middleplatform.domain.order.repository.po;

import java.io.Serializable;

/**
 * 票信息表(TicketInfoPO)实体类
 *
 * @author makejava
 * @since 2020-08-20 14:11:35
 */
public class TicketInfoPO implements Serializable {
    private static final long serialVersionUID = -45024798797522577L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 票记录信息流水号
    */
    private String ticketSerial;
    /**
    * 客票号/取票号
    */
    private String ticketNo;
    /**
    * 车票价格
    */
    private Double ticketPrice;
    /**
    * 车厢号
    */
    private String carriageNo;
    /**
    * 座位号(有多个乘客时,会用逗号分隔)
    */
    private String seatNo;
    /**
    * 座位类别:1：硬座 2：软座 3：一等座 4：二等座 5：硬卧上铺 6：硬卧中铺 7：硬卧下铺 8：软卧上铺 9：软卧下铺 10：无座 11：商务座 12：特等座13::其它14::高级软卧
    */
    private Integer seatClass;
    /**
    * 取票信息
    */
    private String sms;
    /**
    * 取票密码
    */
    private String ticketPassword;
    /**
    * 取票验证码
    */
    private String ticketVerifyCode;
    /**
    * 取票网站订单号
    */
    private String ticketOrderNum;
    /**
    * 取票手机号
    */
    private String ticketPhone;
    /**
    * 检票口
    */
    private String checkinNos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketSerial() {
        return ticketSerial;
    }

    public void setTicketSerial(String ticketSerial) {
        this.ticketSerial = ticketSerial;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getCarriageNo() {
        return carriageNo;
    }

    public void setCarriageNo(String carriageNo) {
        this.carriageNo = carriageNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Integer getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(Integer seatClass) {
        this.seatClass = seatClass;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getTicketPassword() {
        return ticketPassword;
    }

    public void setTicketPassword(String ticketPassword) {
        this.ticketPassword = ticketPassword;
    }

    public String getTicketVerifyCode() {
        return ticketVerifyCode;
    }

    public void setTicketVerifyCode(String ticketVerifyCode) {
        this.ticketVerifyCode = ticketVerifyCode;
    }

    public String getTicketOrderNum() {
        return ticketOrderNum;
    }

    public void setTicketOrderNum(String ticketOrderNum) {
        this.ticketOrderNum = ticketOrderNum;
    }

    public String getTicketPhone() {
        return ticketPhone;
    }

    public void setTicketPhone(String ticketPhone) {
        this.ticketPhone = ticketPhone;
    }

    public String getCheckinNos() {
        return checkinNos;
    }

    public void setCheckinNos(String checkinNos) {
        this.checkinNos = checkinNos;
    }

}
