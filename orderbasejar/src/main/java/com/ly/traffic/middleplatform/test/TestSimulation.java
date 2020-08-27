package com.ly.traffic.middleplatform.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ly.traffic.middleplatform.utils.http.HttpFactory;
import com.ly.traffic.middleplatform.utils.http.config.RequestContext;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author liugw
 * @Package com.ly.traffic.train.infrastructure
 * @Description: ${TODO}
 * @date 2020/7/9 10:21
 */
public interface TestSimulation {

    static void payCallBackTest(Map<String, Object> map) {

//        HttpUill.post(url, data)

        RequestContext requestContext = new RequestContext("http://localhost:8096/order/paidcallback");
        requestContext.setRequestBody(JSON.toJSONString(map));
        CompletableFuture<String> result = HttpFactory.httpAsyncClientFactory.post(requestContext);
        result.whenComplete((r,e) -> {
            System.out.println("结果：" + r);
            if (e != null) {
                e.printStackTrace();
            }
        });
//        return null;
    }

    static void cancelOrderTest(Map<String, Object> map) {

//        HttpUill.post(url, data)

        RequestContext requestContext = new RequestContext("http://localhost:8096/order/cancel");
        requestContext.setRequestBody(JSON.toJSONString(map));
        CompletableFuture<String> result = HttpFactory.httpAsyncClientFactory.post(requestContext);
        result.whenComplete((r,e) -> {
            System.out.println("结果：" + r);
            if (e != null) {
                e.printStackTrace();
            }
        });
//        return null;
    }

    static void sendData(String data) throws UnsupportedEncodingException {

//        HttpUill.post(url, data)
        String encodeData = URLEncoder.encode(data, "utf-8");
        RequestContext requestContext = new RequestContext("http://localhost:8096/order/consumeData?data="+encodeData);
//        requestContext.setRequestBody(JSON.toJSONString(map));
        CompletableFuture<String> result = HttpFactory.httpAsyncClientFactory.get(requestContext);
        result.whenComplete((r,e) -> {
            System.out.println("结果：" + r);
            if (e != null) {
                e.printStackTrace();
            }
        });
//        return null;
    }
}
