# middleplatformorder
中台订单服务 ：订单创建， 取消，支付更新，改签等功能

- 中台订单继承自统一订单模型

@Aggregate(forceRewriteSuperField = true)

public class OrderAggregate extends UnionOrderEntity { 


------------ 整体说明：
一：基础功能

1. 编译期检查模型定义是否合理 & 注解定义
https://github.com/liugaowei999/aptdemo.git

2. 统一订单模型定义
https://github.com/liugaowei999/order-model.git

3. 流程控制
https://github.com/liugaowei999/flowcontrol.git
二：业务功能

1. 中台订单服务 ：订单创建， 取消，支付更新，改签等功能
https://github.com/liugaowei999/middleplatformorder.git 

2. 前台订单服务
https://github.com/liugaowei999/trainorder-demo.git
