package com.xauv.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * slf4j 需要设置一个绑定器，与其它日志工具进行绑定
 * compile("org.slf4j:slf4j-api:1.7.25")
 *
 * compile("org.slf4j:slf4j-jdk14:1.7.25")
 *
 * compile("org.slf4j:slf4j-log4j12:1.7.25")，
 * 	这个依赖中存在 log4j，因此不需要我们手动导入 log4j 依赖
 *
 * compile("org.slf4j:slf4j-jcl:1.7.25")，
 * 	绑定到 commons-logging，而 commons-logging 又会去寻找其它日志工具
 * 	这样的话 slf4j 就成了 commons-logging 工作机制
 */
public class MySLF4J {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("MySLF4J");
		logger.info("MySLF4J");
	}
}
