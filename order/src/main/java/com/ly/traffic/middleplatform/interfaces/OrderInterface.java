package com.ly.traffic.middleplatform.interfaces;

import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.repository.po.MainOrderPO;
import com.ly.traffic.middleplatform.infrastructure.common.Result;
import com.ly.traffic.middleplatform.infrastructure.common.ResultCode;
import com.ly.traffic.middleplatform.interfaces.check.ParamCheck;
import com.ly.traffic.middleplatform.interfaces.dto.CancelOrderRequestDto;
import com.ly.traffic.middleplatform.interfaces.dto.CreateOrderRequestDto;
import com.ly.traffic.middleplatform.interfaces.dto.PaidInfoDto;
import com.ly.traffic.middleplatform.service.OrderApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单接口层
 *
 * @author liugw
 */
@Slf4j
@RestController
@RequestMapping(value="order")
public class OrderInterface {
    /**
     * 服务对象
     */
    @Resource
    private OrderApplicationService orderApplicationService;

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public Result createOrder(@RequestBody CreateOrderRequestDto order) {
        Result result = new Result(ResultCode.OK);
        result.setMsg("创建订单成功！订单号：" + order.getOrderNo());
        // check
        if (ParamCheck.isNotValid(order)) {
            result.setFail(ResultCode.PARAM_INVALID.val(), "参数非法！");
            return result;
        }
        int count = 0;
        try {
            count = orderApplicationService.createOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("创建订单失败！reason:" + e.getMessage());
            return result;
        }
        if (count <= 0) {
            result.setMsg("创建订单失败！");
        }
        return result;
    }

    @RequestMapping(value="/cancel", method=RequestMethod.POST)
    public Result cancelOrder(@RequestBody CancelOrderRequestDto cancelOrderRequestDto) {
        Result result = new Result(ResultCode.OK);
        // check
        if (ParamCheck.isNotValid(cancelOrderRequestDto)) {
            result.setFail(ResultCode.PARAM_INVALID.val(), "参数非法！");
            return result;
        }

        result = orderApplicationService.cancelOrder(cancelOrderRequestDto);

        return result;
    }

    /**
     * 支付回调模拟
     */
    @RequestMapping(value="/paidcallback", method=RequestMethod.POST)
    public Result paidcallback(@RequestBody PaidInfoDto paidInfoDto) {
        Result result = new Result(ResultCode.OK);

        try {
            result = orderApplicationService.payCallBack(paidInfoDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param orderNo 主键
     * @return 单条数据
     */
    @RequestMapping(value="/selectOne", method=RequestMethod.GET)
    public Result queryByOrderNo(@RequestParam String orderNo) {
        Result result = new Result(ResultCode.OK);
        MainOrderPO mainOrderPO = orderApplicationService.queryById(orderNo);
        result.setData(mainOrderPO);
        return result;
    }

    /**
     * 消费数据透传数据 模拟
     */
    @RequestMapping(value="/consumeData", method=RequestMethod.GET)
    public void consumeData(@RequestParam String data) {
        log.info("[中台] - 收到透传数据，内容:{}", data);

    }
}
