package com.ly.traffic.train.domain.order.vo;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order.vo
 * @Description: ${TODO}
 * @date 2020/7/6 18:44
 */
public class ClientInfoVO {
    /**
     * 设备号
     */
    private String deviceNo;

    private String sessionId;

    /**
     * 微信OpenID
     */
    private String openID;

    private Integer refId;
    /**
     * 客户端IP地址
     */
    private String clientIp;

    /**
     * IP地址对应城市
     */
    private String ipCity;

    /**
     * 客户端版本号
     */
    private String appVision;

}
