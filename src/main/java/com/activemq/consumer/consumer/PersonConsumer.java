package com.activemq.consumer.consumer;

import com.activemq.producer.dto.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Slf4j
public class PersonConsumer implements MessageListener {

    @Override
    @JmsListener(destination = "${active-mq.broker-queue}", containerFactory = "queueJmsListenerContainerFactory")
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            PersonDto personDto = (PersonDto)objectMessage.getObject();
            //do additional processing
            log.info("The thread "+Thread.currentThread().getName()+" recieve person with id: "+ personDto.getId());
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }
    }
}
