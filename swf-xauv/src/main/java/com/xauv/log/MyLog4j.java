package com.xauv.log;

import org.apache.log4j.Logger;

public class MyLog4j {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("MyLog4j");
		logger.info("MyLog4j");
	}
}
