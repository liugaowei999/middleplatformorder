package com.ly.traffic.middleplatform.domain.cancelorder.service;

import com.ly.traffic.middleplatform.domain.cancelorder.entity.CancelAggregate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.cancelorder.service
 * @Description: ${TODO}
 * @date 2020/8/25 15:11
 */
@Service
public class CancelDomainService {
    @Resource
    private CancelTicketService cancelTicketService;

    /**
     * 异步发起取消"票务"任务
     * @param cancelAggregate
     */
    public void cancelTicketTaskAsync(CancelAggregate cancelAggregate) {
        cancelTicketService.sendTicketTaskCancelRequest(cancelAggregate);
    }
}
