package com.xauv.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import java.util.Iterator;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	/**
	 * bean factory ���ô���������� bean �� ��ServiceImpl�� ��β����ô��������Ϊԭ��
	 * @param beanFactory the bean factory used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();
		beanNamesIterator.forEachRemaining(data -> {
			if(data.endsWith("ServiceImpl")) {
				BeanDefinition myServiceImpl = beanFactory.getBeanDefinition(data);
				myServiceImpl.setScope("prototype");
			}
		});
	}
}
