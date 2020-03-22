/*
package com.xauv.imitate.mybatis.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MybatisInvocationHandler implements InvocationHandler {
	Object target;

	public MybatisInvocationHandler() {

	}

	public MybatisInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(target == null) {
			System.out.println("target is null");
			return null;
		}
		return method.invoke(target, args);
	}
}
*/
