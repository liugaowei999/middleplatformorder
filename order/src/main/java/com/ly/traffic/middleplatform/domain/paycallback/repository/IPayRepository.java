package com.ly.traffic.middleplatform.domain.paycallback.repository;

import com.ly.traffic.middleplatform.domain.paycallback.entity.PayWriteBackLog;
import com.ly.traffic.middleplatform.domain.paycallback.repository.po.PayWriteBackLogPO;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order.repository
 * @Description:  支付回写日志记录仓储
 * @date 2020/8/21 15:28
 */
public interface IPayRepository {
    public int save(PayWriteBackLog payWriteBackLog);
    public PayWriteBackLogPO queryById(Integer id);
}
