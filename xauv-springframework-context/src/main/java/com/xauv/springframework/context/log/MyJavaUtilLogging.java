package com.xauv.springframework.context.log;

import java.util.logging.Logger;

public class MyJavaUtilLogging {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("MyJUL");
		logger.info("MyJUL");
	}
}
