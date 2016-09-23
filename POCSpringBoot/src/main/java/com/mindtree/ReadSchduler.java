package com.mindtree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mindtree.service.TestService;

/*@Component*/
public class ReadSchduler {

	@Autowired
	TestService service;
	@Scheduled(fixedRate=1000000)
	public void method(){
		
		service.readData();
		
	}
}
