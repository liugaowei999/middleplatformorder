package com.ly.traffic.middleplatform.domain.order.entity;

import com.ly.traffic.middleplatform.apt.annotation.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付任务订单表(PayOrderInfoPO)实体类
 *
 * @author liugw
 * @since 2020-08-25 18:22:05
 */
@Getter
@Setter
@Entity
public class PayOrderInfo {
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

}
