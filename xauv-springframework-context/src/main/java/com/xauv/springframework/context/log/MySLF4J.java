package com.xauv.springframework.context.log;

/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

*/
/**
 * slf4j 需要借助其它日志工具进行日志记录
 * 	因此需要进行日志工具的绑定
 *
 * slf4j的日志绑定：
 * 	slf4j 需要设置一个绑定器，与其它日志工具进行绑定
 * 	 slf4j 的核心包：compile("org.slf4j:slf4j-api:1.7.25")
 *
 * 	与 jul 绑定：compile("org.slf4j:slf4j-jdk14:1.7.25")
 *
 * 	与 log4j 绑定：compile("org.slf4j:slf4j-log4j12:1.7.25")，
 * 	 这个依赖中存在一个 log4j，因此不需要我们手动导入 log4j 依赖
 * 	 这个 log4j 是 slf4j 内置的，而且是重写了原来的 log4j，因此版本不明
 *
 *	与 jcl 绑定：compile("org.slf4j:slf4j-jcl:1.7.25")，
 * 	 绑定到 commons-logging，而 commons-logging 又会去寻找其它日志工具
 * 	 这样的话 slf4j 就成了 commons-logging 工作机制
 *
 * ----------------------------------------------------------------------
 *
 * slf4j 的日志桥接：
 * 	如果项目中存在多个日志工具，如果需要进行日志的统一（统一到 slf4j 进行管理），那么就需要进行日志桥接
 * 	 将 jcl 桥接到 slf4j：compile("org.slf4j:jcl-over-slf4j:1.7.25")
 * 	 ...
 *
 *//*

public class MySLF4J {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("MySLF4J");
		logger.info("MySLF4J");
	}
}
*/
