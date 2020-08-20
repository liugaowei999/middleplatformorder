package com.ly.traffic.middleplatform.domain.createorder.repository.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 火车行程信息表(TrainTripInfoPO)实体类
 *
 * @author makejava
 * @since 2020-08-20 14:11:35
 */
public class TrainTripInfoPO implements Serializable {
    private static final long serialVersionUID = -75271548414859183L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 行程流水号
    */
    private String tripSerial;
    /**
    * 列车班次号
    */
    private String trainNo;
    /**
    * 座位类别:1：硬座 2：软座 3：一等座 4：二等座 5：硬卧上铺 6：硬卧中铺 7：硬卧下铺 8：软卧上铺 9：软卧下铺 10：无座 11：商务座 12：特等座13::其它14::高级软卧
    */
    private Integer seatClass;
    /**
    * 发车代码
    */
    private String startStationCode;
    /**
    * 出发站名
    */
    private String startStationName;
    /**
    * 0 未知 1始 2过 3终
    */
    private Integer startStationState;
    /**
    * 到站代码
    */
    private String endStationCode;
    /**
    * 到站站名
    */
    private String endStationName;
    /**
    * 0 未知  1始  2经 3停
    */
    private Integer endStationState;
    /**
    * 是否夜间单:0--白天单（先占后付）,1--夜间单,2--先付后占
    */
    private Integer placeOrderForNight;
    /**
    * 自购票账号
    */
    private String userName;
    /**
    * 自购票密码（加密）
    */
    private String password;
    /**
    * 12306账户绑定手机号
    */
    private String bindPhone;
    /**
    * 在线选座坐席
    */
    private String chooseSeats;
    /**
    * 是否接受无座，0：不接受  1：接受
    */
    private Integer acceptnoseat;
    /**
    * 抢票截止时间
    */
    private Date grabEndTime;
    /**
    * 预售时间（预约单）
    */
    private String beginSaleTime;
    /**
    * 是否是自选车次 0-否 1-是
    */
    private Integer selfSelect;
    /**
    * 出发城市
    */
    private String fromCity;
    /**
    * 到达城市
    */
    private String toCity;
    /**
    * 发车时间（发车日期+时间）
    */
    private Date startDateTime;
    /**
    * 到站时间（到站日期+时间）
    */
    private Date endDateTime;
    /**
    * 出发城市id
    */
    private Integer fromCityId;
    /**
    * 到达城市id
    */
    private Integer toCityId;
    /**
    * 班次号
    */
    private String trafficNo;
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

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public Integer getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(Integer seatClass) {
        this.seatClass = seatClass;
    }

    public String getStartStationCode() {
        return startStationCode;
    }

    public void setStartStationCode(String startStationCode) {
        this.startStationCode = startStationCode;
    }

    public String getStartStationName() {
        return startStationName;
    }

    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    public Integer getStartStationState() {
        return startStationState;
    }

    public void setStartStationState(Integer startStationState) {
        this.startStationState = startStationState;
    }

    public String getEndStationCode() {
        return endStationCode;
    }

    public void setEndStationCode(String endStationCode) {
        this.endStationCode = endStationCode;
    }

    public String getEndStationName() {
        return endStationName;
    }

    public void setEndStationName(String endStationName) {
        this.endStationName = endStationName;
    }

    public Integer getEndStationState() {
        return endStationState;
    }

    public void setEndStationState(Integer endStationState) {
        this.endStationState = endStationState;
    }

    public Integer getPlaceOrderForNight() {
        return placeOrderForNight;
    }

    public void setPlaceOrderForNight(Integer placeOrderForNight) {
        this.placeOrderForNight = placeOrderForNight;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBindPhone() {
        return bindPhone;
    }

    public void setBindPhone(String bindPhone) {
        this.bindPhone = bindPhone;
    }

    public String getChooseSeats() {
        return chooseSeats;
    }

    public void setChooseSeats(String chooseSeats) {
        this.chooseSeats = chooseSeats;
    }

    public Integer getAcceptnoseat() {
        return acceptnoseat;
    }

    public void setAcceptnoseat(Integer acceptnoseat) {
        this.acceptnoseat = acceptnoseat;
    }

    public Date getGrabEndTime() {
        return grabEndTime;
    }

    public void setGrabEndTime(Date grabEndTime) {
        this.grabEndTime = grabEndTime;
    }

    public String getBeginSaleTime() {
        return beginSaleTime;
    }

    public void setBeginSaleTime(String beginSaleTime) {
        this.beginSaleTime = beginSaleTime;
    }

    public Integer getSelfSelect() {
        return selfSelect;
    }

    public void setSelfSelect(Integer selfSelect) {
        this.selfSelect = selfSelect;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
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

    public String getTrafficNo() {
        return trafficNo;
    }

    public void setTrafficNo(String trafficNo) {
        this.trafficNo = trafficNo;
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
