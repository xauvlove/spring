/*
package com.xauv.imitate.mybatis.ibdr;

import com.xauv.imitate.mybatis.dao.MybatisDao;
import com.xauv.imitate.mybatis.factoryBean.MyDaoFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

//这个类是 mybatis 将接口(MybatisDao) 转换为 BeanDefinition 的核心类
//利用了 FactoryBean 的 getObject() 特性
//我们在使用 context.getBean("mybatisDao") 的时候，FactoryBean 会调用 getObject() 返回对象给我们
//因此 我们只需要将 getObject() 重写即可拿到我们想要的对象
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
