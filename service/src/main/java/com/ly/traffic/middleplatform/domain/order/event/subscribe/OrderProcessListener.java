package com.ly.traffic.middleplatform.domain.order.event.subscribe;

import com.alibaba.fastjson.JSONObject;
import com.google.common.eventbus.Subscribe;
import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.repository.persistence.OrderRepository;
import com.ly.traffic.middleplatform.domain.order.service.OrderDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order.event.subscribe
 * @Description: ${TODO}
 * @date 2020/8/26 15:05
 */
@Service
public class OrderProcessListener {
    @Resource
    private OrderDomainService orderDomainService;

    @Resource
    private OrderRepository orderRepository;
    /**
     * 更新支付信息
     */
    @Subscribe
    public void updateOrderPayInfo(String jsonStr) {
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String mainOrderNo = jsonObject.getString("mainOrderNo");
        String unionPayOrderNo = jsonObject.getString("unionPayOrderNo");

        // 获取购买订单聚合根信息
        OrderAggregate orderAggregate = orderRepository.queryByMainOrderNo(mainOrderNo);
        if (orderAggregate.isCanceled()) {
            // 订单已取消， 走退款
        }
        // 更新支付信息 paidInfoDto
        try {
            orderDomainService.updatePayInfo(orderAggregate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
