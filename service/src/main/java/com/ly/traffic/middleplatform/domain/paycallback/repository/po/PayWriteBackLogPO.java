package com.ly.traffic.middleplatform.domain.paycallback.repository.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 支付回写记录表(PayWriteBackLogPO)实体类
 *
 * @author makejava
 * @since 2020-08-25 18:43:39
 */
public class PayWriteBackLogPO implements Serializable {
    private static final long serialVersionUID = 739882392704145740L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 公共支付交易流水号
    */
    private String tcSerialId;
    /**
    * 项目交易唯一号
    */
    private String outSerialid;
    /**
    * 订单编号
    */
    private String orderNo;
    /**
    * 供应商交易流水号
    */
    private String merSerialId;
    /**
    * 支付状态
             0未知
            1未支付
            2支付中
            3支付成功
            4支付失败
            5交易关闭
            6交易超时到期
            7交易冲正
            8预授权成功   99 重复回调
    */
    private Integer payCode;
    /**
    * 支付备注
            Errorcode|ErrorInfo
    */
    private String reInfo;
    /**
    * 金额
    */
    private Double amount;
    /**
    * 支付渠道编码 10：现金支付 11：系统外支付 12200:AB虚拟支付
    */
    private Integer channelId;
    /**
    * 支付渠道名称
    */
    private String channelName;
    /**
    * 支付产品编码
    */
    private Integer productId;
    /**
    * 支付产品名称
    */
    private String productName;
    /**
    * 支付完成时间
    */
    private Date payFinishedTime;
    /**
    * 扩展数据形式
            a=a&b=b目前增加一个值为cardtype =1或者2 1：储蓄卡2：信用卡
    */
    private String extData;
    /**
    * 微信sdk、jsapi V3版本返回openid
    */
    private String openId;
    /**
    * 用户账户
    */
    private String userAccount;
    /**
    * 银行简称
            例如ABC
    */
    private String shortName;
    /**
    * 银行名称
            例如农业银行，可能为空
    */
    private String bankName;
    /**
    * 卡类型
    */
    private String cardType;
    /**
    * 项目订单号
    */
    private String projectOrder;
    /**
    * 项目编码
    */
    private String projectCode;
    /**
    * 商户号
    */
    private String financeCode;
    /**
    * 支付次数
            （1为首次支付）
    */
    private Integer paymentCount;
    /**
    * 联合单号
            当用户不选择分账支付时联合单号和projectorder节点的值一致
    */
    private String unionOrder;
    /**
    * 操作类型
            1：普通支付
            2、预授权
            3：退款
            4：打款
            5：交易查询
            6：退款查询
            7：获取短信验证码
            8：账户冻结
            9：现金红包
            10：撤销易
            11：预授权完成
            12：通用接口
            13：支付回写
            14：退款回写
            15：分账支付产品单
            16分
    */
    private Integer operationType;
    /**
    * 立减金额
    */
    private String reduceAmount;
    /**
    * 返现金额
    */
    private String awardAmount;
    /**
    * 公司主体编码
    */
    private String companyCode;
    /**
    * 来源平台
            1.project-pc
            2.ios-app
            3.project-moblie
            4.android-app
            5.pc-casher
            6.moblie-casher
            7.cct-casher
            8.store-casher
            11.qq
            12.weixin
    */
    private Integer fromPlat;
    /**
    * 创建人
    */
    private String createUser;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 关联虚拟退款单据号
    */
    private String refRefundSerialid;
    /**
    * 关联的原订单号
    */
    private String refOrderSerialid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTcSerialId() {
        return tcSerialId;
    }

    public void setTcSerialId(String tcSerialId) {
        this.tcSerialId = tcSerialId;
    }

    public String getOutSerialid() {
        return outSerialid;
    }

    public void setOutSerialid(String outSerialid) {
        this.outSerialid = outSerialid;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMerSerialId() {
        return merSerialId;
    }

    public void setMerSerialId(String merSerialId) {
        this.merSerialId = merSerialId;
    }

    public Integer getPayCode() {
        return payCode;
    }

    public void setPayCode(Integer payCode) {
        this.payCode = payCode;
    }

    public String getReInfo() {
        return reInfo;
    }

    public void setReInfo(String reInfo) {
        this.reInfo = reInfo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getPayFinishedTime() {
        return payFinishedTime;
    }

    public void setPayFinishedTime(Date payFinishedTime) {
        this.payFinishedTime = payFinishedTime;
    }

    public String getExtData() {
        return extData;
    }

    public void setExtData(String extData) {
        this.extData = extData;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getProjectOrder() {
        return projectOrder;
    }

    public void setProjectOrder(String projectOrder) {
        this.projectOrder = projectOrder;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getFinanceCode() {
        return financeCode;
    }

    public void setFinanceCode(String financeCode) {
        this.financeCode = financeCode;
    }

    public Integer getPaymentCount() {
        return paymentCount;
    }

    public void setPaymentCount(Integer paymentCount) {
        this.paymentCount = paymentCount;
    }

    public String getUnionOrder() {
        return unionOrder;
    }

    public void setUnionOrder(String unionOrder) {
        this.unionOrder = unionOrder;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public String getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(String reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public String getAwardAmount() {
        return awardAmount;
    }

    public void setAwardAmount(String awardAmount) {
        this.awardAmount = awardAmount;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Integer getFromPlat() {
        return fromPlat;
    }

    public void setFromPlat(Integer fromPlat) {
        this.fromPlat = fromPlat;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRefRefundSerialid() {
        return refRefundSerialid;
    }

    public void setRefRefundSerialid(String refRefundSerialid) {
        this.refRefundSerialid = refRefundSerialid;
    }

    public String getRefOrderSerialid() {
        return refOrderSerialid;
    }

    public void setRefOrderSerialid(String refOrderSerialid) {
        this.refOrderSerialid = refOrderSerialid;
    }

}
