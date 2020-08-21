package com.ly.traffic.middleplatform.domain.order.repository;

import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.repository.po.MainOrderPO;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order.repository
 * @Description: ${TODO}
 * @date 2020/8/21 15:28
 */
public interface IOrderRepository {
    public int save(OrderAggregate orderAggregate);
    public MainOrderPO queryById(Integer id);
}
