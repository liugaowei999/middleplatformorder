package com.ly.traffic.middleplatform.domain.order.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order.entity
 * @Description: ${TODO}
 * @date 2020/8/11 16:55
 */
@Getter
@Setter
public class TripOrder {
    /**
     * 订单自增ID（主键）
     */
    private Integer id;
    /**
     * 主订单流水号
     */
    private String orderno;

    private String tripOrderNo;

    private String shiftNo;

    //0未知 1始 2过 3终
    private String startStationState;
    private String endStationState;
    /**
     * 出发站（中文）
     */
    private String fromCity;

    /**
     * 出发时间
     */
    private String fromDateTime;

    /**
     * 出发站（拼音）
     */
    private String fromCityPy;
    /**
     * 到达站（中文）
     */
    private String toCity;
    /**
     * 到达站（拼音）
     */
    private String toCityPy;
    /**
     * 到达时间
     */
    private String toDateTime;
}
