package com.xauv.springframework.context.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Commons-Logging 是借助其它 Logger 打印的，本身不记录日志
 *
 * 如果 log4j 依赖存在，那么借助 log4j
 * 需要给出 log4j.properties
 * 依赖于 log4j
 *
 * 如果不指定或者我们不引入 Log4j，Commons-Logging 就会借助 java.util.logging 进行日志记录
 *
 * Log log = LogFactory.getLog("MyCommonsLogging"); 是通过 LogFactory 获取
 *		LogFactory 获取 logger 的时候有一个获取顺序，A B C D
 *		如果 A 不存在，那么就会找 B C D
 *
 */
/*
public class MyCommonsLogging {
	public static void main(String[] args) {
		Log log = LogFactory.getLog("MyCommonsLogging");
		log.info("MyCommonsLogging");
	}
}
*/
