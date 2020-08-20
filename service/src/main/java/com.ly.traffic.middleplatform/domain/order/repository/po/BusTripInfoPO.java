package com.ly.traffic.middleplatform.domain.createorder.repository.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 汽车行程信息表(BusTripInfoPO)实体类
 *
 * @author makejava
 * @since 2020-08-20 14:11:35
 */
public class BusTripInfoPO implements Serializable {
    private static final long serialVersionUID = 837754662913195538L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 行程流水号
    */
    private String tripSerial;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTripSerial() {
        return tripSerial;
    }

    public void setTripSerial(String tripSerial) {
        this.tripSerial = tripSerial;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public Integer getFromCityId() {
        return fromCityId;
    }

    public void setFromCityId(Integer fromCityId) {
        this.fromCityId = fromCityId;
    }

    public Integer getToCityId() {
        return toCityId;
    }

    public void setToCityId(Integer toCityId) {
        this.toCityId = toCityId;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getStartLatlon() {
        return startLatlon;
    }

    public void setStartLatlon(String startLatlon) {
        this.startLatlon = startLatlon;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndLatlon() {
        return endLatlon;
    }

    public void setEndLatlon(String endLatlon) {
        this.endLatlon = endLatlon;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getBothTime() {
        return bothTime;
    }

    public void setBothTime(String bothTime) {
        this.bothTime = bothTime;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getDepartureStationCode() {
        return departureStationCode;
    }

    public void setDepartureStationCode(String departureStationCode) {
        this.departureStationCode = departureStationCode;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getArrivalStationCode() {
        return arrivalStationCode;
    }

    public void setArrivalStationCode(String arrivalStationCode) {
        this.arrivalStationCode = arrivalStationCode;
    }

    public String getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(String scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getServiceChargeId() {
        return serviceChargeId;
    }

    public void setServiceChargeId(Integer serviceChargeId) {
        this.serviceChargeId = serviceChargeId;
    }

    public String getServiceChargeType() {
        return serviceChargeType;
    }

    public void setServiceChargeType(String serviceChargeType) {
        this.serviceChargeType = serviceChargeType;
    }

    public Integer getRunningSchFlag() {
        return runningSchFlag;
    }

    public void setRunningSchFlag(Integer runningSchFlag) {
        this.runningSchFlag = runningSchFlag;
    }

    public Integer getCanRefund() {
        return canRefund;
    }

    public void setCanRefund(Integer canRefund) {
        this.canRefund = canRefund;
    }

    public Integer getRefundBeforeDepart() {
        return refundBeforeDepart;
    }

    public void setRefundBeforeDepart(Integer refundBeforeDepart) {
        this.refundBeforeDepart = refundBeforeDepart;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}
