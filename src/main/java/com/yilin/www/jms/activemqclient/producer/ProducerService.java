package com.yilin.www.jms.activemqclient.producer;

import java.io.Serializable;

import javax.jms.Destination;

public interface ProducerService<T extends Serializable> {
	void sendMessage(Destination destination, final T message);
}
