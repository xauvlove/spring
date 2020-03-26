package com.xauv.springframework.context.config;

import com.xauv.springframework.context.imitate.aop.annotation.EnableXauvAop;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//扫包
@ComponentScan("com.xauv.springframework.context")
// 设置开发环境
@Profile("javaConfig")
/**
 * 导入动态添加 BeanDefinition 注册器
 * 由于此版本 spring 不支持，现会出现运行报错
 */
//@Import(MybatisImportBeanDefinitionRegistrar.class)
/**
 * 开启自己的 aop
 */
@EnableXauvAop
public class AppConfigForAnnotation {
}
