package com.xauv.springframework.context.imitate.mybatis.factoryBean;/*
package com.xauv.springframework.context.imitate.mybatis.factoryBean;

import com.xauv.springframework.context.imitate.mybatis.invocationHandler.MybatisInvocationHandler;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

*/
/**
 * 模仿 mybatis
 * 动态地添加 BeanDefinition 到 容器
 * 这个类是 bean 进行实例化时所需要的通用类
 * 这个类不要加 @Component 否则会报错，因为它有 有参构造方法
 *//*

public class MyDaoFactoryBean implements FactoryBean {

	private Class clazz;

	public MyDaoFactoryBean(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object getObject() throws Exception {
		return Proxy.newProxyInstance(this.getClass().getClassLoader(),
				new Class[]{clazz}, new MybatisInvocationHandler());
	}

	@Override
	public Class<?> getObjectType() {
		return clazz;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
*/
