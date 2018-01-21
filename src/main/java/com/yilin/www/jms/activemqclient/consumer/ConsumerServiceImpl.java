package com.yilin.www.jms.activemqclient.consumer;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl<T extends Serializable> implements ConsumerService<T> {

	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@SuppressWarnings("unchecked")
	public T receiveMessage(Destination destination, Destination reply) throws JMSException {
		/*ObjectMessage message = (ObjectMessage) this.jmsTemplate.receive(destination); 
		T data = (T)message.getObject();*/
		
		/*this.jmsTemplate.send(reply, new MessageCreator() { 
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("got one message."); 
			}
			
		});*/
		T data = (T)this.jmsTemplate.receiveAndConvert(destination);
		logger.info("I am a SYNC consumer, I received data [{}]",  data);
		return data;
	}

}
