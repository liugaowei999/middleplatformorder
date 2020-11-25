package com.ly.traffic.middleplatform.domain.refundticket.repository.persistence;

import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.refundticket.repository.IRefundRepository;
import com.ly.traffic.middleplatform.domain.refundticket.repository.po.RefundTicketOrderPO;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.refundticket.repository.persistence
 * @Description: ${TODO}
 * @date 2020/8/24 17:23
 */
public class RefundRepository implements IRefundRepository {
    @Override
    public int save(OrderAggregate orderAggregate) {
        return 0;
    }

    @Override
    public RefundTicketOrderPO queryById(Integer id) {
        return null;
    }
}
