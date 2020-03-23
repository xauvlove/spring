package com.xauv.imitate.aop.annotation;

import com.xauv.imitate.aop.importSelector.XauvAopImportSelector;
import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

/**
 * 在 spring 初始化环境时
 * 将这个类扫描（在 AppConfig 中需要能扫到这个类）
 * 发现这个类存在 @Import(XauvAopImportSelector.class)
 * 将 XauvAopImportSelector 导入到 spring 容器
 * 	XauvAopImportSelector 存在我们定义的 MyAopPostProcessor implements BeanPostProcessor
 * 	在 bean 初始化的时候进行 bean 改造
 * 	在这个时候，用 代理来代理这个 bean， 代理存储到 bean instances 中
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(XauvAopImportSelector.class)
public @interface EnableXauvAop {
}
