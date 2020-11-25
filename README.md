# middleplatformorder
中台订单服务 ：订单创建， 取消，支付更新，改签等功能

- 中台订单继承自统一订单模型

@Aggregate(forceRewriteSuperField = true)

public class OrderAggregate extends UnionOrderEntity { 


