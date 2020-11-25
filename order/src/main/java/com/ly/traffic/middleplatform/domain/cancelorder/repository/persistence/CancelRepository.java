package com.ly.traffic.middleplatform.domain.cancelorder.repository.persistence;

import com.ly.traffic.middleplatform.domain.cancelorder.entity.CancelAggregate;
import com.ly.traffic.middleplatform.domain.cancelorder.entity.CancelOrder;
import com.ly.traffic.middleplatform.domain.cancelorder.factory.CancelOrderFactory;
import com.ly.traffic.middleplatform.domain.cancelorder.repository.ICancelRepository;
import com.ly.traffic.middleplatform.domain.cancelorder.repository.mapper.CancelOrderMapper;
import com.ly.traffic.middleplatform.domain.cancelorder.repository.po.CancelOrderPO;
import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.refundticket.repository.IRefundRepository;
import com.ly.traffic.middleplatform.domain.refundticket.repository.po.RefundTicketOrderPO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.refundticket.repository.persistence
 * @Description: ${TODO}
 * @date 2020/8/24 17:23
 */
@Component
public class CancelRepository implements ICancelRepository {
    @Resource
    private CancelOrderMapper cancelOrderMapper;

    @Override
    public int save(CancelAggregate cancelAggregate) {
        CancelOrderPO cancelOrderPO = CancelOrderFactory.getCancelOrderPO(cancelAggregate);
        if (cancelOrderPO == null) {
            return 0;
        }
        return cancelOrderMapper.insert(cancelOrderPO);
    }

    @Override
    public CancelOrderPO queryById(Integer id) {
        return null;
    }
}
