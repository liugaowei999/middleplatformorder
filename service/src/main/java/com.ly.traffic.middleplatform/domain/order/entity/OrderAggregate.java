package com.ly.traffic.middleplatform.domain.order.entity;


import lombok.Getter;

import java.util.List;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order
 * @Description: ${TODO}
 * @date 2020/7/6 15:00
 */
@Getter
public class OrderAggregate {
    private String orderSerialId;

    private UMainOrder uMainOrder;

    /**
     * MainOrder对象工厂方法
     * @return MainOrder对象
     */
    public UMainOrder getMainOrder() {
        return null;
    }
}
