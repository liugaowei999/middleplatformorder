package com.ly.traffic.middleplatform.test.simulator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.eventbus.Subscribe;
import com.ly.traffic.middleplatform.demo.OrderEvent;
import com.ly.traffic.middleplatform.domain.cancelorder.entity.CancelAggregate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.Collections;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.test.simulator
 * @Description: ${TODO}
 * @date 2020/8/25 15:17
 */
@Slf4j
public class TicketServiceListener {

    @Subscribe
    public void cancelTicketTask(CancelAggregate event) throws InterruptedException {
        log.info("[票务中心微服务模拟] 收到取消票务任务请求(取消占座或出票任务)，内容:{}", JSON.toJSONString(event));
        boolean out = RandomUtils.nextBoolean();
        log.info("[票务中心微服务模拟] - 通知供应商取消出票任务");

        Thread.sleep(RandomUtils.nextInt(1000,5000));

        if (out) {
            log.info("[票务中心微服务模拟] - 订单已经出票不能取消， 开始回调通知【取消任务订单聚合】");
        } else {
            log.info("[票务中心微服务模拟] - 收到供应商取消出票任务成功");
            log.info("[票务中心微服务模拟] - 票务任务已成功取消， 开始回调通知【取消任务订单聚合】进行取消");
        }
    }

    public static void main(String[] args) {
        int cnt = 0;

        for (long y = 0; y < 10000000000L; y++) {
            if ((y & (y-1)) == 0) {
                System.out.print(y + ",");
                cnt++;
            }
        }
        System.out.println("\n 共:" + cnt);

        cnt = 0;
        long nanoTime = System.currentTimeMillis();
        for (long y = 0; y < 10000000000L; y++) {
            if ((y & 1) == 0) {
                cnt++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("cnt=" + cnt + ", cost1:" + (end - nanoTime)/1000);

        cnt = 0;
        nanoTime = System.currentTimeMillis();
        for (long y = 0; y < 10000000000L; y++) {
            if ((y % 2) == 0) {
                cnt++;
            }
        }
        end = System.currentTimeMillis();
        System.out.println("cnt=" + cnt + ", cost2:" + (end - nanoTime)/1000);


    }

}
