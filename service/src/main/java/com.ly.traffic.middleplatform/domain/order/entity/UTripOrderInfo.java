package com.ly.traffic.middleplatform.domain.order.entity;

import com.ly.traffic.middleplatform.domain.createorder.entity.TripOrderInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order.entity
 * @Description: ${TODO}
 * @date 2020/8/21 10:42
 */
@Getter
@Setter
public class UTripOrderInfo extends TripOrderInfo {
    /**
    * 主订单流水号
    */
    private String mainOrderNo;

    /**
     * 关联具体的行程信息：行程流水号
     */
    private String tripSerial;

//    /**
//     * 乘客信息
//     */
//    private List<UTripPassengerOrderInfo> tripPassengerOrderInfoList;

    /**
    * 微信代扣状态 0-微信支付 1，2-微信代扣 3-微信代扣转微信支付
    */
    private Integer withHoldStatus;
    /**
    * 代扣失败原因
    */
    private String withHoldFailReason;
    /**
    * 申请占座时间
    */
    private Date applyPlaceTime;
    /**
    * 占座回写时间
    */
    private Date placeCallbackTime;
    /**
    * 申请出票时间
    */
    private Date applyIssueTime;
    /**
    * 出票时间
    */
    private Date issueTime;
    /**
    * 占座或出票失败原因
    */
    private String rejectApplyRemark;

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
    /**
     * 扩展信息
     */
    private String extendContent;
}
