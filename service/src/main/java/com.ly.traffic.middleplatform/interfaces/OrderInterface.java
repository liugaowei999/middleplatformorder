package com.ly.traffic.middleplatform.interfaces;

import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.repository.po.MainOrderPO;
import com.ly.traffic.middleplatform.infrastructure.common.Result;
import com.ly.traffic.middleplatform.infrastructure.common.ResultCode;
import com.ly.traffic.middleplatform.interfaces.check.ParamCheck;
import com.ly.traffic.middleplatform.interfaces.dto.CreateOrderRequestDto;
import com.ly.traffic.middleplatform.service.OrderApplicationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单接口层
 *
 * @author liugw
 */
@RestController
@RequestMapping(value="order")
public class OrderInterface {
    /**
     * 服务对象
     */
    @Resource
    private OrderApplicationService orderApplicationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value="/selectOne", method=RequestMethod.GET)
    public Result queryById(@RequestParam Integer id) {
        Result result = new Result(ResultCode.OK);
        MainOrderPO mainOrderPO = orderApplicationService.queryById(id);
        result.setData(mainOrderPO);
        return result;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public Result createOrder(@RequestBody CreateOrderRequestDto order) {
        Result result = new Result(ResultCode.OK);
        result.setMsg("创建订单成功！");
        // check
        if (ParamCheck.isNotValid(order)) {
            result.setFail(ResultCode.PARAM_INVALID.val(), "参数非法！");
            return result;
        }
        int count = 0;
        try {
            count = orderApplicationService.createOrder(order);
        } catch (Exception e) {
            result.setMsg("创建订单失败！reason:" + e.getMessage());
            return result;
        }
        if (count <= 0) {
            result.setMsg("创建订单失败！");
        }
        return result;
    }

}
