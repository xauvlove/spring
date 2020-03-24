package com.xauv.launch;

/**
 * BeanFactory：管理对 BeanDefinition 的修改，
 * 		无法对 BeanDefinition 这个粒度操作
 * 		可以对 BeanDefinition 里面的属性操作
 *
 *
 * Registry：管理对于 BeanDefinition 的注册，删除等
 * 		可以对 BeanDefinition 这个粒度操作
 * 		可以删除 BeanDefinition
 * 		可以注册新的 BeanDefinition
 *
 *
 * spring 的 5 个重要拓展点
 * 1.BeanFactoryProcessor
 * 	对 BeanFactory 进行改造，改造 BeanDefinition
 *
 * 2.BeanPostProcessor 与 @Import 结合
 * 	对 Bean 进行改造
 *
 * 3.ImportBeanDefinitionRegistrar 与 @Import 结合
 * 	对 Registry 进行改造，可以增删 BeanDefinition
 *
 * 4.ApplicationContextAware 在 BeanPostProcessor 前执行{具体在 doCreateBean() 执行}，
 * 		但在  BeanFactoryProcessor 后执行
 * 	对 ApplicationContext 进行改造
 *
 * 5.FactoryBean
 * 	对 Bean 进行替换，但无法改造 BeanDefinition
 */
public class Summary {
}
