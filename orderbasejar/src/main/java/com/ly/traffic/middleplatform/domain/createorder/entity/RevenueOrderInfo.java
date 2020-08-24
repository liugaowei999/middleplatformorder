package com.ly.traffic.middleplatform.domain.createorder.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 营收商品购买记录表(RevenueOrderInfoPO)实体类
 *
 * @author makejava
 * @since 2020-08-20 14:11:35
 */
@Getter
@Setter
public class RevenueOrderInfo {
    /**
    * id
    */
    private Long id;
    /**
    * 主订单号
    */
    private String mainorderno;
    /**
    * 营收商品订单号
    */
    private String revenueorderno;
    /**
    * 营收商品ID
    */
    private String goodsid;
    /**
    * 营收商品编码
    */
    private String goodscode;
    /**
    * 营收商品名称
    */
    private String goodsname;
    /**
    * 商品对应的资源编码
    */
    private String resourcecode;
    /**
    * 类型
    */
    private Integer type;
    /**
    * 会员id
    */
    private String memberid;
    /**
    * 状态 0-初始状态 1-已下单购买；2-已出库；3-已取消 40-购买失败 41-出库失败
    */
    private Integer status;
    /**
    * 失败原因
    */
    private String reason;
    /**
    * 购买时间
    */
    private Date buytime;
    /**
    * 出库时间
    */
    private Date activetime;
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
