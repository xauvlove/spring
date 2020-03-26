/**
 *
 * spring4 采用的是 commons-logging -- log4j
 *
 * Spring5 默认使用 commons-logging(JCL) -- java.util.logging
 * 	注：spring5 虽然采用 commons-logging，但它重写了 JCL 成为一个新模块：spring-jcl 存放在 spring-framework 中
 * 	因此，spring5 虽然是 jcl，但却是自己的 jcl -> spring-jcl
 *
 * 但是，如果我们引入 log4j2 的依赖（而不是 log4j），他就会使用 log4j2 作为日志记录工具
 * 	需要注意的是，log4j2 和 log4j 是不同的
 * 	log4j2 需要引入两个依赖，分别是 log4j-core log4j-api
 * 	log4j 需要引入一个依赖，log4j
 *
 * 如果没有 log4j2 依赖，但是增加了 SLF4J_LAL 的依赖，spring 就会使用 SLF4J_LAL 来操作日志
 *
 * 如果没有 SLF4J_LAL 依赖，但是增加了 slf4j 的依赖，spring 就会使用 slf4j 来操作日志
 * 	但是 slf4j 需要借助日志记录工具（如 log4j，logback等，引入绑定器的依赖）
 *
 *
 */
package com.xauv.springframework.context.log;