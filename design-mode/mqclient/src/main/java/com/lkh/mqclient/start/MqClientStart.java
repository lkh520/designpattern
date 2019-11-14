package com.lkh.mqclient.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.lkh.mqclient.config.listener.ApplicationStartupListener;

@SpringBootApplication
@ComponentScan(basePackages = "com.lkh.*")
public class MqClientStart {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(MqClientStart.class);
		springApplication.addListeners(new ApplicationStartupListener());// 添加上下文初始化监听
		springApplication.run(args);
    }
}
