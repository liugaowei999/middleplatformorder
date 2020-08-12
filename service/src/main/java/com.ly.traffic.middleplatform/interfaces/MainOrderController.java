package com.ly.traffic.middleplatform.interfaces;

import com.alibaba.fastjson.JSON;
import com.ly.traffic.middleplatform.domain.order.repository.po.UMainOrderPO;
import com.ly.traffic.middleplatform.domain.order.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 主订单表(UMainOrderPO)表控制层
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
    public UMainOrderPO selectOne(@RequestParam Integer id) {
        UMainOrderPO UMainOrderPO = this.orderRepository.queryById(id);
        System.out.println(JSON.toJSONString(UMainOrderPO));
        return UMainOrderPO;
    }

    @RequestMapping(value="/selectOne2", method=RequestMethod.POST)
    public UMainOrderPO selectOnePost(@RequestBody UMainOrderPO order) {
        UMainOrderPO UMainOrderPO = this.orderRepository.queryById(order.getId());
        System.out.println(JSON.toJSONString(UMainOrderPO));
        return UMainOrderPO;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public UMainOrderPO save(@RequestBody UMainOrderPO order) {
        UMainOrderPO UMainOrderPO = this.orderRepository.insert(order);
        System.out.println(JSON.toJSONString(UMainOrderPO));
        return UMainOrderPO;
    }

}
