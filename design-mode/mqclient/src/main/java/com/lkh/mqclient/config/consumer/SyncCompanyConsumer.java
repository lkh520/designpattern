package com.lkh.mqclient.config.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.lkh.mqclient.config.DefaultConsumerConfigure;

@Configuration
@Component("DefaultConsumerConfigure.SYNCCOMPANY")
public class SyncCompanyConsumer extends DefaultConsumerConfigure
		implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger log = LogManager.getLogger(SyncCompanyConsumer.class);

	@Value("${rocketmq.consumer.payCenter.synccompany.tag}")
	private String syncCompanyTag;
	@Value("${rocketmq.consumer.payCenter.topic}")
	private String topic;
	@Value("${exitapi.company}")
	private String companyCode;

	/************** groupName topic tag 配置 *************/
	@Value("${rocketmq.consumer.payCenter.synccompany.group}")
	private String groupName;
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		try {
			super.listener(topic, this.syncCompanyTag, this.groupName, "SYNCCOMPANY");
		} catch (MQClientException e) {
			log.error("消费者监听器启动失败", e);
		}

	}

	@Override
	public void processBusiness(JSONObject jsonObject) {
		log.info("公司消息数据：{}", jsonObject);
	}
}
