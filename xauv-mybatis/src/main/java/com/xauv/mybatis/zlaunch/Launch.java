package com.xauv.mybatis.zlaunch;

import com.xauv.mybatis.config.AppConfig;
import com.xauv.mybatis.pojo.User;
import com.xauv.mybatis.service.UserService;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 如果要打印 mybatis 执行 sql 的 sql 语句，
 * 1.只需要在 mybatis 运行前调用 org.apache.ibatis.logging.LogFactory.useSlf4jLogging();
 * 	{@link LogFactory#useSlf4jLogging()}
 *
 * 2.对 SqlSessionFactory 设置 Configuration 属性，设置 log 的方式
 * 	{@link Configuration#setLogImpl(java.lang.Class)}
 * 	{@link SqlSessionFactoryBean#setConfiguration(org.apache.ibatis.session.Configuration)}
 *
 * 	需要注意的是，如果我们仅仅使用 mybatis + log4j/slf4j，是可以打印日志的
 * 	但，如果我们将 mybatis 和 spring 进行了整合，那么就无法打印日志了
 *
 * 	因为 mybatis 里面的 log 系统和 jcl 的结构是差不多的，
 * 		先寻找是否存在 slf4j
 * 			 是否存在 jcl
 * 		     是否存在 log4j2
 * 		     是否存在 log4j
 * 		        使用 jul
 *  因此，由于 spring5 内部重写了 jcl，因此 mybatis 会实例化出 spring5 的 jcl，从而采用 spring5 中的 jcl 作为日志工具
 *  spring5 的 jcl 默认采用 jul 作为日志工具（
 *  	这是因为 spring5 废除了 log4j，采用新一代的 log4j2，所以我们在项目如果引入 log4j，spring5 根本就无法识别，
 *  	如果我们加入 log4j2 依赖，那么 spring5 就会使用 log4j2，而不是 jul 了）
 *  这样一来，mybatis 也会使用 jul 作为日志工具，由于 （ mybatis 会实例化出 spring5 的 jcl）
 *  但是，jul 的日志级别高，jul 只会打印 INFO <以上>的级别，但，spring 和 mybatis 整合后，输入的日志所需级别是 INFO down
 *
 *	如果我们可以修改 jul 的日志级别，那么就可以实现打印，但 jul 是已经写死的，无法修改，解决办法就是 扩展 jul
 *
 *
 *
 */
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
