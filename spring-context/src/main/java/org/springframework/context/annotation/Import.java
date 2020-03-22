/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *   对于 @Import()：含义在于注册一个类作为 bean
 *   		可以写：1.@Import(Class),传入一个普通类(可以是 bean)
 *   			   2.@Import(ImportSelector)，
 *   			   3.@Import(ImportBeanDefinitionRegistrar)
 *
 * 	对于 1：传入普通类
 * 	对于 2：自己定义一个类，实现 ImportSelector 接口，重写方法 返回多个类路径（和 1 等同）
 * 	对于 3：
 *
 * 对于注册 bean：
 * 	1.register(Class),需要传入类
 * 	2.scan("com.xauv"),需要传入包路径
 * 	对于1，2 我们无法参与 Class 变成 BeanDefinition 的过程，3 可以解决
 * 	3.@Import(ImportBeanDefinitionRegistrar),我们可以直接往 beanDefinitionMap添加 beanDefinition
 *  Mybatis 中的 @MapperScan() 扫描 mapper<接口> 变成对象 存放在 spring 容器，就是使用 3 实现的
 *
 *  如果 @MapperScan() 扫描到 mapper 接口，需要将其变为对象，如何放到 spring 容器中是个问题
 *  因为 mybatis 在扫描 mapper 的时候，spring 环境已经初始完毕了，我们无论用什么方法都无法往 spring 容器的 BeanDefinitionMap 添加其元素
 *  3 可以，它可以在 spring 容器初始化完毕后 动态往 BeanDefinitionMap 添加 BeanDefinition
 *
 *
 *
 * Indicates one or more <em>component classes</em> to import &mdash; typically
 * {@link Configuration @Configuration} classes.
 *
 * <p>Provides functionality equivalent to the {@code <import/>} element in Spring XML.
 * Allows for importing {@code @Configuration} classes, {@link ImportSelector} and
 * {@link ImportBeanDefinitionRegistrar} implementations, as well as regular component
 * classes (as of 4.2; analogous to {@link AnnotationConfigApplicationContext#register}).
 *
 * <p>{@code @Bean} definitions declared in imported {@code @Configuration} classes should be
 * accessed by using {@link org.springframework.beans.factory.annotation.Autowired @Autowired}
 * injection. Either the bean itself can be autowired, or the configuration class instance
 * declaring the bean can be autowired. The latter approach allows for explicit, IDE-friendly
 * navigation between {@code @Configuration} class methods.
 *
 * <p>May be declared at the class level or as a meta-annotation.
 *
 * <p>If XML or other non-{@code @Configuration} bean definition resources need to be
 * imported, use the {@link ImportResource @ImportResource} annotation instead.
 *
 * @author Chris Beams
 * @author Juergen Hoeller
 * @since 3.0
 * @see Configuration
 * @see ImportSelector
 * @see ImportResource
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Import {

	/**
	 * {@link Configuration @Configuration}, {@link ImportSelector},
	 * {@link ImportBeanDefinitionRegistrar}, or regular component classes to import.
	 */
	Class<?>[] value();

}
