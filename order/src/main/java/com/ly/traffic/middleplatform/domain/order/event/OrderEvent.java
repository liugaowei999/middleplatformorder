package com.ly.traffic.middleplatform.domain.order.event;

import com.ly.traffic.middleplatform.event.EventType;
import com.ly.traffic.middleplatform.infrastructure.common.DomainEvent;
import com.ly.traffic.middleplatform.infrastructure.util.EventIdGenerator;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author liugw
 * @Package com.ly.intercity.motor.ddd.order.domain.order.event
 * @Description: 订单领域事件类
 * @date 2020/8/20 13:43
 */
@Data
public class OrderEvent extends DomainEvent {
    private EventType eventType;
    private String orderNo;
    Integer bypassId;
    private int version = 1;

    private OrderEvent() {}

    public static OrderEvent create() {
        return create(StringUtils.EMPTY);
    }
    public static OrderEvent create(String module) {
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setId(EventIdGenerator.nextId(module));
        orderEvent.setSource("order");
        return orderEvent;
    }

    @Override
    public OrderEvent setTimestamp(Date timestamp) {
        super.setTimestamp(timestamp);
        return this;
    }

    @Override
    public OrderEvent setSource(String source) {
        super.setSource(source);
        return this;
    }

    @Override
    public OrderEvent setDataSnapshot(String dataSnapshot) {
        super.setDataSnapshot(dataSnapshot);
        return this;
    }

    public OrderEvent setEventType(EventType eventType) {
        this.eventType = eventType;
        return this;
    }

    public OrderEvent setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public OrderEvent setBypassId(Integer bypassId) {
        this.bypassId = bypassId;
        return this;
    }
}
