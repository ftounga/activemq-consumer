package com.activemq.consumer.consumer;

import com.activemq.producer.dto.CarDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Slf4j
public class CarConsumer implements MessageListener {

    @Override
    @JmsListener(destination = "${active-mq.broker-topic}", containerFactory = "topicJmsListenerContainerFactory")
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            CarDto carDto = (CarDto) objectMessage.getObject();
            //do additional processing
            log.info("The thread "+Thread.currentThread().getName()+" recieve car with id: "+ carDto.getId());
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }
    }
}
