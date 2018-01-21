package com.yilin.www.jms.activemqclient;

import javax.jms.Destination;
import javax.jms.JMSException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yilin.www.jms.activemqclient.consumer.ConsumerService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring-context_receiver.xml" })  
public class SyncConsumer {
	@Autowired
	@Qualifier("consumerServiceImpl")
	private ConsumerService<String> consumer;
	
	@Autowired
	@Qualifier("queueDestination")
	private Destination queue;
	 
	
	@Test
	public void consumerTest() { 
		while(true) {
			try {
				consumer.receiveMessage(queue, null);
			} catch (JMSException e) { 
				e.printStackTrace();
			} 
		}
		 
		 
	}
}
