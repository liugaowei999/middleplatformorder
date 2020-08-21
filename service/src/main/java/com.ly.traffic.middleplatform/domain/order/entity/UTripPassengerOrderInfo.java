package com.ly.traffic.middleplatform.domain.order.entity;

import com.ly.traffic.middleplatform.domain.createorder.entity.TripPassengerOrderInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order.entity
 * @Description: ${TODO}
 * @date 2020/8/21 14:20
 */
@Getter
@Setter
public class UTripPassengerOrderInfo extends TripPassengerOrderInfo {
    /**
    * 主订单流水号
    */
    private String mainOrderNo;
    /**
    * 出行订单流水号
    */
    private String tripOrderNo;
    /**
    * 出行订单流水号
    */
    private String passengerOrderNo;

    /**
    * 对应乘客流水号
    */
    private String passengerSerialNo;
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

    /**
     * 扩展信息
     */
    private String extendContent;

}
