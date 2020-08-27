package com.ly.traffic.middleplatform.demo;

import com.ly.traffic.middleplatform.event.EventType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author liugw
 * @Package com.ly.intercity.motor.ddd.order.domain.order.event
 * @Description: 订单领域事件类
 * @date 2020/8/20 13:43
 */
@Getter
@Setter
public class OrderEvent {
    /**
     * 事件ID，全局唯一
     */
    String id;
    /**
     * 事件发生的时间
     */
    Date timestamp;
    /**
     * 事件源
     */
    String source;
    /**
     * 业务数据快照
     */
    String dataSnapshot;

    Integer bypassId;

    private EventType eventType;
    private String orderNo;
    private int version = 1;

    public static void main(String[] args) {
        Integer bypassId = 1015;
        System.out.println(bypassId & 1);
        System.out.println(bypassId % 2);
    }
}
