package com.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MyDaoImpl implements MyDao{
	@Override
	public void doDao() {
		System.out.println("do dao");
	}
}
