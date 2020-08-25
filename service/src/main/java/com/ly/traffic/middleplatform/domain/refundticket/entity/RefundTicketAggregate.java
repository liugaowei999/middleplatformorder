package com.ly.traffic.middleplatform.domain.refundticket.entity;

import com.ly.traffic.middleplatform.annotation.Aggregate;
import com.ly.traffic.middleplatform.annotation.ExcludeField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 退票订单表(RefundTicketOrderPO)实体类
 *
 * @author gaowei.liu
 * @since 2020-08-24 16:21:49
 */
@Data
@Aggregate
public class RefundTicketAggregate {
    /**
    * 订单自增ID（主键）
    */
    private Integer id;

    private RefundTicketOrder refundTicketOrder;

    public void createOrder() {

    }

    /**
     * 获取退票手续费
     * @return
     */
    public BigDecimal getRefundChargeAmount() {

        return BigDecimal.ZERO;
    }

    /**
     * 退票
     */
    public void refund() {

    }

}
