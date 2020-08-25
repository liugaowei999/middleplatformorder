package com.ly.traffic.middleplatform.interfaces.dto;

import java.util.Date;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.interfaces.dto
 * @Description: ${TODO}
 * @date 2020/8/25 17:05
 */
public class PaidInfoDto {
    /**
     * 合单支付订单号
     */
    private String unionPayOrderNo;

    /**
     * 状态: 3-支付成功
     */
    private Integer payCode;

    /**
     * 金额
     */
    private Double amount;
    /**
     * 统一支付流水号
     */
    private String paySerialNo;

}
