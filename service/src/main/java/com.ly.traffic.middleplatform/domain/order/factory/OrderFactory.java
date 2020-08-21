package com.ly.traffic.middleplatform.domain.order.factory;

import com.google.common.collect.Lists;
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
public class OrderFactory {
    /**
     * 表1: main_order
     */
    public static MainOrderPO getMainOrderPO(OrderAggregate orderAggregate) {
        MainOrderPO mainOrderPO = new MainOrderPO();
        BeanUtils.copyProperties(orderAggregate, mainOrderPO);
        return mainOrderPO;
    }

    /**
     * 表2: train_trip_info
     */
    public static TrainTripInfoPO getTrainTripInfoPO(OrderAggregate orderAggregate) {
        UTripOrderInfo tripOrderInfo = orderAggregate.getTripOrderInfo();
        if (tripOrderInfo == null) {
            return null;
        }

        TripInfoVO tripInfoVO = tripOrderInfo.getTripInfoVO();
        if (tripInfoVO != null && tripInfoVO instanceof TrainTripInfoVO) {
            TrainTripInfoPO trainTripInfoPO = new TrainTripInfoPO();
            BeanUtils.copyProperties((TrainTripInfoVO)tripInfoVO, trainTripInfoPO);
            trainTripInfoPO.setTripSerial(tripOrderInfo.getTripSerial());
            return trainTripInfoPO;
        }
        return null;
    }

    /**
     * 表3: bus_trip_info
     */
    public static BusTripInfoPO getBusTripInfoPO(OrderAggregate orderAggregate) {
        UTripOrderInfo tripOrderInfo = orderAggregate.getTripOrderInfo();
        if (tripOrderInfo == null) {
            return null;
        }

        TripInfoVO tripInfoVO = tripOrderInfo.getTripInfoVO();
        if (tripInfoVO != null && tripInfoVO instanceof BusTripInfoVO) {
            BusTripInfoPO busTripInfoPO = new BusTripInfoPO();
            BeanUtils.copyProperties((BusTripInfoVO)tripInfoVO, busTripInfoPO);
            busTripInfoPO.setTripSerial(tripOrderInfo.getTripSerial());
            return busTripInfoPO;
        }
        return null;
    }

    /**
     * 表4: trip_order_info
     */
    public static TripOrderInfoPO tripOrderInfo(OrderAggregate orderAggregate) {
        UTripOrderInfo tripOrderInfo = orderAggregate.getTripOrderInfo();
        if (tripOrderInfo == null) {
            return null;
        }

        TripOrderInfoPO tripOrderInfoPO = new TripOrderInfoPO();
        BeanUtils.copyProperties(tripOrderInfo, tripOrderInfoPO);
        return tripOrderInfoPO;
    }

    /**
     * 表5: trip_passenger_order_info
     */
    public static List<TripPassengerOrderInfoPO> getTripPassengerOrderInfoPO(OrderAggregate orderAggregate) {
        UTripOrderInfo tripOrderInfo = orderAggregate.getTripOrderInfo();
        if (tripOrderInfo == null) {
            return null;
        }

        List<TripPassengerOrderInfoPO> tripPassengerOrderInfoPOList = Lists.newArrayList();
        List<TripPassengerOrderInfo> tripPassengerOrderInfoList = tripOrderInfo.getTripPassengerOrderInfoList();
        if (CollectionUtils.isNotEmpty(tripPassengerOrderInfoList)) {
            for (TripPassengerOrderInfo passengerOrderInfo : tripPassengerOrderInfoList) {
                TripPassengerOrderInfoPO tripPassengerOrderInfoPO = new TripPassengerOrderInfoPO();
                if (passengerOrderInfo instanceof UTripPassengerOrderInfo) {
                    BeanUtils.copyProperties((UTripPassengerOrderInfo)passengerOrderInfo, tripPassengerOrderInfoPO);
                } else {
                    BeanUtils.copyProperties(passengerOrderInfo, tripPassengerOrderInfoPO);
                }
                tripPassengerOrderInfoPOList.add(tripPassengerOrderInfoPO);
            }
        }
        return tripPassengerOrderInfoPOList;
    }


}
