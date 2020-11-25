package com.ly.traffic.middleplatform.service;

import com.ly.traffic.middleplatform.domain.order.event.publish.OrderEventPublish;
import com.ly.traffic.middleplatform.domain.order.repository.persistence.OrderRepository;
import com.ly.traffic.middleplatform.service.assembler.OrderAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.service
 * @Description: 订单应用服务
 * @date 2020/8/20 14:16
 */
@Slf4j
@Service
public class RefundTicketApplicationService {
    @Resource
    private OrderRepository orderRepository;

    @Resource
    private OrderEventPublish orderEventPublish;


}
