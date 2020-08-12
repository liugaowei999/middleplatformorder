package com.ly.traffic.middleplatform.backup;

import lombok.Data;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order.entity
 * @Description: ${TODO}
 * @date 2020/7/6 18:41
 */
@Data
public class BaseGeneralOrderBaseInfo {
    String	memberId;
    private String userName;

    private String passWord;
    private String tQueryKey;

    /**
     * 外部订单号，分销下单时需要
     */
    private String outOrderNo;

    /**
     * 1 邮寄保险 2 邮寄车票 3 邮寄保险和车票
     */
    private String postType;

    /**
     * 是否线上出票 0. 默认 线上出票 1. 线下出票
     */
    private int isOnlineTicket;

    /**
     * 是否接受分开下单
     * 0:不接受 1：接受
     */
    private int trainsformPurchaseStatus;
}
