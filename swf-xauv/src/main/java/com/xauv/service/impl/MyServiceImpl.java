package com.xauv.service.impl;

import com.xauv.service.MyService;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

	@Override
	public void doService() {
		System.out.println("do service");
	}
}
