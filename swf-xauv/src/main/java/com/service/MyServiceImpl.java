package com.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService{

	@Override
	public void doService() {
		System.out.println("do service");
	}
}
