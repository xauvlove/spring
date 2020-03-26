package com.xauv.mybatis.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com.xauv.mybatis")
@MapperScan("com.xauv.mybatis.mapper")
@Profile("dev")
public class AppConfig {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/yun6");
		dataSource.setUsername("root");
		dataSource.setPassword("521410");
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean getSqlSessionFactoryBean() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(getDataSource());
		/**
		 * 设置执行 sql 时，打印 sql 语句
		 * 这是实现打印 sql 的另一种方式
		 */
		/*org.apache.ibatis.session.Configuration configuration
				= new org.apache.ibatis.session.Configuration();
		configuration.setLogImpl(Log4jImpl.class);
		sqlSessionFactoryBean.setConfiguration(configuration);*/
		/**
		 * 设置自定义的 log
		 */
		//LogFactory.useCustomLogging(XauvLogger.class);
		return sqlSessionFactoryBean;
	}

	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
}
