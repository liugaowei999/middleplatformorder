package com.ly.traffic.middleplatform.domain.createorder.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 营销商品消费记录表(ResourceConsumerOrderPO)实体类
 *
 * @author makejava
 * @since 2020-08-20 14:11:36
 */
@Getter
@Setter
public class ResourceConsumerOrder {
    /**
    * id
    */
    private Long id;
    /**
    * 主订单号
    */
    private String mainorderno;
    /**
    * 优惠的行程订单号
    */
    private String triporderno;
    /**
    * 卡券ID
    */
    private String cardid;
    /**
    * 卡券编号
    */
    private String cardno;
    /**
    * 卡券类型 0：普通券 3：朋友券 4：火车票售卖代金券 5：退改无忧理赔代金券 6代金券红包
    */
    private Integer cardtype;
    /**
    * 会员id
    */
    private String memberid;
    /**
    * 状态 0-初始状态 1-已占用；2-已核销；30-占用失败 31-核销失败
    */
    private Integer usestatus;
    /**
    * 卡券消费失败原因
    */
    private String reason;
    /**
    * 占用时间
    */
    private Date occupytime;
    /**
    * 核销时间
    */
    private Date writeofftime;
    /**
    * 创建日期
    */
    private Date createtime;
    /**
    * 创建人
    */
    private String createuser;
    /**
    * 更新日期
    */
    private Date updatetime;
    /**
    * 更新人
    */
    private String updateuser;



}
