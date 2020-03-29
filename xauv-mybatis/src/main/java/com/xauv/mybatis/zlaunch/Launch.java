package com.xauv.mybatis.zlaunch;

import com.xauv.mybatis.config.AppConfig;
import com.xauv.mybatis.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launch {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.register(AppConfig.class);
		context.refresh();

		UserService userService = (UserService) context.getBean("userService");
		userService.queryAllUser().forEach(System.out::println);
	}
}
