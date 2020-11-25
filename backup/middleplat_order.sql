/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.31 : Database - union_order
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`union_order` /*!40100 DEFAULT CHARACTER SET latin1 */;

/*Table structure for table `bus_trip_info` */

DROP TABLE IF EXISTS `bus_trip_info`;

CREATE TABLE `bus_trip_info` (
  `id` bigint(21) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `trip_serial` varchar(50) NOT NULL COMMENT '行程流水号',
  `from_city` varchar(50) NOT NULL COMMENT '出发城市',
  `from_city_id` int(11) NOT NULL DEFAULT '0' COMMENT '出发城市id',
  `to_city_id` int(11) NOT NULL DEFAULT '0' COMMENT '到达城市id',
  `to_city` varchar(50) NOT NULL COMMENT '到达城市',
  `start_latlon` varchar(50) NOT NULL COMMENT '出发地经纬度',
  `from_place` varchar(200) NOT NULL COMMENT '出发地名称',
  `start_address` varchar(200) NOT NULL COMMENT '出发详细地址',
  `end_latlon` varchar(50) NOT NULL COMMENT '到达地经纬度',
  `to_place` varchar(200) NOT NULL COMMENT '到达地名称',
  `end_address` varchar(200) NOT NULL COMMENT '到达地详细地址',
  `start_date_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '出发时间',
  `end_date_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '到达时间',
  `both_time` varchar(20) NOT NULL COMMENT '行程时长,单位分钟',
  `departure_station` varchar(50) NOT NULL COMMENT '始发站',
  `departure_station_code` varchar(50) NOT NULL COMMENT '始发站代码',
  `arrival_station` varchar(50) NOT NULL COMMENT '到达站',
  `arrival_station_code` varchar(50) NOT NULL COMMENT '到达站代码',
  `schedule_no` varchar(100) NOT NULL COMMENT '班次号',
  `bus_no` varchar(100) NOT NULL COMMENT '汽车车次号',
  `transport_type` varchar(50) NOT NULL COMMENT '车型名称',
  `schedule_id` varchar(100) NOT NULL COMMENT '班次编码',
  `service_charge_id` int(11) NOT NULL DEFAULT '0' COMMENT '服务费id',
  `service_charge_type` varchar(10) NOT NULL COMMENT '服务费类型',
  `running_sch_flag` int(11) NOT NULL DEFAULT '0' COMMENT '是否流水班次',
  `can_refund` int(11) NOT NULL DEFAULT '0' COMMENT '是否支持在线退票:1支持，2不支持',
  `refund_before_depart` int(11) NOT NULL DEFAULT '0' COMMENT '发车前最晚可发起退票时间（分钟）： 值为60则表示发车前60分钟才能发起退票',
  `create_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '创建日期',
  `create_user` varchar(40) NOT NULL COMMENT '创建人',
  `update_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '更新日期',
  `update_user` varchar(40) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='汽车行程信息表';

/*Data for the table `bus_trip_info` */

/*Table structure for table `cancel_order` */

DROP TABLE IF EXISTS `cancel_order`;

CREATE TABLE `cancel_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单自增ID（主键）',
  `main_order_no` varchar(50) NOT NULL COMMENT '要取消的主订单流水号',
  `type` int(5) NOT NULL DEFAULT '0' COMMENT '类型: 0-用户主动取消，1-支付超时系统取消',
  `status` int(5) NOT NULL DEFAULT '0' COMMENT '取消订单处理状态: 0-申请取消，1-取消中，2-取消成功， 3-取消失败',
  `reasonCode` int(11) NOT NULL DEFAULT '0' COMMENT '取消原因code -1:其它原因  0：直接取消，没选原因',
  `reason` varchar(512) NOT NULL COMMENT '申请取消原因',
  `rejectReason` varchar(512) NOT NULL COMMENT '取消订单失败原因',
  `memberId` int(11) NOT NULL DEFAULT '0' COMMENT '会员id',
  `UnionId` varchar(50) NOT NULL COMMENT '记录用户unionId',
  `OpenId` varchar(50) NOT NULL COMMENT 'openId，微信平台订票时有值',
  `applyTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '取消申请时间',
  `CreateDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `CreateUser` varchar(40) NOT NULL COMMENT '创建人',
  `UpdateDate` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '更新日期',
  `UpdateUser` varchar(40) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='取消订单订单表';

/*Data for the table `cancel_order` */

/*Table structure for table `change_ticket_order` */

DROP TABLE IF EXISTS `change_ticket_order`;

CREATE TABLE `change_ticket_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单自增ID（主键）',
  `changeOrderNo` varchar(50) NOT NULL COMMENT '改签订单流水号',
  `ticketType` int(5) NOT NULL DEFAULT '0' COMMENT '改签票类型：1：火车票 2：汽车票 3：飞机票',
  `changeType` int(5) NOT NULL DEFAULT '0' COMMENT '改签类型：1：改签 2：变更到站',
  `mainOrderNo` varchar(50) NOT NULL COMMENT '改签的主订单流水号',
  `tripOrderNo` varchar(50) NOT NULL COMMENT '改签的行程订单流水号',
  `passengerOrderNo` varchar(50) NOT NULL COMMENT '改签的票订单流水号',
  `ticketNo` varchar(50) NOT NULL COMMENT '改签的票号（第三方）',
  `changeTicketCharge` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '改签手续费',
  `changePriceDiff` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '改签差价（已扣除改签手续费），正数表示需补充的差价，负数表示需退还的差价',
  `refundSerialId` varchar(50) NOT NULL COMMENT '退款唯一流水号（退款申请幂等检查）',
  `status` int(5) NOT NULL DEFAULT '0' COMMENT '改签订单处理状态: 0-申请改签，10-改签中，20-待用户确认， 30-改签占座成功 31:改签出票成功 40:改签失败',
  `autoConfirm` int(5) NOT NULL DEFAULT '0' COMMENT '改签确认方式：0：用户确认 1：自动确认',
  `confirmExpireTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '改签确认过期时间',
  `newPassengerOrderNo` varchar(50) NOT NULL COMMENT '新订单流水号',
  `newTripSerialNo` varchar(50) NOT NULL COMMENT '新票订单流水号',
  `newTicketNo` varchar(50) NOT NULL COMMENT '新票号（第三方）',
  `rejectReason` varchar(512) NOT NULL COMMENT '改签失败原因',
  `memberId` int(11) NOT NULL DEFAULT '0' COMMENT '会员id',
  `UnionId` varchar(50) NOT NULL COMMENT '记录用户unionId',
  `OpenId` varchar(50) NOT NULL COMMENT 'openId，微信平台订票时有值',
  `platId` int(10) NOT NULL DEFAULT '0' COMMENT '改签的平台id   0-默认 1-CN站 2-COM站 434-安卓 433-IOS 432-Touch 501-微信火车票 577-葡萄网 625-火车票供应商回调测试 596-手Q 580-WindowsPh',
  `applyTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '申请改签时间',
  `changeSuccessTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '改签成功时间',
  `CreateDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `CreateUser` varchar(40) NOT NULL COMMENT '创建人',
  `UpdateDate` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '更新日期',
  `UpdateUser` varchar(40) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='改签订单表';

/*Data for the table `change_ticket_order` */

/*Table structure for table `main_order` */

DROP TABLE IF EXISTS `main_order`;

CREATE TABLE `main_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单自增id（主键）',
  `order_no` varchar(50) NOT NULL COMMENT '主订单流水号',
  `plat_id` int(11) NOT NULL DEFAULT '0' COMMENT '渠道: 501--微信, 852--小程序, 433--app_ios, 434--app_android, 1048--艺龙app, 596--手Q',
  `source_type` int(3) NOT NULL DEFAULT '0' COMMENT '订单来源类型',
  `member_id` int(11) NOT NULL DEFAULT '0' COMMENT '会员id',
  `supplier_order_no` varchar(1000) NOT NULL DEFAULT '' COMMENT '供应商订单号',
  `check_status` int(8) NOT NULL DEFAULT '0' COMMENT '身份核验状态 0-无需核验 1-核验中 2-核验通过 3-核验失败',
  `order_status` int(8) NOT NULL DEFAULT '0' COMMENT '订单用户状态:10-待支付,11-支付中| 20-待占座,21-占座中,22-占座成功,23-占座失败| 30-待出票,31-出票中,32-出票完成,33-出票失败| 40-待退票,41-退票中,42-退票完成,43-退票失败| 50-驳回订单| 60-申请取消,61-取消中,62-已取消,63-过期取消| 70-退款中,71-已退款| 80-改签中,81-改签成功,82-改签失败| 90-已出行,91-下单失败',
  `mail_status` tinyint(5) NOT NULL DEFAULT '0' COMMENT '邮寄状态 1. 未邮寄; 2.已邮寄; 3.无需邮寄;0， 未知',
  `pay_status` int(5) NOT NULL DEFAULT '0' COMMENT '客人是否付款同程 0：未付款 1：已付款',
  `contact_name` varchar(50) NOT NULL DEFAULT '' COMMENT '联系人名称',
  `contact_phone` varchar(20) NOT NULL DEFAULT '' COMMENT '联系人手机号',
  `contact_email` varchar(50) NOT NULL DEFAULT '' COMMENT '联系人email',
  `customer_total_amount` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '客人应付同程总额',
  `customer_total_paid` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '客人实付同程总额',
  `ticket_total_price` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '票价总额',
  `reduce_amount` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '活动立减金额',
  `discount_amount` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  `book_flag` int(5) NOT NULL DEFAULT '0' COMMENT '预订标识，1-正常，2-收单',
  `issue_flag` int(5) NOT NULL DEFAULT '0' COMMENT '出票模式：0-全部锁票/占座成功后出票，1-一程出票成功后再处理另一程',
  `pay_mode` int(5) NOT NULL DEFAULT '0' COMMENT '支付方式：0-普通，1-代扣',
  `valid_pay_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '支付过期时间',
  `payment_type` int(5) NOT NULL DEFAULT '0' COMMENT '付款方式：0--先占座后支付(微信支付)，1--先支付后占座(微信支付)',
  `union_pay` int(5) NOT NULL DEFAULT '0' COMMENT '是否合单支付: 0--非合单支付, 1--合单支付',
  `direct_pay` int(5) NOT NULL DEFAULT '0' COMMENT '支付方式：0-普通，1-直连支付，2-两程分开代扣，3-两程分开代扣转两程一起支付(第一程代扣失败的场景)',
  `product_type` int(5) NOT NULL DEFAULT '0' COMMENT '订单类型：0-普通 1-火火联运，2-火空联运，3-火汽联运，4-空火联运, 5-火车直达，7-飞机直达，10-国际火空,11-汽火联运，12-火空联运（合并下单），13-空火联运（合并下单）, 14-火汽联运（合并下单）, 15-汽火联运（合并下单）, 16-九龙联运，17-火车抢票(火车+抢票&上车补票), 18-空空联运, 19-机场大巴+飞机, 20-飞机+机场大巴 21-火车+抢票/预约（分销） 22-火车+抢票/预约（直销） 23-抢票+抢票 24-汽车+汽车 25-抢票+火车 26-配送票+配送票 27-火车+港铁 28-火车+城际（分开下单）29-12306分开下单 30-有票+抢票 31 抢票+抢票 32 新电子客票\n            备注：以下类型当前库中已不存在（\n            6-汽车直达， 8-用车直达，9-城际接驳直达）',
  `with_hold_status` int(5) NOT NULL DEFAULT '0' COMMENT '微信代扣状态 0-微信支付 1，2-微信代扣 3-微信代扣转微信支付',
  `with_hold_fail_reason` varchar(100) NOT NULL DEFAULT '' COMMENT '代扣失败原因',
  `ref_id` int(11) NOT NULL DEFAULT '0' COMMENT 'refid',
  `union_id` varchar(50) NOT NULL DEFAULT '' COMMENT '记录用户unionid',
  `open_id` varchar(50) NOT NULL DEFAULT '' COMMENT 'openid，微信平台订票时有值',
  `extend_content` varchar(10240) NOT NULL DEFAULT '' COMMENT '扩展信息',
  `user_create_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '点击预定按钮时间',
  `create_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '创建日期',
  `create_user` varchar(40) NOT NULL DEFAULT '''system''' COMMENT '创建人',
  `update_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '更新日期',
  `update_user` varchar(40) NOT NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='主订单表';

/*Data for the table `main_order` */

insert  into `main_order`(`id`,`order_no`,`plat_id`,`source_type`,`member_id`,`supplier_order_no`,`check_status`,`order_status`,`mail_status`,`pay_status`,`contact_name`,`contact_phone`,`contact_email`,`customer_total_amount`,`customer_total_paid`,`ticket_total_price`,`reduce_amount`,`discount_amount`,`book_flag`,`issue_flag`,`pay_mode`,`valid_pay_time`,`payment_type`,`union_pay`,`direct_pay`,`product_type`,`with_hold_status`,`with_hold_fail_reason`,`ref_id`,`union_id`,`open_id`,`extend_content`,`user_create_date`,`create_date`,`create_user`,`update_date`,`update_user`) values (6,'MD1603107433327',987,10,5365462,'',0,0,0,0,'王五','13789287372','wangwu@qq.com','260.00','0.00','240.00','0.00','0.00',0,0,0,'2020-10-19 19:37:13',0,0,0,0,0,'',123456,'USKDFJ-wejfksd','Qjfsdjakfklsdafl','{\"bb\":5,\"customerNameList\":[\"张三\",\"李四\"],\"tQueryKey\":\"F3:\",\"constantDd\":666}','2020-10-19 19:37:13','2020-10-19 19:37:13','system','2020-10-19 19:37:13','');

/*Table structure for table `order_event_snapshot` */

DROP TABLE IF EXISTS `order_event_snapshot`;

CREATE TABLE `order_event_snapshot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `event_id` varchar(64) NOT NULL DEFAULT '' COMMENT '事件唯一标识ID',
  `event_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '事件发生时间',
  `source` varchar(128) NOT NULL DEFAULT '' COMMENT '事件源',
  `content` varchar(10240) NOT NULL DEFAULT '' COMMENT '事件内容',
  `event_type` varchar(20) NOT NULL DEFAULT '' COMMENT '事件类型',
  `version` int(5) NOT NULL DEFAULT '0' COMMENT '版本号',
  `create_user` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='订单事件快照记录表';

/*Data for the table `order_event_snapshot` */

insert  into `order_event_snapshot`(`id`,`event_id`,`event_time`,`source`,`content`,`event_type`,`version`,`create_user`,`create_time`) values (1,'createOrder_10.97.20.179:8096_26_33334742592545_341','2020-10-19 19:37:19','order','{\"bypassId\":5365462,\"dataSnapshot\":\"{\\\"bookFlag\\\":0,\\\"canceled\\\":false,\\\"checkStatus\\\":0,\\\"contactEmail\\\":\\\"wangwu@qq.com\\\",\\\"contactName\\\":\\\"王五\\\",\\\"contactPhone\\\":\\\"13789287372\\\",\\\"createDate\\\":1603107433325,\\\"createUser\\\":\\\"system\\\",\\\"customerTotalAmount\\\":260.0,\\\"customerTotalPaid\\\":0.0,\\\"directPay\\\":0,\\\"discountAmount\\\":0.0,\\\"extendContent\\\":\\\"{\\\\\\\"bb\\\\\\\":5,\\\\\\\"customerNameList\\\\\\\":[\\\\\\\"张三\\\\\\\",\\\\\\\"李四\\\\\\\"],\\\\\\\"tQueryKey\\\\\\\":\\\\\\\"F3:\\\\\\\",\\\\\\\"constantDd\\\\\\\":666}\\\",\\\"issueFlag\\\":0,\\\"mailStatus\\\":0,\\\"memberId\\\":5365462,\\\"openId\\\":\\\"Qjfsdjakfklsdafl\\\",\\\"orderNo\\\":\\\"MD1603107433327\\\",\\\"orderStatus\\\":0,\\\"payMode\\\":0,\\\"payStatus\\\":0,\\\"paymentType\\\":0,\\\"platId\\\":987,\\\"productType\\\":0,\\\"reduceAmount\\\":0.0,\\\"refId\\\":123456,\\\"resourceConsumerOrderList\\\":[{\\\"cardid\\\":\\\"3748784\\\",\\\"cardno\\\":\\\"377462838\\\",\\\"cardtype\\\":1,\\\"createtime\\\":1603107433325,\\\"createuser\\\":\\\"system\\\",\\\"mainorderno\\\":\\\"MD1603107433327\\\",\\\"memberid\\\":\\\"73836266\\\",\\\"occupytime\\\":1603107433325,\\\"triporderno\\\":\\\"TD1603107439088\\\",\\\"usestatus\\\":1}],\\\"revenueOrderInfoList\\\":[{\\\"buytime\\\":1603107433325,\\\"createtime\\\":1603107433325,\\\"createuser\\\":\\\"system\\\",\\\"goodscode\\\":\\\"SKU-10%_DiSCOUNT_CARD\\\",\\\"goodsid\\\":\\\"16001\\\",\\\"goodsname\\\":\\\"9折折扣卡\\\",\\\"mainorderno\\\":\\\"MD1603107433327\\\",\\\"memberid\\\":\\\"73836266\\\",\\\"resourcecode\\\":\\\"DiSCOUNT_CARD\\\",\\\"revenueorderno\\\":\\\"REVD1603107439088\\\",\\\"status\\\":1,\\\"type\\\":0}],\\\"sourceType\\\":10,\\\"supplierOrderNo\\\":\\\"\\\",\\\"ticketTotalPrice\\\":240.0,\\\"tripOrderInfo\\\":{\\\"extendContent\\\":\\\"{\\\\\\\"planCode\\\\\\\":\\\\\\\"场景code\\\\\\\"}\\\",\\\"indexNo\\\":0,\\\"mainOrderNo\\\":\\\"MD1603107433327\\\",\\\"orderStatus\\\":1,\\\"orderType\\\":1,\\\"payStatus\\\":0,\\\"serviceTotalPrice\\\":20.0,\\\"serviceUnitPrice\\\":10.0,\\\"supplierId\\\":\\\"\\\",\\\"ticketTotalPrice\\\":240.0,\\\"ticketUnitPrice\\\":120.0,\\\"travelFlag\\\":0,\\\"tripInfoVO\\\":{\\\"acceptnoseat\\\":0,\\\"beginSaleTime\\\":\\\"\\\",\\\"bindPhone\\\":\\\"\\\",\\\"chooseSeats\\\":\\\"\\\",\\\"createDate\\\":1603107433322,\\\"createUser\\\":\\\"\\\",\\\"endDateTime\\\":1603107433322,\\\"endStationCode\\\":\\\"szb\\\",\\\"endStationName\\\":\\\"苏州北站\\\",\\\"endStationState\\\":1,\\\"fromCity\\\":\\\"\\\",\\\"fromCityId\\\":0,\\\"grabEndTime\\\":1603107433322,\\\"password\\\":\\\"\\\",\\\"placeOrderForNight\\\":0,\\\"seatClass\\\":1,\\\"selfSelect\\\":0,\\\"startDateTime\\\":1603107433322,\\\"startStationCode\\\":\\\"bjn\\\",\\\"startStationName\\\":\\\"北京南站\\\",\\\"startStationState\\\":0,\\\"toCity\\\":\\\"\\\",\\\"toCityId\\\":0,\\\"trafficNo\\\":\\\"\\\",\\\"trainNo\\\":\\\"G183\\\",\\\"updateDate\\\":1603107433322,\\\"updateUser\\\":\\\"\\\",\\\"userName\\\":\\\"\\\"},\\\"tripOrderNo\\\":\\\"TD1603107439088\\\",\\\"tripPassengerOrderInfoList\\\":[{\\\"certificateNo\\\":\\\"1102238494577383747\\\",\\\"certificateType\\\":1,\\\"extendContent\\\":\\\"{\\\\\\\"SpecailInfo\\\\\\\":\\\\\\\"订单乘客1纬度扩展信息\\\\\\\"}\\\",\\\"mainOrderNo\\\":\\\"MD1603107433327\\\",\\\"passengerName\\\":\\\"张三\\\",\\\"passengerOrderNo\\\":\\\"TPD1603107439088\\\",\\\"passengerType\\\":1,\\\"sex\\\":0,\\\"ticketFlag\\\":0,\\\"tripOrderNo\\\":\\\"TD1603107439088\\\"},{\\\"certificateNo\\\":\\\"2102238494577383747\\\",\\\"certificateType\\\":1,\\\"extendContent\\\":\\\"{\\\\\\\"SpecailInfo\\\\\\\":\\\\\\\"订单乘客2纬度扩展信息\\\\\\\"}\\\",\\\"mainOrderNo\\\":\\\"MD1603107433327\\\",\\\"passengerName\\\":\\\"李四\\\",\\\"passengerOrderNo\\\":\\\"TPD1603107439088\\\",\\\"passengerType\\\":1,\\\"sex\\\":0,\\\"ticketFlag\\\":0,\\\"tripOrderNo\\\":\\\"TD1603107439088\\\"}],\\\"tripSerial\\\":\\\"TRIP1603107439088\\\",\\\"unionPay\\\":0},\\\"unionId\\\":\\\"USKDFJ-wejfksd\\\",\\\"unionPay\\\":0,\\\"updateDate\\\":1603107433325,\\\"updateUser\\\":\\\"\\\",\\\"userCreateDate\\\":1603107433325,\\\"validPayTime\\\":1603107433325}\",\"eventType\":\"NEW_CREATED\",\"id\":\"createOrder_10.97.20.179:8096_26_33334742592545_341\",\"orderNo\":\"MD1603107433327\",\"source\":\"order\",\"version\":1}','创单成功',1,'','2020-10-19 19:37:19'),(2,'updatePayInfo_10.97.20.179:8096_39_167986251862558_125','2020-10-21 09:01:30','order','{\"bypassId\":5365462,\"dataSnapshot\":\"{\\\"bookFlag\\\":0,\\\"canceled\\\":false,\\\"checkStatus\\\":0,\\\"contactEmail\\\":\\\"wangwu@qq.com\\\",\\\"contactName\\\":\\\"王五\\\",\\\"contactPhone\\\":\\\"13789287372\\\",\\\"createDate\\\":1603107433000,\\\"createUser\\\":\\\"system\\\",\\\"customerTotalAmount\\\":260.0,\\\"customerTotalPaid\\\":0.0,\\\"directPay\\\":0,\\\"discountAmount\\\":0.0,\\\"extendContent\\\":\\\"{\\\\\\\"bb\\\\\\\":5,\\\\\\\"customerNameList\\\\\\\":[\\\\\\\"张三\\\\\\\",\\\\\\\"李四\\\\\\\"],\\\\\\\"tQueryKey\\\\\\\":\\\\\\\"F3:\\\\\\\",\\\\\\\"constantDd\\\\\\\":666}\\\",\\\"id\\\":6,\\\"issueFlag\\\":0,\\\"mailStatus\\\":0,\\\"memberId\\\":5365462,\\\"openId\\\":\\\"Qjfsdjakfklsdafl\\\",\\\"orderNo\\\":\\\"MD1603107433327\\\",\\\"orderStatus\\\":12,\\\"payMode\\\":0,\\\"payStatus\\\":0,\\\"paymentType\\\":0,\\\"platId\\\":987,\\\"productType\\\":0,\\\"reduceAmount\\\":0.0,\\\"refId\\\":123456,\\\"sourceType\\\":10,\\\"supplierOrderNo\\\":\\\"\\\",\\\"ticketTotalPrice\\\":240.0,\\\"unionId\\\":\\\"USKDFJ-wejfksd\\\",\\\"unionPay\\\":0,\\\"updateDate\\\":1603107433000,\\\"updateUser\\\":\\\"\\\",\\\"userCreateDate\\\":1603107433000,\\\"validPayTime\\\":1603107433000,\\\"withHoldFailReason\\\":\\\"\\\",\\\"withHoldStatus\\\":0}\",\"eventType\":\"PAID_SUCCESS\",\"id\":\"updatePayInfo_10.97.20.179:8096_39_167986251862558_125\",\"orderNo\":\"MD1603107433327\",\"source\":\"order\",\"version\":1}','支付成功',1,'','2020-10-21 09:01:30');

/*Table structure for table `pay_order_info` */

DROP TABLE IF EXISTS `pay_order_info`;

CREATE TABLE `pay_order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单自增ID（主键）',
  `union_pay_order_no` varchar(50) NOT NULL COMMENT '合单支付订单号',
  `main_order_no` varchar(50) NOT NULL COMMENT '购买主订单流水号',
  `child_order_no` varchar(50) NOT NULL COMMENT '被支付的子订单流水号',
  `child_order_type` int(5) NOT NULL DEFAULT '0' COMMENT '子订单类型: 0-出行订单 1-营收商品订单',
  `pay_mode` varchar(40) DEFAULT NULL COMMENT '支付方式：代扣或正常支付',
  `status` int(5) NOT NULL DEFAULT '0' COMMENT '状态: 0-任务取消，1-支付中，2-支付成功， 3-支付失败',
  `pay_fail_reason` varchar(512) NOT NULL DEFAULT '' COMMENT '支付失败原因',
  `amount` decimal(18,4) NOT NULL DEFAULT '0.0000' COMMENT '金额',
  `pay_serial_no` varchar(50) NOT NULL DEFAULT '' COMMENT '统一支付流水号',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `create_user` varchar(40) NOT NULL DEFAULT '' COMMENT '创建人',
  `update_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '更新日期',
  `update_user` varchar(40) NOT NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付任务订单表';

/*Data for the table `pay_order_info` */

/*Table structure for table `pay_write_back_log` */

DROP TABLE IF EXISTS `pay_write_back_log`;

CREATE TABLE `pay_write_back_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `tc_serial_id` varchar(100) NOT NULL COMMENT '公共支付交易流水号',
  `out_serialId` varchar(100) NOT NULL COMMENT '项目交易唯一号',
  `order_no` varchar(20) NOT NULL COMMENT '订单编号',
  `mer_serial_id` varchar(100) NOT NULL COMMENT '供应商交易流水号',
  `pay_code` int(11) NOT NULL DEFAULT '0' COMMENT '支付状态\n                         0未知\n                        1未支付\n                        2支付中\n                        3支付成功\n                        4支付失败\n                        5交易关闭\n                        6交易超时到期\n                        7交易冲正\n                        8预授权成功   99 重复回调',
  `re_info` varchar(200) NOT NULL COMMENT '支付备注\n                        Errorcode|ErrorInfo',
  `amount` decimal(18,4) NOT NULL DEFAULT '0.0000' COMMENT '金额',
  `channel_id` int(11) NOT NULL DEFAULT '0' COMMENT '支付渠道编码 10：现金支付 11：系统外支付 12200:AB虚拟支付',
  `channel_name` varchar(50) NOT NULL COMMENT '支付渠道名称',
  `product_id` int(11) NOT NULL DEFAULT '0' COMMENT '支付产品编码',
  `product_name` varchar(50) NOT NULL COMMENT '支付产品名称',
  `pay_finished_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '支付完成时间',
  `ext_data` varchar(100) NOT NULL COMMENT '扩展数据形式\n                        a=a&b=b目前增加一个值为cardtype =1或者2 1：储蓄卡2：信用卡',
  `open_id` varchar(50) NOT NULL COMMENT '微信sdk、jsapi V3版本返回openid',
  `user_account` varchar(50) NOT NULL COMMENT '用户账户',
  `short_name` varchar(50) NOT NULL COMMENT '银行简称\n                        例如ABC',
  `bank_name` varchar(50) NOT NULL COMMENT '银行名称\n                        例如农业银行，可能为空',
  `card_type` varchar(20) NOT NULL COMMENT '卡类型',
  `project_order` varchar(64) NOT NULL COMMENT '项目订单号',
  `project_code` varchar(64) NOT NULL COMMENT '项目编码',
  `finance_code` varchar(64) NOT NULL COMMENT '商户号',
  `payment_count` int(11) NOT NULL DEFAULT '0' COMMENT '支付次数\n                        （1为首次支付）',
  `union_order` varchar(64) NOT NULL COMMENT '联合单号\n                        当用户不选择分账支付时联合单号和projectorder节点的值一致',
  `operation_type` int(11) NOT NULL DEFAULT '0' COMMENT '操作类型\n                        1：普通支付\n                        2、预授权\n                        3：退款\n                        4：打款\n                        5：交易查询\n                        6：退款查询\n                        7：获取短信验证码\n                        8：账户冻结\n                        9：现金红包\n                        10：撤销易\n                        11：预授权完成\n                        12：通用接口\n                        13：支付回写\n                        14：退款回写\n                        15：分账支付产品单\n                        16分',
  `reduce_amount` varchar(64) NOT NULL COMMENT '立减金额',
  `award_amount` varchar(64) NOT NULL COMMENT '返现金额',
  `company_code` varchar(64) NOT NULL COMMENT '公司主体编码',
  `from_plat` int(11) NOT NULL DEFAULT '0' COMMENT '来源平台\n                        1.project-pc\n                        2.ios-app\n                        3.project-moblie\n                        4.android-app\n                        5.pc-casher\n                        6.moblie-casher\n                        7.cct-casher\n                        8.store-casher\n                        11.qq\n                        12.weixin',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ref_refund_serialId` varchar(64) NOT NULL COMMENT '关联虚拟退款单据号',
  `ref_order_serialId` varchar(64) NOT NULL COMMENT '关联的原订单号',
  PRIMARY KEY (`id`),
  KEY `order_no` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付回写记录表';

/*Data for the table `pay_write_back_log` */

/*Table structure for table `refund_ticket_order` */

DROP TABLE IF EXISTS `refund_ticket_order`;

CREATE TABLE `refund_ticket_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单自增ID（主键）',
  `main_order_no` varchar(50) NOT NULL COMMENT '要退票的主订单流水号',
  `passenger_order_no` varchar(50) NOT NULL COMMENT '要退票的票订单流水号',
  `ticket_no` varchar(50) NOT NULL COMMENT '票号',
  `refund_charge` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '退票手续费',
  `status` int(5) NOT NULL DEFAULT '0' COMMENT '退票订单处理状态: 0-申请退票，1-退票中，2-退票成功， 3-退票失败',
  `reason_code` int(11) NOT NULL DEFAULT '0' COMMENT '退票原因code -1:其它原因  0：直接取消，没选原因',
  `reason` varchar(512) NOT NULL COMMENT '申请退票原因',
  `reject_reason` varchar(512) NOT NULL COMMENT '退票失败原因',
  `member_id` int(11) NOT NULL DEFAULT '0' COMMENT '会员id',
  `union_id` varchar(50) NOT NULL COMMENT '记录用户unionId',
  `open_id` varchar(50) NOT NULL COMMENT 'openId，微信平台订票时有值',
  `apply_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '申请退票时间',
  `refund_type` int(2) NOT NULL DEFAULT '0' COMMENT '0-默认  1-线上退 2-线下跑腿 3-线下车站',
  `run_settle_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '跑腿费结算金额',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `create_user` varchar(40) NOT NULL COMMENT '创建人',
  `update_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '更新日期',
  `update_user` varchar(40) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='退票订单表';

/*Data for the table `refund_ticket_order` */

/*Table structure for table `resource_consumer_order` */

DROP TABLE IF EXISTS `resource_consumer_order`;

CREATE TABLE `resource_consumer_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `mainOrderNo` varchar(50) NOT NULL COMMENT '主订单号',
  `tripOrderNo` varchar(50) NOT NULL COMMENT '优惠的行程订单号',
  `cardId` varchar(50) NOT NULL COMMENT '卡券ID',
  `cardNo` varchar(50) NOT NULL COMMENT '卡券编号',
  `cardType` int(5) NOT NULL DEFAULT '0' COMMENT '卡券类型 0：普通券 3：朋友券 4：火车票售卖代金券 5：退改无忧理赔代金券 6代金券红包',
  `card_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '抵扣金额',
  `memberId` varchar(50) NOT NULL COMMENT '会员id',
  `useStatus` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0-初始状态 1-已占用；2-已核销；30-占用失败 31-核销失败',
  `reason` varchar(50) NOT NULL DEFAULT '' COMMENT '卡券消费失败原因',
  `occupyTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '占用时间',
  `writeoffTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '核销时间',
  `createTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '创建日期',
  `createUser` varchar(20) NOT NULL DEFAULT '' COMMENT '创建人',
  `updateTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '更新日期',
  `updateUser` varchar(20) NOT NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='营销商品消费记录表';

/*Data for the table `resource_consumer_order` */

insert  into `resource_consumer_order`(`id`,`mainOrderNo`,`tripOrderNo`,`cardId`,`cardNo`,`cardType`,`card_amount`,`memberId`,`useStatus`,`reason`,`occupyTime`,`writeoffTime`,`createTime`,`createUser`,`updateTime`,`updateUser`) values (3,'MD1603107433327','TD1603107439088','3748784','377462838',1,'0.00','73836266',1,'','2020-10-19 19:37:13','1900-01-01 00:00:00','2020-10-19 19:37:19','system','1900-01-01 00:00:00','');

/*Table structure for table `revenue_order_info` */

DROP TABLE IF EXISTS `revenue_order_info`;

CREATE TABLE `revenue_order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `mainOrderNo` varchar(50) NOT NULL COMMENT '主订单号',
  `revenueOrderNo` varchar(50) NOT NULL COMMENT '营收商品订单号',
  `goodsId` varchar(50) NOT NULL DEFAULT '' COMMENT '营收商品ID',
  `goodsCode` varchar(50) NOT NULL DEFAULT '' COMMENT '营收商品编码',
  `goodsName` varchar(50) NOT NULL DEFAULT '' COMMENT '营收商品名称',
  `resourceCode` varchar(50) NOT NULL DEFAULT '' COMMENT '商品对应的资源编码',
  `type` int(5) NOT NULL DEFAULT '0' COMMENT '类型',
  `memberId` varchar(50) NOT NULL DEFAULT '''0''' COMMENT '会员id',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0-初始状态 1-已下单购买；2-已出库；3-已取消 40-购买失败 41-出库失败',
  `reason` varchar(50) NOT NULL DEFAULT '' COMMENT '失败原因',
  `buyTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '购买时间',
  `activeTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '出库时间',
  `createTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '创建日期',
  `createUser` varchar(20) NOT NULL DEFAULT '' COMMENT '创建人',
  `updateTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '更新日期',
  `updateUser` varchar(20) NOT NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='营收商品购买记录表';

/*Data for the table `revenue_order_info` */

insert  into `revenue_order_info`(`id`,`mainOrderNo`,`revenueOrderNo`,`goodsId`,`goodsCode`,`goodsName`,`resourceCode`,`type`,`memberId`,`status`,`reason`,`buyTime`,`activeTime`,`createTime`,`createUser`,`updateTime`,`updateUser`) values (2,'MD1603107433327','REVD1603107439088','16001','SKU-10%_DiSCOUNT_CARD','9折折扣卡','DiSCOUNT_CARD',0,'73836266',1,'','2020-10-19 19:37:13','1900-01-01 00:00:00','2020-10-19 19:37:19','system','1900-01-01 00:00:00','');

/*Table structure for table `ticket_info` */

DROP TABLE IF EXISTS `ticket_info`;

CREATE TABLE `ticket_info` (
  `id` bigint(21) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `ticket_serial` varchar(50) NOT NULL COMMENT '票记录信息流水号',
  `ticket_no` varchar(50) NOT NULL COMMENT '客票号/取票号',
  `ticket_price` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '车票价格',
  `carriage_no` varchar(50) NOT NULL COMMENT '车厢号',
  `seat_no` varchar(50) NOT NULL COMMENT '座位号(有多个乘客时,会用逗号分隔)',
  `seat_class` int(5) NOT NULL DEFAULT '0' COMMENT '座位类别:1：硬座 2：软座 3：一等座 4：二等座 5：硬卧上铺 6：硬卧中铺 7：硬卧下铺 8：软卧上铺 9：软卧下铺 10：无座 11：商务座 12：特等座13::其它14::高级软卧',
  `sms` varchar(300) NOT NULL COMMENT '取票信息',
  `ticket_password` varchar(50) NOT NULL COMMENT '取票密码',
  `ticket_verify_code` varchar(50) NOT NULL COMMENT '取票验证码',
  `ticket_order_num` varchar(50) NOT NULL COMMENT '取票网站订单号',
  `ticket_phone` varchar(20) NOT NULL COMMENT '取票手机号',
  `checkin_nos` varchar(20) NOT NULL COMMENT '检票口',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='票信息表';

/*Data for the table `ticket_info` */

/*Table structure for table `train_trip_info` */

DROP TABLE IF EXISTS `train_trip_info`;

CREATE TABLE `train_trip_info` (
  `id` bigint(21) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `trip_serial` varchar(50) NOT NULL COMMENT '行程流水号',
  `train_no` varchar(50) NOT NULL COMMENT '列车班次号',
  `seat_class` int(11) NOT NULL DEFAULT '0' COMMENT '座位类别:1：硬座 2：软座 3：一等座 4：二等座 5：硬卧上铺 6：硬卧中铺 7：硬卧下铺 8：软卧上铺 9：软卧下铺 10：无座 11：商务座 12：特等座13::其它14::高级软卧',
  `start_station_code` varchar(10) NOT NULL DEFAULT '' COMMENT '发车代码',
  `start_station_name` varchar(20) NOT NULL DEFAULT '' COMMENT '出发站名',
  `start_station_state` int(11) NOT NULL DEFAULT '0' COMMENT '0 未知 1始 2过 3终',
  `end_station_code` varchar(10) NOT NULL DEFAULT '' COMMENT '到站代码',
  `end_station_name` varchar(20) NOT NULL DEFAULT '' COMMENT '到站站名',
  `end_station_state` int(11) NOT NULL DEFAULT '0' COMMENT '0 未知  1始  2经 3停',
  `place_order_for_night` int(11) NOT NULL DEFAULT '0' COMMENT '是否夜间单:0--白天单（先占后付）,1--夜间单,2--先付后占',
  `user_name` varchar(100) NOT NULL DEFAULT '' COMMENT '自购票账号',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '自购票密码（加密）',
  `bind_phone` varchar(20) NOT NULL DEFAULT '' COMMENT '12306账户绑定手机号',
  `choose_seats` varchar(20) NOT NULL DEFAULT '' COMMENT '在线选座坐席',
  `acceptnoseat` int(11) NOT NULL DEFAULT '0' COMMENT '是否接受无座，0：不接受  1：接受',
  `grab_end_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '抢票截止时间',
  `begin_sale_time` varchar(50) NOT NULL DEFAULT '' COMMENT '预售时间（预约单）',
  `self_select` int(11) NOT NULL DEFAULT '0' COMMENT '是否是自选车次 0-否 1-是',
  `from_city` varchar(50) NOT NULL DEFAULT '' COMMENT '出发城市',
  `to_city` varchar(50) NOT NULL DEFAULT '' COMMENT '到达城市',
  `start_date_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '发车时间（发车日期+时间）',
  `end_date_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '到站时间（到站日期+时间）',
  `from_city_id` int(11) NOT NULL DEFAULT '0' COMMENT '出发城市id',
  `to_city_id` int(11) NOT NULL DEFAULT '0' COMMENT '到达城市id',
  `traffic_no` varchar(20) NOT NULL DEFAULT '' COMMENT '班次号',
  `create_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '创建日期',
  `create_user` varchar(40) NOT NULL DEFAULT '' COMMENT '创建人',
  `update_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '更新日期',
  `update_user` varchar(40) NOT NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='火车行程信息表';

/*Data for the table `train_trip_info` */

insert  into `train_trip_info`(`id`,`trip_serial`,`train_no`,`seat_class`,`start_station_code`,`start_station_name`,`start_station_state`,`end_station_code`,`end_station_name`,`end_station_state`,`place_order_for_night`,`user_name`,`password`,`bind_phone`,`choose_seats`,`acceptnoseat`,`grab_end_time`,`begin_sale_time`,`self_select`,`from_city`,`to_city`,`start_date_time`,`end_date_time`,`from_city_id`,`to_city_id`,`traffic_no`,`create_date`,`create_user`,`update_date`,`update_user`) values (6,'TRIP1603107439088','G183',1,'bjn','北京南站',0,'szb','苏州北站',1,0,'','','','',0,'2020-10-19 19:37:13','',0,'','','2020-10-19 19:37:13','2020-10-19 19:37:13',0,0,'','2020-10-19 19:37:13','','2020-10-19 19:37:13','');

/*Table structure for table `trip_order_info` */

DROP TABLE IF EXISTS `trip_order_info`;

CREATE TABLE `trip_order_info` (
  `id` bigint(21) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `main_order_no` varchar(50) NOT NULL COMMENT '主订单流水号',
  `trip_order_no` varchar(50) NOT NULL COMMENT '出行订单流水号',
  `trip_serial` varchar(50) NOT NULL COMMENT '关联具体的行程信息：行程流水号',
  `index_no` int(2) NOT NULL DEFAULT '0' COMMENT '此订单在行程中的顺序(默认0)',
  `order_type` int(5) NOT NULL DEFAULT '0' COMMENT '订单类型: 1-火车票, 2-用车, 3-飞机, 4-汽车, 7-火车抢票 8-电子客票 9-港铁',
  `pay_status` int(5) NOT NULL DEFAULT '0' COMMENT '付款状态 0：未付款 1：已付款',
  `order_status` int(5) NOT NULL DEFAULT '0' COMMENT '订单状态:10-待支付,11-支付中| 20-待占座,21-占座中,22-占座成功,23-占座失败| 30-待出票,31-出票中,32-出票完成,33-出票失败| 62-用户取消,63-过期取消|91-下单失败',
  `travel_flag` int(5) NOT NULL DEFAULT '0' COMMENT '是否已出行 0-未出行 1-已出行',
  `ticket_unit_price` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '票价单价',
  `ticket_total_price` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '票价总额: 票价单价*人数 + 服务费单价*人数',
  `service_unit_price` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '服务费单价',
  `service_total_price` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '服务费总额',
  `supplier_id` varchar(10) NOT NULL DEFAULT '' COMMENT '供应商id',
  `union_pay` int(5) NOT NULL DEFAULT '0' COMMENT '是否合单支付: 0--非合单支付, 1--合单支付',
  `with_hold_status` int(5) NOT NULL DEFAULT '0' COMMENT '微信代扣状态 0-微信支付 1，2-微信代扣 3-微信代扣转微信支付',
  `with_hold_fail_reason` varchar(100) NOT NULL DEFAULT '' COMMENT '代扣失败原因',
  `apply_place_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '申请占座时间',
  `place_callback_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '占座回写时间',
  `apply_issue_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '申请出票时间',
  `issue_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '出票时间',
  `reject_apply_remark` varchar(500) NOT NULL DEFAULT '' COMMENT '占座或出票失败原因',
  `extend_content` varchar(10240) NOT NULL DEFAULT '' COMMENT '扩展信息',
  `create_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '创建日期',
  `create_user` varchar(40) NOT NULL DEFAULT '' COMMENT '创建人',
  `update_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '更新日期',
  `update_user` varchar(40) NOT NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='订单出行信息表';

/*Data for the table `trip_order_info` */

insert  into `trip_order_info`(`id`,`main_order_no`,`trip_order_no`,`trip_serial`,`index_no`,`order_type`,`pay_status`,`order_status`,`travel_flag`,`ticket_unit_price`,`ticket_total_price`,`service_unit_price`,`service_total_price`,`supplier_id`,`union_pay`,`with_hold_status`,`with_hold_fail_reason`,`apply_place_time`,`place_callback_time`,`apply_issue_time`,`issue_time`,`reject_apply_remark`,`extend_content`,`create_date`,`create_user`,`update_date`,`update_user`) values (5,'MD1603107433327','TD1603107439088','TRIP1603107439088',0,1,0,1,0,'120.00','240.00','10.00','20.00','',0,0,'','1900-01-01 00:00:00','1900-01-01 00:00:00','1900-01-01 00:00:00','1900-01-01 00:00:00','','{\"planCode\":\"场景code\"}','2020-10-19 19:37:19','','1900-01-01 00:00:00','');

/*Table structure for table `trip_passenger_order_info` */

DROP TABLE IF EXISTS `trip_passenger_order_info`;

CREATE TABLE `trip_passenger_order_info` (
  `id` bigint(21) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `main_order_no` varchar(50) NOT NULL COMMENT '主订单流水号',
  `trip_order_no` varchar(50) NOT NULL COMMENT '出行订单流水号',
  `passenger_order_no` varchar(50) NOT NULL COMMENT '出行订单流水号',
  `trip_serial` varchar(50) NOT NULL DEFAULT '' COMMENT '关联具体的行程信息：行程流水号',
  `ticket_flag` int(11) NOT NULL DEFAULT '0' COMMENT '车票的状态 0:未出票 1:已出票',
  `passenger_serial_no` varchar(50) NOT NULL DEFAULT '' COMMENT '对应乘客流水号',
  `passenger_name` varchar(50) NOT NULL DEFAULT '' COMMENT '乘客姓名',
  `passenger_type` int(11) NOT NULL DEFAULT '0' COMMENT '乘客类型:1:成人 2:儿童 3:学生',
  `certificate_type` int(11) NOT NULL DEFAULT '0' COMMENT '证件类型:(0:其他,1:身份证,2:护照,3:台胞证,4:港澳通行证)',
  `certificate_no` varchar(100) NOT NULL DEFAULT '' COMMENT '证件号码',
  `sex` int(2) NOT NULL DEFAULT '0' COMMENT '性别 1 男性 2女性 0 未知',
  `ticket_serial` varchar(50) NOT NULL DEFAULT '' COMMENT '票记录信息流水号',
  `ticket_summary` varchar(512) NOT NULL DEFAULT '' COMMENT '票信息摘要',
  `refund_status` varchar(50) NOT NULL DEFAULT '' COMMENT '退票状态：0默认，1受理中，2受理完成，3驳回退票，4无法线上退票',
  `is_change_ticket` int(2) NOT NULL DEFAULT '0' COMMENT '是否改签单 0：正常订单，1：改签单',
  `order_change_type` int(11) NOT NULL DEFAULT '0' COMMENT '当前订单改签类型：0:改签前订单 1:改签后新订单',
  `create_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '创建日期',
  `create_user` varchar(40) NOT NULL DEFAULT '' COMMENT '创建人',
  `update_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '更新日期',
  `update_user` varchar(40) NOT NULL DEFAULT '' COMMENT '更新人',
  `extend_content` varchar(10240) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='乘客行程信息表';

/*Data for the table `trip_passenger_order_info` */

insert  into `trip_passenger_order_info`(`id`,`main_order_no`,`trip_order_no`,`passenger_order_no`,`trip_serial`,`ticket_flag`,`passenger_serial_no`,`passenger_name`,`passenger_type`,`certificate_type`,`certificate_no`,`sex`,`ticket_serial`,`ticket_summary`,`refund_status`,`is_change_ticket`,`order_change_type`,`create_date`,`create_user`,`update_date`,`update_user`,`extend_content`) values (7,'MD1603107433327','TD1603107439088','TPD1603107439088','',0,'','张三',1,1,'1102238494577383747',0,'','','',0,0,'2020-10-19 19:37:19','','1900-01-01 00:00:00','','{\"SpecailInfo\":\"订单乘客1纬度扩展信息\"}'),(8,'MD1603107433327','TD1603107439088','TPD1603107439088','',0,'','李四',1,1,'2102238494577383747',0,'','','',0,0,'2020-10-19 19:37:19','','1900-01-01 00:00:00','','{\"SpecailInfo\":\"订单乘客2纬度扩展信息\"}');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
