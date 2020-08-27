package com.ly.traffic.middleplatform.domain.createorder.repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import com.ly.traffic.middleplatform.utils.http.HttpFactory;
import com.ly.traffic.middleplatform.utils.http.config.RequestContext;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author liugw
 * @Package com.ly.traffic.train.infrastructure
 * @Description: ${TODO}
 * @date 2020/7/9 10:21
 */
public interface IUnionOrderRepository<T,R> {
    R save(T orderEntity);

    default String getByOrderNo(String orderNo) {
        RequestContext requestContext = new RequestContext("http://localhost:8096/order/selectOne?orderNo=" + orderNo);
//        JSONObject body = new JSONObject();
//        body.put("id", id);
//        System.out.println(body.toJSONString());
//        requestContext.setRequestBody(body.toJSONString());
        CompletableFuture<String> result = HttpFactory.httpAsyncClientFactory.get(requestContext);
//        result.whenComplete((r,e) -> {
//            System.out.println("结果：" + r);
//
//            if (e != null) {
//                e.printStackTrace();
//            }
//        });
        try {
            String s = result.get(10, TimeUnit.SECONDS);
            if (StringUtils.isEmpty(s)) {
                return s;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("data");
            JSONObject extendcontent = jsonObject.getJSONObject("extendContent");
            Set<String> keySet = extendcontent.keySet();
            for (String key : keySet) {
                jsonObject.put(key, extendcontent.get(key));
            }
            jsonObject.remove("extendContent");
//            System.out.println("s=" + s);
//            System.out.println("toJsonStr:" + JSON.toJSONString(jsonObject));
            return JSON.toJSONString(jsonObject);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
