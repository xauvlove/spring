/*
package com.xauv.imitate.mybatis.ibdr;

import com.xauv.imitate.mybatis.dao.MybatisDao;
import com.xauv.imitate.mybatis.factoryBean.MyDaoFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MybatisImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
										BeanDefinitionRegistry registry) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MybatisDao.class);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)builder.getBeanDefinition();
		//给 beanDefinition 添加构造方法
		beanDefinition.getConstructorArgumentValues()
				.addGenericArgumentValue("com.xauv.imitate.mybatis.dao.MybatisDao");
		//给 beanDefinition 设置实例化的类
		beanDefinition.setBeanClass(MyDaoFactoryBean.class);
		registry.registerBeanDefinition("mybatisDao", beanDefinition);
	}
}
*/
