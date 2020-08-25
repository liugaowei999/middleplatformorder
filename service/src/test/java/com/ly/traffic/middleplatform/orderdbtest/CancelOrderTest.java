package com.ly.traffic.middleplatform.orderdbtest;
import java.util.Date;

import com.ly.traffic.middleplatform.infrastructure.common.Result;
import com.ly.traffic.middleplatform.interfaces.OrderInterface;
import com.ly.traffic.middleplatform.interfaces.dto.CancelOrderRequestDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.orderdbtest
 * @Description: ${TODO}
 * @date 2020/8/25 15:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CancelOrderTest {
    @Resource
    private OrderInterface orderInterface;

    @Test
    public void cancelOrderTest() {
        CancelOrderRequestDto dto = new CancelOrderRequestDto();
//        dto.setMainOrderNo("MD1598000510484");
        dto.setMainOrderNo("MD1598003401236");

        dto.setType(0);
        dto.setReasonCode(99);
        dto.setReason("购买重复");
        dto.setMemberId(987643);
        dto.setUnionId("US-eufhskaf");
        dto.setOpenId("OIDdkafjslf");
        dto.setApplyTime(new Date());
        Result result = orderInterface.cancelOrder(dto);
        Assert.assertTrue(result.isOk());
    }
}
