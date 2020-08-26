package com.ly.traffic.middleplatform.event;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.event
 * @Description: ${TODO}
 * @date 2020/7/22 15:32
 */
public enum EventType {
    /**
     * 事件定义
     */
    NEW_CREATED(0,"创单成功"),
    PAID_SUCCESS(12, "支付成功"),
    LOCK_SUCCESS(20, "锁定成功"),
    LOCK_FAILED(21, "锁定失败"),
    CANCELED(62, "订单已取消"),
    ;


    private int type;
    private String name;

    EventType(int type, String name) {
        this.name = name;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
