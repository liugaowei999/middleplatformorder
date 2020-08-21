package com.ly.traffic.middleplatform.domain.order.entity;


import com.ly.traffic.middleplatform.domain.createorder.entity.MainOrder;
import com.ly.traffic.middleplatform.domain.createorder.entity.TripOrderInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order
 * @Description: ${TODO}
 * @date 2020/7/6 15:00
 */
@Getter
@Setter
public class OrderAggregate extends MainOrder {

    /**
     * 微信代扣状态 0-微信支付 1，2-微信代扣 3-微信代扣转微信支付
     */
    private Integer withHoldStatus;
    /**
     * 代扣失败原因
     */
    private String withHoldFailReason;

    /**
     * 扩展信息
     */
    private String extendContent;

    /**
     * 订单出行信息
     */
    private UTripOrderInfo tripOrderInfo;

}
