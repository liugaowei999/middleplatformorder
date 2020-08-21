package com.ly.traffic.middleplatform.interfaces.assembler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ly.traffic.middleplatform.domain.createorder.entity.TripPassengerOrderInfo;
import com.ly.traffic.middleplatform.domain.createorder.vo.BusTripInfoVO;
import com.ly.traffic.middleplatform.domain.createorder.vo.TrainTripInfoVO;
import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.entity.UTripOrderInfo;
import com.ly.traffic.middleplatform.domain.order.entity.UTripPassengerOrderInfo;
import com.ly.traffic.middleplatform.interfaces.dto.CreateOrderRequestDto;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.interfaces.assembler
 * @Description: ${TODO}
 * @date 2020/8/21 15:34
 */
public class OrderAssembler {
    /**
     * DTO 转 OrderAggregate领域对象
     * @param createOrderRequestDto 1
     * @return 1
     */
    public static OrderAggregate dtoToDo(CreateOrderRequestDto createOrderRequestDto) {
        OrderAggregate orderAggregate = new OrderAggregate();
        BeanUtils.copyProperties(createOrderRequestDto,orderAggregate);

        JSONObject tripJson = JSON.parseObject(createOrderRequestDto.getTripOrderInfo());
        JSONArray tripPassengerOrderInfoList = tripJson.getJSONArray("tripPassengerOrderInfoList");
        tripJson.remove("tripPassengerOrderInfoList");
        UTripOrderInfo tripOrderInfo = tripJson.toJavaObject(UTripOrderInfo.class);

        String tripName = TrainTripInfoVO.class.getName();
        if (tripJson.containsKey(tripName)) {
            TrainTripInfoVO tripInfoVO = tripJson.getJSONObject(tripName).toJavaObject(TrainTripInfoVO.class);
            tripOrderInfo.setTripInfoVO(tripInfoVO);
        }

        tripName = BusTripInfoVO.class.getName();
        if (tripJson.containsKey(tripName)) {
            BusTripInfoVO tripInfoVO = tripJson.getJSONObject(tripName).toJavaObject(BusTripInfoVO.class);
            tripOrderInfo.setTripInfoVO(tripInfoVO);
        }

        if (tripPassengerOrderInfoList != null && tripPassengerOrderInfoList.size() > 0) {
            int size = tripPassengerOrderInfoList.size();
            List<TripPassengerOrderInfo> passengerOrderInfoList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                UTripPassengerOrderInfo tripPassengerOrderInfo = JSONObject.parseObject(tripPassengerOrderInfoList.getString(i), UTripPassengerOrderInfo.class);
                passengerOrderInfoList.add(tripPassengerOrderInfo);
            }
            tripOrderInfo.setTripPassengerOrderInfoList(passengerOrderInfoList);
            orderAggregate.setTripOrderInfo(tripOrderInfo);
        }

        return orderAggregate;
    }

    public static void main(String[] args) {
        String jsonStr = "{\"updateDate\":1597977473152,\"bookFlag\":0,\"openId\":\"\",\"reduceAmount\":0.0,\"tripOrderInfo\":\"{\\\"tripPassengerOrderInfoList\\\":[\\\"{\\\\\\\"passengerName\\\\\\\":\\\\\\\"张三\\\\\\\",\\\\\\\"extendContent\\\\\\\":\\\\\\\"{}\\\\\\\",\\\\\\\"passengerType\\\\\\\":1,\\\\\\\"sex\\\\\\\":0,\\\\\\\"ticketFlag\\\\\\\":0,\\\\\\\"certificateNo\\\\\\\":\\\\\\\"1102238494577383747\\\\\\\",\\\\\\\"certificateType\\\\\\\":1}\\\",\\\"{\\\\\\\"passengerName\\\\\\\":\\\\\\\"李四\\\\\\\",\\\\\\\"extendContent\\\\\\\":\\\\\\\"{}\\\\\\\",\\\\\\\"passengerType\\\\\\\":1,\\\\\\\"sex\\\\\\\":0,\\\\\\\"ticketFlag\\\\\\\":0,\\\\\\\"certificateNo\\\\\\\":\\\\\\\"2102238494577383747\\\\\\\",\\\\\\\"certificateType\\\\\\\":1}\\\"],\\\"orderType\\\":1,\\\"extendContent\\\":\\\"{\\\\\\\"planCode\\\\\\\":\\\\\\\"场景code\\\\\\\"}\\\",\\\"supplierId\\\":\\\"\\\",\\\"indexNo\\\":0,\\\"orderStatus\\\":1,\\\"unionPay\\\":0,\\\"serviceUnitPrice\\\":10.0,\\\"ticketUnitPrice\\\":120.0,\\\"serviceTotalPrice\\\":20.0,\\\"com.ly.traffic.middleplatform.domain.createorder.vo.TrainTripInfoVO\\\":{\\\"acceptnoseat\\\":0,\\\"beginSaleTime\\\":\\\"\\\",\\\"bindPhone\\\":\\\"\\\",\\\"chooseSeats\\\":\\\"\\\",\\\"createDate\\\":1597977473147,\\\"createUser\\\":\\\"\\\",\\\"endDateTime\\\":1597977473147,\\\"endStationCode\\\":\\\"szb\\\",\\\"endStationName\\\":\\\"苏州北站\\\",\\\"endStationState\\\":1,\\\"fromCity\\\":\\\"\\\",\\\"fromCityId\\\":0,\\\"grabEndTime\\\":1597977473147,\\\"password\\\":\\\"\\\",\\\"placeOrderForNight\\\":0,\\\"seatClass\\\":1,\\\"selfSelect\\\":0,\\\"startDateTime\\\":1597977473147,\\\"startStationCode\\\":\\\"bjn\\\",\\\"startStationName\\\":\\\"北京南站\\\",\\\"startStationState\\\":0,\\\"toCity\\\":\\\"\\\",\\\"toCityId\\\":0,\\\"trafficNo\\\":\\\"\\\",\\\"trainNo\\\":\\\"G183\\\",\\\"updateDate\\\":1597977473147,\\\"updateUser\\\":\\\"\\\",\\\"userName\\\":\\\"\\\"},\\\"travelFlag\\\":0,\\\"ticketTotalPrice\\\":240.0,\\\"tripOrderNo\\\":\\\"TD00001\\\",\\\"payStatus\\\":0}\",\"orderStatus\":0,\"discountAmount\":0.0,\"unionPay\":0,\"paymentType\":0,\"checkStatus\":0,\"platId\":0,\"ticketTotalPrice\":240.0,\"issueFlag\":0,\"supplierOrderNo\":\"\",\"productType\":0,\"memberId\":0,\"createDate\":1597977473152,\"directPay\":0,\"extendContent\":\"{\\\"bb\\\":5,\\\"cc\\\":99,\\\"tQueryKey\\\":\\\"C3:\\\"}\",\"orderNo\":\"MD00052\",\"unionId\":\"\",\"contactEmail\":\"wangwu@qq.com\",\"contactName\":\"王五\",\"payMode\":0,\"customerTotalPaid\":0.0,\"updateUser\":\"\",\"mailStatus\":0,\"validPayTime\":1597977473152,\"customerTotalAmount\":260.0,\"sourceType\":0,\"userCreateDate\":1597977473152,\"createUser\":\"\",\"refId\":0,\"contactPhone\":\"13789287372\",\"payStatus\":0}";
        CreateOrderRequestDto createOrderRequestDto = JSONObject.parseObject(jsonStr, CreateOrderRequestDto.class);
        OrderAggregate orderAggregate = dtoToDo(createOrderRequestDto);
        System.out.println(JSON.toJSONString(orderAggregate));

//        String ori = "{\"bb\":5,\"bookFlag\":0,\"cc\":99,\"checkStatus\":0,\"contactEmail\":\"wangwu@qq.com\",\"contactName\":\"王五\",\"contactPhone\":\"13789287372\",\"createDate\":1597972211052,\"createUser\":\"\",\"customerTotalAmount\":260.0,\"customerTotalPaid\":0.0,\"directPay\":0,\"discountAmount\":0.0,\"issueFlag\":0,\"mailStatus\":0,\"memberId\":0,\"openId\":\"\",\"orderNo\":\"MD00051\",\"orderStatus\":0,\"payMode\":0,\"payStatus\":0,\"paymentType\":0,\"platId\":0,\"productType\":0,\"reduceAmount\":0.0,\"refId\":0,\"resourceConsumerOrderList\":[],\"revenueOrderInfoList\":[],\"sourceType\":0,\"supplierOrderNo\":\"\",\"tQueryKey\":\"C3:\",\"ticketTotalPrice\":240.0,\"tripOrderInfo\":{\"indexNo\":0,\"orderStatus\":1,\"orderType\":1,\"payStatus\":0,\"serviceTotalPrice\":20.0,\"serviceUnitPrice\":10.0,\"supplierId\":\"\",\"ticketTotalPrice\":240.0,\"ticketUnitPrice\":120.0,\"travelFlag\":0,\"tripInfoVO\":{\"acceptnoseat\":0,\"beginSaleTime\":\"\",\"bindPhone\":\"\",\"chooseSeats\":\"\",\"createDate\":1597972211047,\"createUser\":\"\",\"endDateTime\":1597972211047,\"endStationCode\":\"szb\",\"endStationName\":\"苏州北站\",\"endStationState\":1,\"fromCity\":\"\",\"fromCityId\":0,\"grabEndTime\":1597972211047,\"password\":\"\",\"placeOrderForNight\":0,\"seatClass\":1,\"selfSelect\":0,\"startDateTime\":1597972211047,\"startStationCode\":\"bjn\",\"startStationName\":\"北京南站\",\"startStationState\":0,\"toCity\":\"\",\"toCityId\":0,\"trafficNo\":\"\",\"trainNo\":\"G183\",\"updateDate\":1597972211047,\"updateUser\":\"\",\"userName\":\"\"},\"tripOrderNo\":\"TD00001\",\"tripPassengerOrderInfoList\":[{\"certificateNo\":\"1102238494577383747\",\"certificateType\":1,\"passengerName\":\"张三\",\"passengerType\":1,\"sex\":0,\"ticketFlag\":0},{\"certificateNo\":\"2102238494577383747\",\"certificateType\":1,\"passengerName\":\"李四\",\"passengerType\":1,\"sex\":0,\"ticketFlag\":0}],\"unionPay\":0},\"unionId\":\"\",\"unionPay\":0,\"updateDate\":1597972211052,\"updateUser\":\"\",\"userCreateDate\":1597972211052,\"validPayTime\":1597972211052}";
//        OrderAggregate order = JSONObject.parseObject(jsonStr, OrderAggregate.class);
//        System.out.println(JSON.toJSONString(order));
    }
}
