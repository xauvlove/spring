package com.xauv.dao;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Repository;

@Repository
@Description("It's description")
public class MyDaoImpl implements MyDao{
	@Override
	public void doDao() {
		System.out.println("do dao");
	}
}
