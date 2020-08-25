package com.ly.traffic.middleplatform.domain.cancelorder.repository;

import com.ly.traffic.middleplatform.domain.cancelorder.entity.CancelAggregate;
import com.ly.traffic.middleplatform.domain.cancelorder.repository.po.CancelOrderPO;
import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.repository.po.MainOrderPO;
import com.ly.traffic.middleplatform.domain.refundticket.repository.po.RefundTicketOrderPO;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order.repository
 * @Description: ${TODO}
 * @date 2020/8/21 15:28
 */
public interface ICancelRepository {
    public int save(CancelAggregate cancelAggregate);
    public CancelOrderPO queryById(Integer id);
}
