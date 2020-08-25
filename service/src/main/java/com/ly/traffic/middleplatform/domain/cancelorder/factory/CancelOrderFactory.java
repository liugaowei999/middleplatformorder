package com.ly.traffic.middleplatform.domain.cancelorder.factory;

import com.google.common.collect.Lists;
import com.ly.traffic.middleplatform.domain.cancelorder.entity.CancelAggregate;
import com.ly.traffic.middleplatform.domain.cancelorder.repository.po.CancelOrderPO;
import com.ly.traffic.middleplatform.domain.createorder.entity.ResourceConsumerOrder;
import com.ly.traffic.middleplatform.domain.createorder.entity.RevenueOrderInfo;
import com.ly.traffic.middleplatform.domain.createorder.entity.TripPassengerOrderInfo;
import com.ly.traffic.middleplatform.domain.createorder.vo.BusTripInfoVO;
import com.ly.traffic.middleplatform.domain.createorder.vo.TrainTripInfoVO;
import com.ly.traffic.middleplatform.domain.createorder.vo.TripInfoVO;
import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.entity.UTripOrderInfo;
import com.ly.traffic.middleplatform.domain.order.entity.UTripPassengerOrderInfo;
import com.ly.traffic.middleplatform.domain.order.repository.po.*;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.interfaces
 * @Description: 领域对象OrderAggregate 转 持久化对象xxPO
 * @date 2020/8/20 17:10
 */
public class CancelOrderFactory {
    /**
     * 表1: main_order
     */
    public static CancelOrderPO getCancelOrderPO(CancelAggregate cancelAggregate) {
        CancelOrderPO mainOrderPO = new CancelOrderPO();
        BeanUtils.copyProperties(cancelAggregate.getCancelOrder(), mainOrderPO);
        return mainOrderPO;
    }
}
