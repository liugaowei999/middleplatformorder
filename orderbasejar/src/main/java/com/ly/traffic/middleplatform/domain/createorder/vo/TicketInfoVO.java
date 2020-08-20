package com.ly.traffic.middleplatform.domain.createorder.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 票信息(TicketInfoPO)
 *
 * @author gaowei.liu
 * @since 2020-08-20 14:11:35
 */
@Getter
@Setter
public class TicketInfoVO {
    /**
    * 客票号/取票号
    */
    private String ticketNo;
    /**
    * 车票价格
    */
    private Double ticketPrice;
    /**
    * 车厢号
    */
    private String carriageNo;
    /**
    * 座位号(有多个乘客时,会用逗号分隔)
    */
    private String seatNo;
    /**
    * 座位类别:1：硬座 2：软座 3：一等座 4：二等座 5：硬卧上铺 6：硬卧中铺 7：硬卧下铺 8：软卧上铺 9：软卧下铺 10：无座 11：商务座 12：特等座13::其它14::高级软卧
    */
    private Integer seatClass;
    /**
    * 取票信息
    */
    private String sms;
    /**
    * 取票密码
    */
    private String ticketPassword;
    /**
    * 取票验证码
    */
    private String ticketVerifyCode;
    /**
    * 取票网站订单号
    */
    private String ticketOrderNum;
    /**
    * 取票手机号
    */
    private String ticketPhone;
    /**
    * 检票口
    */
    private String checkinNos;


}
