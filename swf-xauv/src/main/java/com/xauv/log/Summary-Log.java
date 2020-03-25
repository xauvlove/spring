/**
 *
 * Spring5 默认使用 java.util.logging
 * 但是，如果我们引入 log4j2 的依赖，他就会使用 log4j2 作为日志记录工具
 *
 * 如果没有 log4j2 依赖，但是增加了 SLF4J_LAL 的依赖，spring 就会使用 SLF4J_LAL 来操作日志
 *
 * 如果没有 SLF4J_LAL 依赖，但是增加了 slf4j 的依赖，spring 就会使用 slf4j 来操作日志
 * 	但是 slf4j 需要借助日志记录工具（如 log4j，logback等，引入绑定器的依赖）
 *
 */
package com.xauv.log;