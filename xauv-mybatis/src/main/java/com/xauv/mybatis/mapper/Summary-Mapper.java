/**
 * 1.一级缓存：
 * 	1.1 一级缓存和线程有关，也就是 不同的线程进行访问同一 sql，他们的一级缓存是不共享的
 *	1.2 mybatis 一级缓存失效原因，
 * 		由于 mybatis 整合到 spring 中
 * 		mybatis 的 session 交给 spring 管理
 * 		spring 在每次执行 sql 后，会将 session 关闭，这就导致一级缓存失效
 * 		spring 在执行 sql 时，是使用代理执行的
 *
 *
 * 2.二级缓存：
 * 	2.1 开启，在 Mapper 上加注解： {@link org.apache.ibatis.annotations.CacheNamespace}
 * 	2.2 <存在的坑> 命名空间：
 * 		如果我们在命名空间 userMapper1 中查询到一些数据，开启二级缓存后，会将这些数据缓存到命名空间内
 * 		但，如果我们在命名空间 userMapper2 中修改了一些数据，它会使 userMapper2 的缓存失效
 *		但，如果我们继续在 userMapper1 查询相同的信息的时候，查询到的信息都是没有修改的数据（脏数据）
 *		--- 也就是说，在不同命名空间操作之后，可能会产生脏数据
 *
 * 3. 一级缓存和二级缓存是有些鸡肋的功能，因此，现在通常使用 redis 作为缓存使用
 *
 */