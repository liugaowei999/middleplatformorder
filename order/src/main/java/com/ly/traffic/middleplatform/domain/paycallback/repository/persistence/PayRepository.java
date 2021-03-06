package com.ly.traffic.middleplatform.domain.paycallback.repository.persistence;


import com.ly.traffic.middleplatform.domain.paycallback.entity.PayWriteBackLog;
import com.ly.traffic.middleplatform.domain.paycallback.repository.IPayRepository;
import com.ly.traffic.middleplatform.domain.paycallback.repository.mapper.PayWriteBackLogMapper;
import com.ly.traffic.middleplatform.domain.paycallback.repository.po.PayWriteBackLogPO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.refundticket.repository.persistence
 * @Description: 支付回写日志记录仓储
 * @date 2020/8/24 17:23
 */
@Component
public class PayRepository implements IPayRepository {
    @Resource
    private PayWriteBackLogMapper payWriteBackLogMapper;

    @Override
    public int save(PayWriteBackLog payWriteBackLog) {
        return 0;
    }

    @Override
    public PayWriteBackLogPO queryById(Integer id) {
        return null;
    }
}
