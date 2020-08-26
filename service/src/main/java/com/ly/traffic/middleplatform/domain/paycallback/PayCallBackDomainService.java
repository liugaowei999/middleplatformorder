package com.ly.traffic.middleplatform.domain.paycallback;

import com.ly.traffic.middleplatform.domain.paycallback.entity.PayWriteBackLog;
import com.ly.traffic.middleplatform.domain.paycallback.event.publish.PaidSuccessPublish;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.payment
 * @Description: ${TODO}
 * @date 2020/8/26 14:55
 */
@Service
@Slf4j
public class PayCallBackDomainService {
    @Resource
    private PaidSuccessPublish paidSuccessPublish;

    public void payLog(PayWriteBackLog payWriteBackLog) {
        log.info("[支付回调聚合] - 记录支付日志完成！");
        log.info("[支付回调聚合] - 发送更新订单支付信息通知 ...");

        // 发布更新订单支付信息命令通知
        paidSuccessPublish.publish(payWriteBackLog);
    }
}
