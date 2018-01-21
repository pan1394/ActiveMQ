package com.yilin.www.jms.activemqclient.consumer;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ConsumerAsnyServiceImpl<T extends Serializable> implements ConsumerService<T>, MessageListener {

 

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public T receiveMessage(Destination destination, Destination reply) throws JMSException { 
		return (T) "N/A";
	}


	@SuppressWarnings("unchecked")
	public void onMessage(Message message) {
		T data = null;
		try {
			ObjectMessage msg = (ObjectMessage)message;
			data = (T)msg.getObject();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		logger.info("I 'm a ASYN consumer, I received data [{}]" , data);
	}

}
