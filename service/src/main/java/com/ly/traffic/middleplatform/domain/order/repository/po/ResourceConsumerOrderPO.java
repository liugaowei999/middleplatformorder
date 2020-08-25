package com.ly.traffic.middleplatform.domain.order.repository.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 营销商品消费记录表(ResourceConsumerOrderPO)实体类
 *
 * @author makejava
 * @since 2020-08-20 14:11:36
 */
public class ResourceConsumerOrderPO implements Serializable {
    private static final long serialVersionUID = -63766112708404661L;
    /**
    * id
    */
    private Long id;
    /**
    * 主订单号
    */
    private String mainorderno;
    /**
    * 优惠的行程订单号
    */
    private String triporderno;
    /**
    * 卡券ID
    */
    private String cardid;
    /**
    * 卡券编号
    */
    private String cardno;
    /**
    * 卡券类型 0：普通券 3：朋友券 4：火车票售卖代金券 5：退改无忧理赔代金券 6代金券红包
    */
    private Integer cardtype;
    /**
    * 会员id
    */
    private String memberid;
    /**
    * 状态 0-初始状态 1-已占用；2-已核销；30-占用失败 31-核销失败
    */
    private Integer usestatus;
    /**
    * 卡券消费失败原因
    */
    private String reason;
    /**
    * 占用时间
    */
    private Date occupytime;
    /**
    * 核销时间
    */
    private Date writeofftime;
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

    public String getTriporderno() {
        return triporderno;
    }

    public void setTriporderno(String triporderno) {
        this.triporderno = triporderno;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public Integer getCardtype() {
        return cardtype;
    }

    public void setCardtype(Integer cardtype) {
        this.cardtype = cardtype;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public Integer getUsestatus() {
        return usestatus;
    }

    public void setUsestatus(Integer usestatus) {
        this.usestatus = usestatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getOccupytime() {
        return occupytime;
    }

    public void setOccupytime(Date occupytime) {
        this.occupytime = occupytime;
    }

    public Date getWriteofftime() {
        return writeofftime;
    }

    public void setWriteofftime(Date writeofftime) {
        this.writeofftime = writeofftime;
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
