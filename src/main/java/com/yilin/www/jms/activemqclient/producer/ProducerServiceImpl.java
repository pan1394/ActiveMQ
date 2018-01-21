package com.yilin.www.jms.activemqclient.producer;

import java.io.Serializable;

import javax.jms.Destination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl<T extends Serializable> implements ProducerService<T> { 

	 
	@Autowired
	private JmsTemplate jmsTemplate;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void sendMessage(Destination destination, T message) {
		final T data = message;
		logger.info("Producer make a message.");
		/*this.jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException { 
				return session.createObjectMessage(data);
			}
		});*/
		this.jmsTemplate.convertAndSend(destination, data);
		
	}

}
