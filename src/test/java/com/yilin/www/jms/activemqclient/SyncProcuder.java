package com.yilin.www.jms.activemqclient;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yilin.www.jms.activemqclient.producer.ProducerService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring-context.xml" })  
public class SyncProcuder {
	@Autowired
	private ProducerService<String> producer;
	
	@Autowired
	private Destination queueDestination;
	
	@Test
	public void procuderTest() {
		int i = 5;
		while(i-- > 0) {
			producer.sendMessage(queueDestination, "Hello, message body "+i);
		}
		
		while(true) {
			;
		}
	}
}
