package com.ly.traffic.middleplatform.domain.order.repository.persistence;

import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.repository.IOrderRepository;
import com.ly.traffic.middleplatform.domain.order.repository.mapper.*;
import com.ly.traffic.middleplatform.domain.order.repository.po.*;
import com.ly.traffic.middleplatform.domain.order.factory.OrderFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 主订单表(MainOrderPO)表服务实现类
 *
 * @author makejava
 * @since 2020-08-07 17:29:26
 */
@Service
public class OrderRepository implements IOrderRepository {
    @Resource
    private MainOrderMapper mainOrderMapper;

    @Resource
    private TrainTripInfoMapper trainTripInfoMapper;

    @Resource
    private BusTripInfoMapper busTripInfoMapper;

    @Resource
    private TripOrderInfoMapper tripOrderInfoMapper;

    @Resource
    private TripPassengerOrderInfoMapper tripPassengerOrderInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MainOrderPO queryById(Integer id) {
        return this.mainOrderMapper.queryById(id);
    }

    /**
     * 仓储持久化订单数据
     * @param orderAggregate 1
     * @return 1
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(OrderAggregate orderAggregate) {
        int count = 0;
        MainOrderPO mainOrderPO = OrderFactory.getMainOrderPO(orderAggregate);
        count += mainOrderMapper.insert(mainOrderPO);

        TrainTripInfoPO trainTripInfoPO = OrderFactory.getTrainTripInfoPO(orderAggregate);
        BusTripInfoPO busTripInfoPO = OrderFactory.getBusTripInfoPO(orderAggregate);
        TripOrderInfoPO tripOrderInfoPO = OrderFactory.tripOrderInfo(orderAggregate);
        if (trainTripInfoPO != null) {
            tripOrderInfoPO.setTripSerial(trainTripInfoPO.getTripSerial());
            count += trainTripInfoMapper.insert(trainTripInfoPO);

        } else if (busTripInfoPO != null) {
            tripOrderInfoPO.setTripSerial(busTripInfoPO.getTripSerial());
            count += busTripInfoMapper.insert(busTripInfoPO);
        }

        if (tripOrderInfoPO != null) {
            count += tripOrderInfoMapper.insert(tripOrderInfoPO);
        }

        List<TripPassengerOrderInfoPO> tripPassengerOrderInfoPOList = OrderFactory.getTripPassengerOrderInfoPO(orderAggregate);
        if (CollectionUtils.isNotEmpty(tripPassengerOrderInfoPOList)) {
            for (TripPassengerOrderInfoPO passengerOrderInfoPO : tripPassengerOrderInfoPOList) {
                count += tripPassengerOrderInfoMapper.insert(passengerOrderInfoPO);
            }
        }

        return count;
    }

    /**
     * 修改数据
     *
     * @param MainOrderPO 实例对象
     * @return 实例对象
     */
    public MainOrderPO update(MainOrderPO MainOrderPO) {
        this.mainOrderMapper.update(MainOrderPO);
        return this.queryById(MainOrderPO.getId());
    }
}
