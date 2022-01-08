package com.activemq.consumer.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import java.util.Arrays;

@Configuration
@EnableJms
public class ActiveMQConfig {

    @Value("${active-mq.broker-url}")
    private String brokerUrl;

    @Value("${active-mq.broker-username}")
    private String username;

    @Value("${active-mq.broker-password}")
    private String password;

    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory  = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        activeMQConnectionFactory.setUserName(username);
        activeMQConnectionFactory.setPassword(password);
        activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.activemq.producer.dto"));
        return  activeMQConnectionFactory;
    }

    @Bean(name = "topicJmsListenerContainerFactory")
    public DefaultJmsListenerContainerFactory topicJmsListenerContainerFactory(){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean(name = "queueJmsListenerContainerFactory")
    public DefaultJmsListenerContainerFactory queueJmsListenerContainerFactory(){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setPubSubDomain(false);
        return factory;
    }
}