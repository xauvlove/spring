package com.xauv.imitate.mvc;


import com.xauv.imitate.mvc.config.AppConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class XauvSpringApplication {
	public static void run(String[] args) {

		//初始化 spring web 环境
		AnnotationConfigWebApplicationContext springContext =
				new AnnotationConfigWebApplicationContext();
		springContext.register(AppConfig.class);
		springContext.refresh();

		//web 项目都是围绕 DispatcherServlet 而来
		//DispatcherServlet 可以存入到一个 WebApplicationContext 容器中
		DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);

		//新建 tomcat
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(9090);

		/**
		 * tomcat.addWebapp() 表示这是一个 web 项目
		 * contextPath 是 tomcat 的访问路径
		 * docBase 是 项目的 web 目录，访问 tomcat 的时候，会自动寻找 D:/app/index.html
		 * 现在已经废弃
		 *
		 * 如果调用 tomcat.addWebapp()，tomcat 认为这是 web 项目
		 * 调用 servlet3.0 spi 拓展机制
		 * 会自动做一些 web 相关的初始化工作
		 * 因为如果是 web 项目，那么就需要解析 jsp (解析 jsp 为 servlet)
		 * 因此，tomcat 会加载一些解析 jsp 的类，
		 * 	这些类存在于 jasper 包依赖下
		 * 	我们可能并没有引入这个依赖，因此可能会产生异常
		 *
		 */
		//tomcat.addWebapp("/", "D:/app");
		/**
		 * 设置工作目录
		 */
		File file = new File("src/main/resources");
		Context tomcatRootContext = tomcat.addContext("/", file.getAbsolutePath());
		//给 tomcat 增加 DispatcherServlet
		Tomcat.addServlet(tomcatRootContext, "xauvDispatcherServlet",
				dispatcherServlet).setLoadOnStartup(1);
		tomcatRootContext.addServletMapping("/", "xauv");
		try {
			tomcat.start();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
		tomcat.getServer().await();
	}
}
