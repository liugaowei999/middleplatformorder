package com.ly.traffic.middleplatform.service;

import com.alibaba.fastjson.JSON;
import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.repository.persistence.OrderRepository;
import com.ly.traffic.middleplatform.domain.order.repository.po.MainOrderPO;
import com.ly.traffic.middleplatform.interfaces.assembler.OrderAssembler;
import com.ly.traffic.middleplatform.interfaces.dto.CreateOrderRequestDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.service
 * @Description: 订单应用服务
 * @date 2020/8/20 14:16
 */
@Service
public class OrderApplicationService {
    @Resource
    private OrderRepository orderRepository;

    public int createOrder(CreateOrderRequestDto order) throws Exception {
        OrderAggregate orderAggregate = OrderAssembler.dtoToDo(order);

        // 持久化方式1：
        orderAggregate.create();
        return orderRepository.save(orderAggregate);

        // 持久化方式2：不推荐
        // return orderAggregate.saveToDB(orderRepository);
    }

    public MainOrderPO queryById(Integer id) {
        MainOrderPO mainOrderPO = orderRepository.queryById(id);
        System.out.println(JSON.toJSONString(mainOrderPO));
        return mainOrderPO;
    }
}
