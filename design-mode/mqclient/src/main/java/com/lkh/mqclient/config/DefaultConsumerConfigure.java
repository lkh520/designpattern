package com.lkh.mqclient.config;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.lkh.mqclient.config.consumer.MQPushConsumer;
import com.lkh.mqclient.util.ApplicationContextUtil;
import com.lkh.mqclient.util.MessageConst;

@Configuration
public abstract class DefaultConsumerConfigure {
	private static final Logger log = LogManager.getLogger(DefaultConsumerConfigure.class);
	@Autowired
	private ConsumerConfig consumerConfig;

	// 开启消费者监听服务
	public void listener(String topic, String tag, String groupName, String instanceName) throws MQClientException {
		log.info("开启[topic={},tag={}]消费者-------------------", topic, tag);
		log.info(consumerConfig.toString());
		MQPushConsumer consumer = new MQPushConsumer(groupName);
		consumer.setNamesrvAddr(consumerConfig.getNamesrvAddr());
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
		consumer.setConsumeThreadMin(consumerConfig.getConsumeThreadMin());
		consumer.setConsumeThreadMax(consumerConfig.getConsumeThreadMax());
		// 开启内部类实现监听
		consumer.registerMessageListener(new MessageListenerConcurrently() {
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				log.info("payconfig-开始消费网关消息");
				String errorInfo = null;
				for (MessageExt messageExt : msgs) {
					log.info("payconfig-消息内容{}:", new String(messageExt.getBody()));
					try {
						long startTime = System.currentTimeMillis();
						JSONObject jsonObject = JSONObject.parseObject(new String(messageExt.getBody()));
						DefaultConsumerConfigure configure = ApplicationContextUtil.getBeanByClass(instanceName, DefaultConsumerConfigure.class);
						configure.processBusiness(jsonObject);
						// DefaultConsumerConfigure.this.processBusiness(jsonObject);
						log.info("收到网关消息，消费处理完成 耗时{}", System.currentTimeMillis() - startTime);
					} catch (Throwable e) { // 记录报错信息
						errorInfo = e.getMessage();
						log.error("Key为 {} 的消息处理失败：{}", messageExt.getKeys(), errorInfo, e);
					}
					// 错误信息不为空
					if (!StringUtils.isEmpty(errorInfo)) {
						// 记录错误信息
						log.error("消费消息处理失败：errorInfo={},key={}, topic={}, tag={},body={}", errorInfo,
								messageExt.getKeys(), messageExt.getTopic(), messageExt.getTags(),
								new String(messageExt.getBody()));
					}
				}
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		consumer.setInstanceName(instanceName);
		consumer.subscribe(topic, tag);
		MessageConst.CONSUMBER_MAP.put(instanceName, consumer);
	}

	// 处理body的业务
	public abstract void processBusiness(JSONObject jsonObject);
}
