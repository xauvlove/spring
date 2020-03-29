/**
 *
 * mybatis 整合到 spring 后，mapper 是如何实例化的？
 *	- 首先 @MapperScan("com....mapper") 扫描到所有的 mapper
 *	- 然后通过 @Import(ImportBeanDefinitionRegistrar) 和 MapperFactoryBean 注册 bean
 *  - 在 MapperFactoryBean 中，MapperFactoryBean 间接实现了 Initialization 接口，
 *
 *
 *
 *
 *
 * *****************************************************************************
 *
 * 分为：1.mybatis 执行流程
 * 		2.mybatis 整合到 spring 的执行 sql 的流程
 *
 *
 *
 *
 * 1.打开 SqlSession 后，使用其实现类 DefaultSqlSession 直接执行查询(Executor.query())
 *
 * 2.打开 SqlSession 后，SqlSession 会产生：SqlSessionTemplate，
 * 		SqlSessionTemplate 包含 sqlSession 和一个代理对象 sqlSessionProxy，然后使用 sqlSessionProxy 执行查询（proxy.query()）
 * 		每次查询后，就会执行 sqlSession.close()，导致一级缓存失效
 *
 * 	 -- 也就是说，如果整合到 spring，就会使用 SqlSessionTemplate 对 DefaultSqlSession 进行代理增强，
 *
 *
 *
 * 	-- 为什么 spring 要在每次 sql 执行后关闭 session 呢？
 * 		因为 spring 没有把代理的对象纳入到 spring 容器
 * 		我们也无法获取到这个 session，因此，如果 spring 不关闭session，我们又获取不到
 * 		那么 session 就没有办法关闭了
 *
 *  -- 而直接使用 mybatis （不整合到 spring） 可以手动关闭
 *  	因为我们可以直接获取到 session，想在什么时候关闭就在什么时候关闭
 *  	（因为 spring 会将 session 转成代理，我们无法获取，而直接使用 mybatis 不是用代理，可以直接获取）
 *
 * *****************************************************************************
 *
 *
 */
package com.xauv.mybatis.summary;