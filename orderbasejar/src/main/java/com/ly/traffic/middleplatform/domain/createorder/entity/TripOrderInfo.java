package com.ly.traffic.middleplatform.domain.createorder.entity;

import com.ly.traffic.middleplatform.domain.createorder.vo.TripInfoVO;
import com.ly.traffic.middleplatform.utils.object.ObjectValue;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * 订单出行信息表(TripOrderInfoPO)实体类
 *
 *  已注释创单时不需要关心的属性 - 不对外暴露
 * @author gaowei.liu
 * @since 2020-08-20 14:11:35
 */
@Getter
@Setter
public class TripOrderInfo {
    /**
    * 自增id
    */
    private Long id;
//    /**
//    * 主订单流水号
//    */
//    private String mainOrderNo;

    /**
    * 出行订单流水号
    */
    private String tripOrderNo;

    /**
    * 关联具体的行程信息：行程流水号
    */
    private TripInfoVO tripInfoVO;

    /**
     * 乘客信息
     */
    private List<TripPassengerOrderInfo> tripPassengerOrderInfoList;

    /**
    * 此订单在行程中的顺序(默认0)
    */
    private Integer indexNo;
    /**
    * 订单类型: 1-火车票, 2-用车, 3-飞机, 4-汽车, 7-火车抢票 8-电子客票 9-港铁
    */
    private Integer orderType;
    /**
    * 付款状态 0：未付款 1：已付款
    */
    private Integer payStatus;
    /**
    * 订单状态:10-待支付,11-支付中| 20-待占座,21-占座中,22-占座成功,23-占座失败| 30-待出票,31-出票中,32-出票完成,33-出票失败| 62-用户取消,63-过期取消|91-下单失败
    */
    private Integer orderStatus;
    /**
    * 是否已出行 0-未出行 1-已出行
    */
    private Integer travelFlag;
    /**
    * 票价单价
    */
    private Double ticketUnitPrice;
    /**
    * 票价总额: 票价单价*人数 + 服务费单价*人数
    */
    private Double ticketTotalPrice;
    /**
    * 服务费单价
    */
    private Double serviceUnitPrice;
    /**
    * 服务费总额
    */
    private Double serviceTotalPrice;
    /**
    * 供应商id
    */
    private String supplierId;
    /**
    * 是否合单支付: 0--非合单支付, 1--合单支付
    */
    private Integer unionPay;
//    /**
//    * 微信代扣状态 0-微信支付 1，2-微信代扣 3-微信代扣转微信支付
//    */
//    private Integer withHoldStatus;
//    /**
//    * 代扣失败原因
//    */
//    private String withHoldFailReason;
//    /**
//    * 申请占座时间
//    */
//    private Date applyPlaceTime;
//    /**
//    * 占座回写时间
//    */
//    private Date placeCallbackTime;
//    /**
//    * 申请出票时间
//    */
//    private Date applyIssueTime;
//    /**
//    * 出票时间
//    */
//    private Date issueTime;
//    /**
//    * 占座或出票失败原因
//    */
//    private String rejectApplyRemark;
//
//    /**
//    * 创建日期
//    */
//    private Date createDate;
//    /**
//    * 创建人
//    */
//    private String createUser;
//    /**
//    * 更新日期
//    */
//    private Date updateDate;
//    /**
//    * 更新人
//    */
//    private String updateUser;

    private String translate() {
        try {
            return ObjectValue.getJSONString(this.getClass(), this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return super.toString();
    }
    @Override
    public String toString() {
        return translate();
    }

}
