package com.ly.traffic.middleplatform.utils.http.factory.okhttp;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.utils.http.factory.okhttp
 * @Description: ${TODO}
 * @date 2020/8/18 14:26
 */
public class ProxyTest {
    public static void main(String[] args) throws ClientProtocolException, IOException {
//        System.setProperty("http.agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //代理对象
//        HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");
        HttpHost proxy = new HttpHost("175.42.68.169", 9999, "http");

        //配置对象
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
//        RequestConfig config = RequestConfig.custom().build();
        //创建请求方法的实例， 并指定请求url
        HttpGet httpget=new HttpGet("http://www.qq.com");
        //使用配置
        httpget.setConfig(config);
//        Header header = new BasicHeader("User-Agent",
//                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
//        httpget.addHeader(header);
        CloseableHttpResponse response=httpClient.execute(httpget);
        HttpEntity entity=response.getEntity();
        String content=EntityUtils.toString(entity, "utf-8");
        System.out.println(content);
        httpClient.close();
    }
}
