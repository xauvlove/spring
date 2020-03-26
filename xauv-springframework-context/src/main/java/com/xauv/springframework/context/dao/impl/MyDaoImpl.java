package com.xauv.springframework.context.dao.impl;

import com.xauv.springframework.context.dao.MyDao;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Repository;

@Repository("xauvDaoImpl")
@Description("It's description")
public class MyDaoImpl implements MyDao {
	@Override
	public void doDao() {
		System.out.println("do dao");
	}
}
