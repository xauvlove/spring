package com.xauv.test;

import com.xauv.config.AppConfigForAnnotation;
import com.xauv.dao.MyDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 初始化 spring 环境的三种方法
 * 1. xml, {@link ClassPathXmlApplicationContext}
 * 2. annotation, {需要借助 1或3 完成包扫描}:
 * 	               具体做法：context.scan("com.xauv");
 * 3. java config, {@link AnnotationConfigApplicationContext}
 */
public class SpringApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("javaConfig");
		// 注册 {@link Configuration 类型}
		context.register(AppConfigForAnnotation.class);
		context.refresh();
		MyDao myDaoImpl = (MyDao)context.getBean("myDaoImpl");
		myDaoImpl.doDao();
		//System.out.println(context.getBean("mybatisDao"));
		/*Object mybatisDao = context.getBean("mybatisDao");
		System.out.println(mybatisDao);*/

	}
}
