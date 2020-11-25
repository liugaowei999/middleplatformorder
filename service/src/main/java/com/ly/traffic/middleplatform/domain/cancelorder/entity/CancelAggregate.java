package com.ly.traffic.middleplatform.domain.cancelorder.entity;

import com.ly.traffic.middleplatform.apt.annotation.Aggregate;
import com.ly.traffic.middleplatform.domain.cancelorder.repository.persistence.CancelRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 退票订单表(RefundTicketOrderPO)实体类
 *
 * @author gaowei.liu
 * @since 2020-08-24 16:21:49
 */
@Getter
@Setter
@Aggregate
public class CancelAggregate {
    /**
     * 取消订单任务仓储
     */
    private CancelRepository cancelRepository;
    /**
    * 订单自增ID（主键）
    */
    private Integer id;

    private CancelOrder cancelOrder;

    public CancelAggregate(CancelRepository cancelRepository) {
        this.cancelRepository = cancelRepository;
    }

    public void setStatus(int cancelStatus) {
        cancelOrder.setStatus(cancelStatus);
    }

    /**
     * 当前订单是否可以取消
     * @return
     */
    public boolean canCancel() {

        return false;
    }


    /**
     * 异步发起取消任务
     */
    public void cancelTicketTaskAsync() {

    }

    public String getMainOrderNo() {
        return cancelOrder.getMainOrderNo();
    }

    public int save() {
        return cancelRepository.save(this);
    }
}
