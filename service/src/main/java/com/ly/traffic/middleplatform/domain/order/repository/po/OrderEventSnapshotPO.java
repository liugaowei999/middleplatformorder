package com.ly.traffic.middleplatform.domain.order.repository.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 订单事件快照记录表(OrderEventSnapshot)实体类
 *
 * @author gaowei.liu
 * @since 2020-05-11 11:08:51
 */
@Data
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class OrderEventSnapshotPO {
    /**
    * 自增id
    */
    private Long id;
    /**
    * 事件唯一标识ID
    */
    private String eventId;
    /**
    * 事件发生时间
    */
    private Date eventTime;
    /**
    * 事件源
    */
    private String source;
    /**
    * 事件内容
    */
    private String content;
    /**
    * 事件类型
    */
    private String eventType;
    /**
    * 版本号
    */
    private Integer version;
    /**
    * 创建人
    */
    private String createUser;
    /**
    * 创建时间
    */
    private Date createTime;

}
