package com.ly.traffic.middleplatform.domain.createorder.entity;

import com.ly.traffic.middleplatform.utils.object.ObjectValue;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 乘客行程信息表(TripPassengerOrderInfoPO)实体类
 *
 * 已注释创单时不需要关心的属性 - 不对外暴露
 *
 * @author gaowei.liu
 * @since 2020-08-20 14:11:35
 */
@Getter
@Setter
public class TripPassengerOrderInfo {
    /**
    * 自增id
    */
    private Long id;
//    /**
//    * 主订单流水号
//    */
//    private String mainOrderNo;
//    /**
//    * 出行订单流水号
//    */
//    private String tripOrderNo;
//    /**
//    * 出行订单流水号
//    */
//    private String passengerOrderNo;

    /**
    * 车票的状态 0:未出票 1:已出票
    */
    private Integer ticketFlag;
//    /**
//    * 对应乘客流水号
//    */
//    private String passengerSerialNo;
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
//    /**
//    * 票记录信息流水号
//    */
//    private String ticketSerial;
//    /**
//    * 票信息摘要
//    */
//    private String ticketSummary;
//    /**
//    * 退票状态：0默认，1受理中，2受理完成，3驳回退票，4无法线上退票
//    */
//    private String refundStatus;
//    /**
//    * 是否改签单 0：正常订单，1：改签单
//    */
//    private Integer isChangeTicket;
//    /**
//    * 当前订单改签类型：0:改签前订单 1:改签后新订单
//    */
//    private Integer orderChangeType;
//    /**
//    * 创建日期
//    */
//    private Date createDate;
//    /**
//    * 创建人
//    */
//    private String createUser;
//    /**
//    * 更新日期
//    */
//    private Date updateDate;
//    /**
//    * 更新人
//    */
//    private String updateUser;

    private String translate() {
        try {
            return ObjectValue.getJSONString(this.getClass(), this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return super.toString();
    }
    @Override
    public String toString() {
        return translate();
    }
}
