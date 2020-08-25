package com.ly.traffic.middleplatform.infrastructure.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * ID : 模块名_IP地址_时间戳_线程_随机数
 * @author gaowei.liu
 */
public class EventIdGenerator {

    public static String nextId(String prefix){
        String ipAndPortStr = ServiceInfoUtil.getIPAndPortStr();
        long threadId = Thread.currentThread().getId();
        long nanoTime = System.nanoTime();
        String random = RandomStringUtils.randomNumeric(3);
        String id = ipAndPortStr + "_" + threadId + "_" + nanoTime + "_" + random;
        if (StringUtils.isNotBlank(prefix)) {
            id = prefix + "_" + id;
        }
        return id;
    }

    public static String nextId(){
        return nextId(StringUtils.EMPTY);
    }

    public static void main(String[] args) {
        String s = RandomStringUtils.randomNumeric(3);
        System.out.println(nextId());
    }
}
