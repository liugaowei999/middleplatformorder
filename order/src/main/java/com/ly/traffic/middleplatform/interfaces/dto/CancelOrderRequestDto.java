package com.ly.traffic.middleplatform.interfaces.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.interfaces.dto
 * @Description: 订单取消请求传输对象
 * @date 2020/8/25 11:52
 */
@Getter
@Setter
public class CancelOrderRequestDto {
    /**
     * 要取消的主订单流水号
     */
    private String mainOrderNo;

    /**
     * 类型: 0-用户主动取消，1-支付超时系统取消
     */
    private Integer type;

    /**
     * 取消原因code -1:其它原因  0：直接取消，没选原因
     */
    private Integer reasonCode;
    /**
     * 申请取消原因
     */
    private String reason;
    /**
     * 会员id
     */
    private Integer memberId;
    /**
     * 记录用户unionId
     */
    private String unionId;
    /**
     * openId，微信平台订票时有值
     */
    private String openId;
    /**
     * 取消申请时间
     */
    private Date applyTime;
}
