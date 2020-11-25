package com.ly.traffic.middleplatform.domain.cancelorder.entity;

import com.ly.traffic.middleplatform.apt.annotation.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 取消订单订单表(CancelOrderPO)实体类
 *
 * @author makejava
 * @since 2020-08-24 19:37:09
 */
@Getter
@Setter
@Entity
public class CancelOrder {
    /**
    * 订单自增ID（主键）
    */
    private Integer id;
    /**
    * 要取消的主订单流水号
    */
    private String mainOrderNo;
    /**
    * 类型: 0-用户主动取消，1-支付超时系统取消
    */
    private Integer type;
    /**
    * 取消订单处理状态: 0-申请取消，1-取消中，2-取消成功， 3-取消失败
    */
    private Integer status;
    /**
    * 取消原因code -1:其它原因  0：直接取消，没选原因
    */
    private Integer reasoncode;
    /**
    * 申请取消原因
    */
    private String reason;
    /**
    * 取消订单失败原因
    */
    private String rejectreason;
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
    * 取消申请时间
    */
    private Date applytime;
    /**
    * 创建日期
    */
    private Date createdate;
    /**
    * 创建人
    */
    private String createuser;
    /**
    * 更新日期
    */
    private Date updatedate;
    /**
    * 更新人
    */
    private String updateuser;


}
