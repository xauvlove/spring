package com.xauv.mybatis.zlaunch;

import com.xauv.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;

public class LaunchWithoutSpring {
	public static void main(String[] args) throws Exception{

		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
			inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Configuration configuration = sqlSessionFactory.getConfiguration();
		configuration.addMappers("com.xauv.mybatis.mapper");
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.queryAllUser().forEach(System.out::println);
	}
}
