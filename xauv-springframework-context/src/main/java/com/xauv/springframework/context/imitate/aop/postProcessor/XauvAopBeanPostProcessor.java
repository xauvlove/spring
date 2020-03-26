package com.xauv.springframework.context.imitate.aop.postProcessor;

import com.xauv.springframework.context.imitate.aop.proxyHandler.MyInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import java.lang.reflect.Proxy;

public class XauvAopBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {
	/**
	 * 这里，我们很容易来插手 bean 的初始化
	 * 可以使用代理
	 *
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		/*if(beanName.startsWith("xauv") && bean.getClass().isInterface()) {
			return Proxy.newProxyInstance(this.getClass().getClassLoader(),
					bean.getClass().getInterfaces(), new MyInvocationHandler(bean));
		}
		return bean;*/
		if(beanName.startsWith("xauv")) {
			return Proxy.newProxyInstance(this.getClass().getClassLoader(),
					bean.getClass().getInterfaces(), new MyInvocationHandler(bean));
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		/*if(beanName.startsWith("my")) {
		}*/
		return bean;
	}

	/**
	 *
	 * @return 值越大，执行优先级越低
	 */
	@Override
	public int getOrder() {
		return 200;
	}
}
