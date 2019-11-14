package com.lkh.mqclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 读取配置类
 * 将配置文件的内容读取后, 在容器启动时加载, 未做到更动加载, 如需更动加载, 就要引入REDIS, 做同步刷新即可 
 * @author lkh
 */
@Configuration
public class ConsumerConfig {
	/**************** 通用配置 *****************/
	@Value("${rocketmq.consumer.payCenter.namesrvAddr}")
	private String namesrvAddr;
	@Value("${rocketmq.consumer.consumeThreadMin}")
	private int consumeThreadMin;
	@Value("${rocketmq.consumer.consumeThreadMax}")
	private int consumeThreadMax;



	/**
	 * @return the namesrvAddr
	 */
	public String getNamesrvAddr() {
		return namesrvAddr;
	}

	/**
	 * @param namesrvAddr the namesrvAddr to set
	 */
	public void setNamesrvAddr(String namesrvAddr) {
		this.namesrvAddr = namesrvAddr;
	}

	/**
	 * @return the consumeThreadMin
	 */
	public int getConsumeThreadMin() {
		return consumeThreadMin;
	}

	/**
	 * @param consumeThreadMin the consumeThreadMin to set
	 */
	public void setConsumeThreadMin(int consumeThreadMin) {
		this.consumeThreadMin = consumeThreadMin;
	}

	/**
	 * @return the consumeThreadMax
	 */
	public int getConsumeThreadMax() {
		return consumeThreadMax;
	}

	/**
	 * @param consumeThreadMax the consumeThreadMax to set
	 */
	public void setConsumeThreadMax(int consumeThreadMax) {
		this.consumeThreadMax = consumeThreadMax;
	}

	
}
