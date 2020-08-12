//package com.ly.traffic.middleplatform.domain.order.entity;
//
//import com.alibaba.fastjson.JSON;
//import com.google.common.collect.Lists;
//import com.ly.traffic.train.domain.order.entity.requirement.UserTripInfo;
//import com.ly.traffic.train.domain.order.entity.requirement.ValueAddedGoodsInfo;
//import com.ly.traffic.train.domain.order.entity.result.GoodsResultInfo;
//import com.ly.traffic.train.domain.order.entity.result.TicketInfo;
//import com.ly.traffic.train.domain.order.vo.ClientInfoVO;
//import com.ly.traffic.train.infrastructure.IOrderRepository;
//import lombok.Data;
//
//import java.util.List;
//
///**
// * @author liugw
// * @Package com.ly.traffic.middleplatform.domain.order
// * @Description: ${TODO}
// * @date 2020/7/6 15:00
// */
//@Data
//public class OrderAggregate implements IOrderRepository {
//    private String orderSerialId;
//
//    /**
//     * 订单基本信息 & 客户端信息
//     */
//    private com.ly.traffic.train.domain.order.entity.OrderBaseInfo orderBaseInfo;
//    private ClientInfoVO clientInfo;
//
//    /**
//     * 订单需求信息（与用户之前的契约）
//     */
//    private List<UserTripInfo> userTripInfoList;
//    private List<ValueAddedGoodsInfo> goodsInfoList;
//
//    /**
//     * 订单最终达成的结果
//     */
//    private List<TicketInfo> ticketInfoList;
//    private List<GoodsResultInfo> goodsResultInfoList;
//
//    /**
//     * 优惠信息
//     */
////    private List<DiscountInfo> discountInfoList;
//
//
//    public static void main(String[] args) {
//        OrderAggregate orderAggregate = new OrderAggregate();
//        com.ly.traffic.train.domain.order.entity.OrderBaseInfo orderBaseInfo = new com.ly.traffic.train.domain.order.entity.OrderBaseInfo();
//        orderBaseInfo.setUserName("zhangsan");
//        orderBaseInfo.setTQueryKey("KEY1");
//
//        List<UserTripInfo> userTripInfoList = Lists.newArrayList();
//        UserTripInfo userTripInfo = new UserTripInfo();
//        userTripInfo.setFromCity("北京");
//        userTripInfo.setFromCityPy("beijing");
//        userTripInfoList.add(userTripInfo);
//
//        orderAggregate.setUserTripInfoList(userTripInfoList);
//        orderAggregate.setOrderBaseInfo(orderBaseInfo);
//
//        System.out.println(JSON.toJSONString(orderAggregate));
//
//        String jsonStr = "{\"orderBaseInfo\":{\"isOnlineTicket\":0,\"tQueryKey\":\"KEY1\",\"trainsformPurchaseStatus\":0,\"userName\":\"zhangsan\"},\"userTripInfoList\":[{\"bothTime\":0,\"fromCity\":\"北京\",\"fromCityPy\":\"beijing\"}]}";
//        OrderAggregate orderAggregate1 = JSON.parseObject(jsonStr, OrderAggregate.class);
//        System.out.println(JSON.toJSONString(orderAggregate1));
//        BaseGeneralUserTripInfo baseGeneralUserTripInfo = (BaseGeneralUserTripInfo)orderAggregate1.getUserTripInfoList().get(0);
//        System.out.println(baseGeneralUserTripInfo.getFromCity());
//
//
//        System.out.println("============================================");
//        orderAggregate1.create();
//    }
//
//}
