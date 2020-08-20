package com.ly.traffic.middleplatform.domain.createorder.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 火车行程信息(TrainTripInfo)
 *
 * @author gaowei.liu
 * @since 2020-08-20 14:11:35
 */
@Getter
@Setter
public class TrainTripInfoVO  extends TripInfoVO {
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



}
