package com.ly.traffic.middleplatform.domain.order.repository.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 营收商品购买记录表(RevenueOrderInfoPO)实体类
 *
 * @author makejava
 * @since 2020-08-20 14:11:35
 */
public class RevenueOrderInfoPO implements Serializable {
    private static final long serialVersionUID = 857806868856480886L;
    /**
    * id
    */
    private Long id;
    /**
    * 主订单号
    */
    private String mainorderno;
    /**
    * 营收商品订单号
    */
    private String revenueorderno;
    /**
    * 营收商品ID
    */
    private String goodsid;
    /**
    * 营收商品编码
    */
    private String goodscode;
    /**
    * 营收商品名称
    */
    private String goodsname;
    /**
    * 商品对应的资源编码
    */
    private String resourcecode;
    /**
    * 类型
    */
    private Integer type;
    /**
    * 会员id
    */
    private String memberid;
    /**
    * 状态 0-初始状态 1-已下单购买；2-已出库；3-已取消 40-购买失败 41-出库失败
    */
    private Integer status;
    /**
    * 失败原因
    */
    private String reason;
    /**
    * 购买时间
    */
    private Date buytime;
    /**
    * 出库时间
    */
    private Date activetime;
    /**
    * 创建日期
    */
    private Date createtime;
    /**
    * 创建人
    */
    private String createuser;
    /**
    * 更新日期
    */
    private Date updatetime;
    /**
    * 更新人
    */
    private String updateuser;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainorderno() {
        return mainorderno;
    }

    public void setMainorderno(String mainorderno) {
        this.mainorderno = mainorderno;
    }

    public String getRevenueorderno() {
        return revenueorderno;
    }

    public void setRevenueorderno(String revenueorderno) {
        this.revenueorderno = revenueorderno;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodscode() {
        return goodscode;
    }

    public void setGoodscode(String goodscode) {
        this.goodscode = goodscode;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getResourcecode() {
        return resourcecode;
    }

    public void setResourcecode(String resourcecode) {
        this.resourcecode = resourcecode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public Date getActivetime() {
        return activetime;
    }

    public void setActivetime(Date activetime) {
        this.activetime = activetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

}
