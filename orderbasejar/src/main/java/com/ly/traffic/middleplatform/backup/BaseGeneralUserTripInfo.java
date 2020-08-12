package com.ly.traffic.middleplatform.backup;

import lombok.Data;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order.entity.requirement
 * @Description: ${TODO}
 * @date 2020/7/7 10:36
 */
@Data
public class BaseGeneralUserTripInfo {
    //0 未知 1始 2过 3终
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

    public static void main(String[] args) {
        BaseGeneralUserTripInfo baseGeneralUserTripInfo = new BaseGeneralUserTripInfo();
        baseGeneralUserTripInfo.getFromCity();
    }
}
