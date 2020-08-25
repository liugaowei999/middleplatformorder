package com.ly.traffic.middleplatform.domain.payment.repository;

import com.ly.traffic.middleplatform.domain.cancelorder.entity.CancelAggregate;
import com.ly.traffic.middleplatform.domain.cancelorder.repository.po.CancelOrderPO;
import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.repository.po.MainOrderPO;
import com.ly.traffic.middleplatform.domain.payment.entity.PayWriteBackLog;
import com.ly.traffic.middleplatform.domain.payment.repository.po.PayWriteBackLogPO;
import com.ly.traffic.middleplatform.domain.refundticket.repository.po.RefundTicketOrderPO;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order.repository
 * @Description:  支付回写日志记录仓储
 * @date 2020/8/21 15:28
 */
public interface IPayRepository {
    public int save(PayWriteBackLog payWriteBackLog);
    public PayWriteBackLogPO queryById(Integer id);
}
