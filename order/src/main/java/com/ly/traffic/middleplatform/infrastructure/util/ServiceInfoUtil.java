package com.ly.traffic.middleplatform.infrastructure.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.net.*;
import java.util.Enumeration;

/**
 * @author gaowei.liu
 */
@Component
public class ServiceInfoUtil implements ApplicationListener<WebServerInitializedEvent> {
    private static Logger logger = LoggerFactory.getLogger(ServiceInfoUtil.class);
    public static int port;
    public static String hostIp;

//    private static WebServerInitializedEvent event;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
//        ServiceInfoUtil.event = event;
        port = event.getWebServer().getPort();
        hostIp = getLocalHostIp();
        String ipPort = hostIp + ":" + port;
        String servPath = getServerPath();
        logger.info("ipPort={}, servpath={}", ipPort, servPath);
    }

    public static String getIPAndPortStr() {
        return "" + getLocalHostIp() + ":" + port;
    }

    public static int getPort() {
        return port;
    }

    public static String getServerPath() {
        try {
            return ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            logger.error("getServerPath error:" + e.getMessage());
        }
        return StringUtils.EMPTY;
    }

    public static String getLocalHostIp() {
        if (StringUtils.isNotEmpty(hostIp)) {
            return hostIp;
        }

        Enumeration allNetInterfaces = null;
        String host = "Unknow Host";
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface)allNetInterfaces.nextElement();
                logger.info("netInterface:<{}>", JSON.toJSONString(netInterface));
                String displayName = netInterface.getDisplayName();
                if ((displayName.length() >= 6 && "docker".equalsIgnoreCase(displayName.substring(0, 6)))
                    || netInterface.isVirtual() || netInterface.isLoopback()) {
                    continue;
                }

                Enumeration addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = (InetAddress)addresses.nextElement();
                    if (ip instanceof Inet4Address) {
                        String hostIp = ip.getHostAddress() == null ? "" : ip.getHostAddress().trim();
                        System.out.println("hostIp=" + hostIp);
                        if ("127.0.0.1".equalsIgnoreCase(hostIp)) {
                            continue;
                        }
                        host = ip.getHostAddress() == null ? "" : ip.getHostAddress().trim();
                        logger.info("找到的ip:<{}>, addresses:<{}>, netInterface:<{}>", JSON.toJSONString(ip),
                            JSON.toJSONString(addresses), JSON.toJSONString(netInterface));
                        System.out.println("本机的ip=" + host);
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return host;
    }


}
