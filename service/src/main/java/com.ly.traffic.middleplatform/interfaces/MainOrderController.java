package com.ly.traffic.middleplatform.interfaces;

import com.alibaba.fastjson.JSON;
import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.repository.OrderRepository;
import com.ly.traffic.middleplatform.domain.order.repository.po.MainOrderPO;
import com.ly.traffic.middleplatform.interfaces.dto.CreateOrderRequestDto;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 主订单表(MainOrderPO)表控制层
 *
 * @author makejava
 * @since 2020-08-07 17:29:26
 */
@RestController
@RequestMapping(value="order")
public class MainOrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderRepository orderRepository;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value="/selectOne", method=RequestMethod.GET)
    public MainOrderPO selectOne(@RequestParam Integer id) {
        MainOrderPO MainOrderPO = this.orderRepository.queryById(id);
        System.out.println(JSON.toJSONString(MainOrderPO));
        return MainOrderPO;
    }

    @RequestMapping(value="/selectOne2", method=RequestMethod.POST)
    public MainOrderPO selectOnePost(@RequestBody OrderAggregate order) {
        MainOrderPO MainOrderPO = this.orderRepository.queryById(order.getId());
        System.out.println(JSON.toJSONString(MainOrderPO));
        return MainOrderPO;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public int save(@RequestBody CreateOrderRequestDto order) {
        System.out.println(JSON.toJSONString(order));
        OrderAggregate orderAggregate = OrderFactory.dtoToDo(order);

        int count = this.orderRepository.insert(orderAggregate);
        return count;
    }

}
