package com.ly.traffic.middleplatform.domain.order.entity;

import lombok.Getter;

/**
 * 主订单表(MainOrderPO)实体类
 * @author gaowei.liu
 * @since 2020-08-07 17:29:26
 */
@Getter
public class UMainOrder extends MainOrder {
    /**
     * 扩展信息
     */
    private String extendcontent;
}
