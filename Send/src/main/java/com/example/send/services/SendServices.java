package com.example.send.services;

import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class SendServices {
    @Autowired
    private JmsTemplate template;
    @SendTo("demo1")
    public void sendOrder(String jsonDocs){
        Destination destination = new ActiveMQTopic("demo1");
        MessageCreator msg=new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
//                String json="{'order-infos':'?????????'}";
                return session.createTextMessage(jsonDocs);
            }
        };
        template.send(destination,msg);
    }

}
