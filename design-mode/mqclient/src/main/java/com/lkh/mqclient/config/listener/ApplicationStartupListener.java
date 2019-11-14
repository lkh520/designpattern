package com.lkh.mqclient.config.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.lkh.mqclient.config.consumer.MQPushConsumer;
import com.lkh.mqclient.util.MessageConst;

/**
 * @program: com.billing.listener
 * @description:
 * @Creator: aJie
 * @CreateTime: 2019-06-17 14:59
 * @LastEditTime 2019-06-17 14:59
 */
public class ApplicationStartupListener implements ApplicationListener<ApplicationReadyEvent> {
	private static final Logger logger = LogManager.getLogger(ApplicationStartupListener.class);
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		//获取所有消费者监听
		Map<String, MQPushConsumer> consumers = MessageConst.CONSUMBER_MAP;
		Set<String> consumerKeys = consumers.keySet();
		for (String key : consumerKeys) {
			logger.info("ApplicationStartupListener onApplicationEvent {}", key);
			try {
				consumers.get(key).start();
			} catch (MQClientException e) {
				logger.error("ApplicationStartupListener onApplicationEvent fail. e:{}", e);
			}
		}
	}
}
