package com.lkh.mqclient.config.consumer;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;

public class MQPushConsumer extends DefaultMQPushConsumer {
	public static Logger logger = LogManager.getLogger(MQPushConsumer.class);

	public MQPushConsumer(String groupName) {
		super(groupName);
	}
	
	public int biebb(String serverIp) {
		String ip = getServerIp();
		logger.info("---------------consumer group:{} copy biebb,ip:{}  serverIp:{} ", this.getConsumerGroup(), ip, serverIp);
		int result = 0;
		if (serverIp.equals(ip)) {
			result = 1;
			this.shutdown();
		}
		return result;
	}
	
	/**
	 * 获取服务器IP
	 * 
	 * @return ip
	 */
	private static String getServerIp() {
		try {
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			while (networkInterfaces.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) networkInterfaces.nextElement();
				Enumeration<InetAddress> nias = ni.getInetAddresses();
				while (nias.hasMoreElements()) {
					InetAddress ia = nias.nextElement();
					if (!ia.isLinkLocalAddress() && !ia.isLoopbackAddress() && ia instanceof Inet4Address) {
						return ia.getHostAddress();
					}
				}
			}
		} catch (Exception e) {
			logger.error("获取服务器IP失败", e);
		}
		return null;
	}
}
