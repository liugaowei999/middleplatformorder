package com.ly.traffic.middleplatform.domain.refundticket.repository.po;

import lombok.Data;

import java.util.Date;

/**
 * 退票订单表(RefundTicketOrderPO)实体类
 *
 * @author gaowei.liu
 * @since 2020-08-24 16:21:49
 */
@Data
public class RefundTicketOrderPO {
    /**
    * 订单自增ID（主键）
    */
    private Integer id;
    /**
    * 要退票的主订单流水号
    */
    private String mainOrderNo;
    /**
    * 要退票的票订单流水号
    */
    private String passengerOrderNo;
    /**
    * 票号
    */
    private String ticketNo;
    /**
    * 退票手续费
    */
    private Double refundCharge;
    /**
    * 退票订单处理状态: 0-申请退票，1-退票中，2-退票成功， 3-退票失败
    */
    private Integer status;
    /**
    * 退票原因code -1:其它原因  0：直接取消，没选原因
    */
    private Integer reasonCode;
    /**
    * 申请退票原因
    */
    private String reason;
    /**
    * 退票失败原因
    */
    private String rejectReason;
    /**
    * 会员id
    */
    private Integer memberId;
    /**
    * 记录用户unionId
    */
    private String unionId;
    /**
    * openId，微信平台订票时有值
    */
    private String openId;
    /**
    * 申请退票时间
    */
    private Date applyTime;
    /**
    * 0-默认  1-线上退 2-线下跑腿 3-线下车站
    */
    private Integer refundType;
    /**
    * 跑腿费结算金额
    */
    private Double runSettleFee;
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

}
