package com.ly.traffic.middleplatform.domain.payment.entity;

import com.ly.traffic.middleplatform.annotation.Aggregate;
import com.ly.traffic.middleplatform.domain.payment.repository.po.PayWriteBackLogPO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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


}
