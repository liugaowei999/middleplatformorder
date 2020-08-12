package com.ly.traffic.middleplatform.interfaces;

import com.alibaba.fastjson.JSON;
import com.ly.traffic.middleplatform.domain.order.repository.po.UMainOrder;
import com.ly.traffic.middleplatform.service.MainOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 主订单表(UMainOrder)表控制层
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
    private MainOrderService mainOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value="/selectOne", method=RequestMethod.GET)
    public UMainOrder selectOne(@RequestParam Integer id) {
        UMainOrder UMainOrder = this.mainOrderService.queryById(id);
        System.out.println(JSON.toJSONString(UMainOrder));
        return UMainOrder;
    }

    @RequestMapping(value="/selectOne2", method=RequestMethod.POST)
    public UMainOrder selectOnePost(@RequestBody UMainOrder order) {
        UMainOrder UMainOrder = this.mainOrderService.queryById(order.getId());
        System.out.println(JSON.toJSONString(UMainOrder));
        return UMainOrder;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public UMainOrder save(@RequestBody UMainOrder order) {
        UMainOrder UMainOrder = this.mainOrderService.insert(order);
        System.out.println(JSON.toJSONString(UMainOrder));
        return UMainOrder;
    }

}
