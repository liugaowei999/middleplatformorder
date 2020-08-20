package com.ly.traffic.middleplatform.domain.createorder.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 汽车行程信息表(BusTripInfoPO)
 *
 * @author gaowei.liu
 * @since 2020-08-20 14:11:35
 */
@Getter
@Setter
public class BusTripInfoVO extends TripInfoVO {
    /**
    * 出发城市
    */
    private String fromCity;
    /**
    * 出发城市id
    */
    private Integer fromCityId;
    /**
    * 到达城市id
    */
    private Integer toCityId;
    /**
    * 到达城市
    */
    private String toCity;
    /**
    * 出发地经纬度
    */
    private String startLatlon;
    /**
    * 出发地名称
    */
    private String fromPlace;
    /**
    * 出发详细地址
    */
    private String startAddress;
    /**
    * 到达地经纬度
    */
    private String endLatlon;
    /**
    * 到达地名称
    */
    private String toPlace;
    /**
    * 到达地详细地址
    */
    private String endAddress;
    /**
    * 出发时间
    */
    private Date startDateTime;
    /**
    * 到达时间
    */
    private Date endDateTime;
    /**
    * 行程时长,单位分钟
    */
    private String bothTime;
    /**
    * 始发站
    */
    private String departureStation;
    /**
    * 始发站代码
    */
    private String departureStationCode;
    /**
    * 到达站
    */
    private String arrivalStation;
    /**
    * 到达站代码
    */
    private String arrivalStationCode;
    /**
    * 班次号
    */
    private String scheduleNo;
    /**
    * 汽车车次号
    */
    private String busNo;
    /**
    * 车型名称
    */
    private String transportType;
    /**
    * 班次编码
    */
    private String scheduleId;
    /**
    * 服务费id
    */
    private Integer serviceChargeId;
    /**
    * 服务费类型
    */
    private String serviceChargeType;
    /**
    * 是否流水班次
    */
    private Integer runningSchFlag;
    /**
    * 是否支持在线退票:1支持，2不支持
    */
    private Integer canRefund;
    /**
    * 发车前最晚可发起退票时间（分钟）： 值为60则表示发车前60分钟才能发起退票
    */
    private Integer refundBeforeDepart;
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
