package com.xauv.mybatis.log;

import org.apache.ibatis.logging.Log;
import java.util.logging.Logger;

/**
 * 对 jul 进行拓展，因为 jul 的日志级别高
 * 我们将 {@link XauvLogger#isDebugEnabled()}
 * 		 {@link XauvLogger#isTraceEnabled()}
 * 		 全都设置为永远返回，这样降低日志级别
 * 最后在外部给 mybatis 配置我们的这个日志扩展类即可
 */
public class XauvLogger implements Log {
	Logger logger =  Logger.getLogger("xauvLogger");
	@Override
	public boolean isDebugEnabled() {
		return true;
	}

	@Override
	public boolean isTraceEnabled() {
		return true;
	}

	@Override
	public void error(String s, Throwable e) {
		logger.info("xauv log error:" + s + e);
	}

	@Override
	public void error(String s) {
		logger.info("xauv log error:" + s);
	}

	@Override
	public void debug(String s) {
		logger.info("xauv log debug:" + s);
	}

	@Override
	public void trace(String s) {
		logger.info("xauv log trace:" + s);
	}

	@Override
	public void warn(String s) {
		logger.info("xauv log warn:" + s);
	}
}
