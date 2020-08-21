/**
 * Copyright © 2019 同程艺龙 (zhihui.li@ly.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ly.traffic.middleplatform.utils.http.factory.okhttp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.ly.traffic.middleplatform.utils.http.HttpFactory;
import com.ly.traffic.middleplatform.utils.http.config.RequestContext;
import org.junit.AfterClass;
import org.junit.Test;
import com.alibaba.fastjson.JSONObject;

/**
 * @author leeyazhou
 */
public class OKHttpFactoryTest {
  private String baseUrl = "http://10.100.216.147:12051/flowerdsfasync/";

  // private String baseUrl = "http://127.0.0.1:12051/flowerdsfasync/";

  @Test
  public void testGetOrderInfo() {
//    Map<String, String> map = new HashMap<>();
//    map.put("id", "23");
    RequestContext requestContext = new RequestContext("http://localhost:8096/order/selectOne?id=23");

//    requestContext.setParameters(map);
    CompletableFuture<String> result = HttpFactory.okHttpFactory.get(requestContext);

    /*RequestContext requestContext = new RequestContext("http://localhost:8096/order/selectOne2");
    JSONObject body = new JSONObject();
    body.put("id", 23);
    System.out.println(body.toJSONString());
    requestContext.setRequestBody(body.toJSONString());
    CompletableFuture<String> result = HttpFactory.httpAsyncClientFactory.post(requestContext);*/

    result.whenComplete((r,e) -> {
      System.out.println("结果：" + r);
      if (e != null) {
        e.printStackTrace();
      }
    });
  }

  @Test
  public void testGet() {
    RequestContext requestContext = new RequestContext(baseUrl + "demo/get");
    CompletableFuture<String> result = HttpFactory.okHttpFactory.get(requestContext);
    result.whenComplete((r, e) -> {
      System.out.println("结果：" + r);
      if (e != null) {
        e.printStackTrace();
      }
    });
  }

  @Test
  public void tesPost() {
    RequestContext requestContext = new RequestContext(baseUrl + "demo/post");
    setRequestBody(requestContext);
    CompletableFuture<String> result = HttpFactory.okHttpFactory.post(requestContext);
    result.whenComplete((r, e) -> {
      System.out.println("结果：" + r);
      if (e != null) {
        e.printStackTrace();
      }
    });
  }

  @Test
  public void tesPut() {
    RequestContext requestContext = new RequestContext(baseUrl + "demo/put");
    setRequestBody(requestContext);
    CompletableFuture<String> result = HttpFactory.okHttpFactory.put(requestContext);
    result.whenComplete((r, e) -> {
      System.out.println("结果：" + r);
      if (e != null) {
        e.printStackTrace();
      }
    });
  }

  private void setRequestBody(RequestContext requestContext) {
    JSONObject body = new JSONObject();
    body.put("name", "liyazhou");
    body.put("age", 201);

    requestContext.setRequestBody(body.toJSONString());
  }

  @Test
  public void testDelete() {
    RequestContext requestContext = new RequestContext(baseUrl + "demo/delete");
    setRequestBody(requestContext);
    CompletableFuture<String> result = HttpFactory.okHttpFactory.delete(requestContext);
    result.whenComplete((r, e) -> {
      System.out.println("结果：" + r);
      if (e != null) {
        e.printStackTrace();
      }
    });
  }

  @Test
  public void testPatch() {
    RequestContext requestContext = new RequestContext(baseUrl + "demo/patch");
    setRequestBody(requestContext);
    CompletableFuture<String> result = HttpFactory.okHttpFactory.patch(requestContext);
    result.whenComplete((r, e) -> {
      System.out.println("结果：" + r);
      if (e != null) {
        e.printStackTrace();
      }
    });
  }

  @AfterClass
  public static void afterClass() throws InterruptedException {
    Thread.sleep(1000);
  }
}
