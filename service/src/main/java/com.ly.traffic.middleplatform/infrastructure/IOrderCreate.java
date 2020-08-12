package com.ly.traffic.train.infrastructure;

import com.alibaba.fastjson.JSON;
import com.sun.net.httpserver.Authenticator;

/**
 * @author liugw
 * @Package com.ly.traffic.train.infrastructure
 * @Description: ${TODO}
 * @date 2020/7/9 10:21
 */
public interface IOrderCreate {
    default Authenticator.Result create() {
        System.out.println("create: " + JSON.toJSONString(this));
        return null;
    }
}
