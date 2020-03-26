package com.xauv.springframework.context.imitate.mybatis.invocationHandler;/*
package com.xauv.springframework.context.imitate.mybatis.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MybatisInvocationHandler implements InvocationHandler {

	//这里可以获取 sql 语句
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//保证执行安全
		Method[] declaredMethods = proxy.getClass().getInterfaces()[0].getDeclaredMethods();
		List<String> methodNameList = Arrays.stream(declaredMethods)
				.map(Method::getName).collect(Collectors.toList());
		if(!methodNameList.contains(method.getName())) {
			return null;
		}
		Method mapperMethod = proxy.getClass().getInterfaces()[0].getDeclaredMethod(method.getName());
		Select select = mapperMethod.getDeclaredAnnotation(Select.class);
		System.out.println(select.value());
		return null;
	}
}
*/
