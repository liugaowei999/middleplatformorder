package com.ly.traffic.middleplatform.orderdbtest;

import com.ly.traffic.middleplatform.infrastructure.common.Result;
import com.ly.traffic.middleplatform.interfaces.OrderInterface;
import com.ly.traffic.middleplatform.interfaces.dto.CancelOrderRequestDto;
import com.ly.traffic.middleplatform.interfaces.dto.PaidInfoDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.orderdbtest
 * @Description: 支付回调模拟
 * @date 2020/8/26 15:20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PayCallBackTest {

    @Resource
    private OrderInterface orderInterface;

    @Test
    public void payCallBackTest() throws InterruptedException {
        PaidInfoDto dto = new PaidInfoDto();
        dto.setUnionPayOrderNo("Ukfdslal93849");
        dto.setMainOrderNo("MD1598324298188");
        dto.setPayCode(0);
        dto.setAmount(0.0D);
        dto.setPaySerialNo("12344sffed");


        Result result = orderInterface.paidcallback(dto);
        Assert.assertTrue(result.isOk());

        Thread.sleep(20000);
    }
}
