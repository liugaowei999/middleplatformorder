package com.ly.traffic.middleplatform.domain.order.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ly.traffic.middleplatform.utils.object.ObjectValue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 主订单表(MainOrder)实体类
 * @author gaowei.liu
 * @since 2020-08-07 17:29:26
 */
@Getter
@Setter
public class MainOrder implements Serializable {
    private static final long serialVersionUID = -30894447145784069L;
    /**
    * 订单自增ID（主键）
    */
    private Integer id;
    /**
    * 主订单流水号
    */
    private String orderno;
    /**
    * 会员id
    */
    private Integer memberid;
    /**
    * 记录用户unionId
    */
    private String unionid;
    /**
    * openId，微信平台订票时有值
    */
    private String openid;
    /**
    * 供应商订单号
    */
    private String supplierorderno;
    /**
    * 支付方式：0-普通，1-直连支付，2-两程分开代扣，3-两程分开代扣转两程一起支付(第一程代扣失败的场景)
    */
    private Integer directpay;
    /**
    * 出票模式：0-两程都占座成功后出票，1-一程出票成功后再占座另一程
    */
    private Integer issueflag;
    /**
    * 付款方式：0--先占座后支付(微信支付)，1--先支付后占座(微信支付)
    */
    private Integer paymenttype;
    /**
    * 支付过期时间
    */
    private Date validpaytime;
    /**
    * 是否合单支付: 0--非合单支付, 1--合单支付
    */
    private Integer unionpay;
    /**
    * 身份核验状态 0-无需核验 1-核验中 2-核验通过 3-核验失败
    */
    private Integer checkstatus;
    /**
    * 订单状态:10-待支付，11-支付中，
             20-待占座，21-占座中，22-占座成功，23-占座失败，
             30-待出票，31-出票中，32-出票完成；33-出票失败；
             40-待退票，41-退票中，42-退票完成；43-退票失败；
             50-驳回订单;
             60-申请取消，61-取消中，62-已取消；63-过期取消；
             90-已出行;91-下单失败
    */
    private Integer orderstatus;
    /**
    * 1. 未邮寄; 2.已邮寄; 3.无需邮寄;0， 未知
    */
    private Object mailflag;
    /**
    * 客人是否付款同程 0：未付款 1：已付款
    */
    private Integer paystatus;
    /**
    * 微信代扣状态 0-微信支付 1，2-微信代扣 3-微信代扣转微信支付
    */
    private Integer withholdstatus;
    /**
    * 代扣失败原因
    */
    private String withholdfailreason;
    /**
    * 联系人名称
    */
    private String contactname;
    /**
    * 联系人手机号
    */
    private String contactphone;
    /**
    * 联系人Email
    */
    private String contactemail;
    /**
    * 客人应付同程总额
    */
    private Double customertotalamount;
    /**
    * 客人实付同程总额
    */
    private Double customertotalpaid;
    /**
    * 票价总额
    */
    private Double tickettotalprice;
    /**
    * 活动立减金额
    */
    private Double reduceamount;
    /**
    * 优惠金额
    */
    private Double discountamount;
    /**
    * 预订标识，1-正常，2-收单
    */
    private Integer bookflag;

    /**
    * 点击预定按钮时间
    */
    private Date usercreatedate;
    /**
    * 创建日期
    */
    private Date createdate;
    /**
    * 创建人
    */
    private String createuser;
    /**
    * 更新日期
    */
    private Date updatedate;
    /**
    * 更新人
    */
    private String updateuser;


    private String translate() {
        try {
            return ObjectValue.getJSONString(this.getClass(), this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return super.toString();
    }
    @Override
    public String toString() {
        return translate();
    }
}
