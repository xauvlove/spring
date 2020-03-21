package com.xauv.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//扫包
@ComponentScan("com.xauv")
// 设置开发环境
@Profile("javaConfig")
//导入配置文件，实现 xml annotation 混合开发
public class AppConfigForAnnotation {
}
