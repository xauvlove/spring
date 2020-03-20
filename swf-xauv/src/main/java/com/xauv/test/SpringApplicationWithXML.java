package com.xauv.test;

import com.xauv.dao.impl.SpringXMLDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationWithXML {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		SpringXMLDaoImpl springXMLDao = (SpringXMLDaoImpl)context.getBean("springXMLDao");
		springXMLDao.doDao();
	}
}
