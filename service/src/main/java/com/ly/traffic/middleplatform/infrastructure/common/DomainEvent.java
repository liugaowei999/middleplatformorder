package com.ly.traffic.middleplatform.infrastructure.common;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
public class DomainEvent {

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

    public DomainEvent setId(String id) {
        this.id = id;
        return this;
    }

    public DomainEvent setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public DomainEvent setSource(String source) {
        this.source = source;
        return this;
    }

    public DomainEvent setDataSnapshot(String dataSnapshot) {
        this.dataSnapshot = dataSnapshot;
        return this;
    }
}
