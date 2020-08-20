package com.ly.traffic.middleplatform.orderdbtest;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.ly.traffic.middleplatform.domain.createorder.repository.mapper.MainOrderMapper;
import com.ly.traffic.middleplatform.domain.createorder.repository.po.MainOrderPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.orderdbtest
 * @Description: ${TODO}
 * @date 2020/8/20 14:49
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MainOrderTest {
    @Resource
    private MainOrderMapper mainOrderDao;

    @Test
    public void testCreateOrder() {
        MainOrderPO mainOrder = new MainOrderPO();
        mainOrder.setOrderNo("M00000001");
        mainOrder.setPlatId(3);
        mainOrder.setSourceType(2);
        mainOrder.setMemberId(10);
        mainOrder.setSupplierOrderNo("");
        mainOrder.setCheckStatus(0);
        mainOrder.setOrderStatus(0);
        mainOrder.setMailStatus(1);
        mainOrder.setPayStatus(0);
        mainOrder.setContactName("张三");
        mainOrder.setContactPhone("13466534267");
        mainOrder.setContactEmail("");
        mainOrder.setCustomerTotalAmount(90.0D);
        mainOrder.setCustomerTotalPaid(0.0D);
        mainOrder.setTicketTotalPrice(90.0D);
        mainOrder.setReduceAmount(0.0D);
        mainOrder.setDiscountAmount(0.0D);
        mainOrder.setBookFlag(0);
        mainOrder.setIssueFlag(0);
        mainOrder.setPayMode(0);
        mainOrder.setValidPayTime(new Date());
        mainOrder.setPaymentType(0);
        mainOrder.setUnionPay(0);
        mainOrder.setDirectPay(0);
        mainOrder.setProductType(0);
        mainOrder.setWithHoldStatus(0);
        mainOrder.setWithHoldFailReason("");
        mainOrder.setRefId(0);
        mainOrder.setUnionId("");
        mainOrder.setOpenId("");
        mainOrder.setExtendContent("");
        mainOrder.setUserCreateDate(new Date());
        mainOrder.setCreateDate(new Date());
        mainOrder.setCreateUser("");
        mainOrder.setUpdateDate(new Date());
        mainOrder.setUpdateUser("");

        mainOrderDao.insert(mainOrder);

        System.out.println("ori:"+JSON.toJSONString(mainOrder));
        System.out.println(mainOrder.toString());

    }
}
