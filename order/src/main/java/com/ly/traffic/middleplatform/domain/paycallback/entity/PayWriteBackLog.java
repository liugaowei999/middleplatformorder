package com.ly.traffic.middleplatform.domain.paycallback.entity;

import com.ly.traffic.middleplatform.apt.annotation.Aggregate;
import com.ly.traffic.middleplatform.domain.paycallback.repository.po.PayWriteBackLogPO;
import lombok.Getter;
import lombok.Setter;

/**
 * 支付回写记录日志记录实体类(聚合根)
 *
 * @author liugw
 * @since 2020-08-25 18:43:39
 */
@Getter
@Setter
@Aggregate
public class PayWriteBackLog extends PayWriteBackLogPO {
    /**
     * 合单支付订单号
     */
    private String unionPayOrderNo;

    /**
     * 用户主订单号
     */
    private String mainOrderNo;

}
