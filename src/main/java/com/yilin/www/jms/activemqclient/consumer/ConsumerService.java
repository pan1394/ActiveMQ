package com.yilin.www.jms.activemqclient.consumer;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;

public interface ConsumerService<T extends Serializable> {
	T receiveMessage(Destination destination, Destination reply) throws JMSException ;
}
