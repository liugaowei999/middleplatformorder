package com.ly.traffic.middleplatform.domain.changeticket.entity;

import com.ly.traffic.middleplatform.apt.annotation.Aggregate;
import com.ly.traffic.middleplatform.domain.createorder.entity.TripOrderInfo;
import com.ly.traffic.middleplatform.domain.createorder.vo.TripInfoVO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * 改签订单表(ChangeTicketOrder)实体类
 *
 * @author makejava
 * @since 2020-08-27 18:11:05
 */
@Aggregate
@Getter
@Setter
public class ChangeTicketOrder {
    /**
    * 订单自增ID（主键）
    */
    private Integer id;
    /**
    * 改签订单流水号
    */
    private String changeorderno;
    /**
    * 改签票类型：1：火车票 2：汽车票 3：飞机票
    */
    private Integer tickettype;
    /**
    * 改签类型：1：改签 2：变更到站
    */
    private Integer changetype;
    /**
    * 改签的主订单流水号
    */
    private String mainOrderNo;
    /**
    * 改签的行程订单流水号
    */
    private String tripOrderNo;
    /**
    * 改签的乘客订单流水号
    */
    private String passengerOrderNo;
    /**
    * 改签的票号（第三方）
    */
    private String ticketNo;

    /**
     * 新的行程信息
     */
    private TripInfoVO tripInfoVO;

    /**
    * 改签手续费
    */
    private Double changeticketcharge;
    /**
    * 改签差价（已扣除改签手续费），正数表示需补充的差价，负数表示需退还的差价
    */
    private Double changepricediff;
    /**
    * 退款唯一流水号（退款申请幂等检查）
    */
    private String refundserialid;
    /**
    * 改签订单处理状态: 0-申请改签，10-改签中，20-待用户确认， 30-改签占座成功 31:改签出票成功 40:改签失败
    */
    private Integer status;
    /**
    * 改签确认方式：0：用户确认 1：自动确认
    */
    private Integer autoconfirm;

    /**
    * 会员id
    */
    private Integer memberid;
    /**
    * 记录用户unionId
    */
    private String unionid;
    /**
    * openId，微信平台订票时有值
    */
    private String openid;
    /**
    * 改签的平台id   0-默认 1-CN站 2-COM站 434-安卓 433-IOS 432-Touch 501-微信火车票 577-葡萄网 625-火车票供应商回调测试 596-手Q 580-WindowsPh
    */
    private Integer platid;
    /**
    * 申请改签时间
    */
    private Date applytime;




}
