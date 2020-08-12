package com.ly.traffic.middleplatform.domain.order.repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ly.traffic.middleplatform.utils.http.HttpFactory;
import com.ly.traffic.middleplatform.utils.http.config.RequestContext;
import com.sun.net.httpserver.Authenticator;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author liugw
 * @Package com.ly.traffic.train.infrastructure
 * @Description: ${TODO}
 * @date 2020/7/9 10:21
 */
public interface IOrderRepository {
    default void save() {
        save(this);
//        return null;
    }

    default String getById(Long id) {
        RequestContext requestContext = new RequestContext("http://localhost:8096/order/selectOne2");
        JSONObject body = new JSONObject();
        body.put("id", id);
//        System.out.println(body.toJSONString());
        requestContext.setRequestBody(body.toJSONString());
        CompletableFuture<String> result = HttpFactory.httpAsyncClientFactory.post(requestContext);
//        result.whenComplete((r,e) -> {
//            System.out.println("结果：" + r);
//
//            if (e != null) {
//                e.printStackTrace();
//            }
//        });
        try {
            String s = result.get();
            if (StringUtils.isEmpty(s)) {
                return s;
            }
            JSONObject jsonObject = JSONObject.parseObject(s);
            JSONObject extendcontent = jsonObject.getJSONObject("extendcontent");
            Set<String> keySet = extendcontent.keySet();
            for (String key : keySet) {
                jsonObject.put(key, extendcontent.get(key));
            }
            jsonObject.remove("extendcontent");
//            System.out.println("s=" + s);
//            System.out.println("toJsonStr:" + JSON.toJSONString(jsonObject));
            return JSON.toJSONString(jsonObject);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "";
    }


    static void save(Object obj) {
        String data = obj.toString();
        System.out.println("create: " + data);

//        HttpUill.post(url, data)

        RequestContext requestContext = new RequestContext("http://localhost:8096/order/save");
        requestContext.setRequestBody(data);
        CompletableFuture<String> result = HttpFactory.httpAsyncClientFactory.post(requestContext);
        result.whenComplete((r,e) -> {
            System.out.println("结果：" + r);
            if (e != null) {
                e.printStackTrace();
            }
        });
//        return null;
    }
}
