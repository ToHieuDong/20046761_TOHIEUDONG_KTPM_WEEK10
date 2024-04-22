package com.example.receives.services;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class Receive_Service {

    @JmsListener(destination = "demo1")
    public void listener(Message<String> message) {
        String msg = message.getPayload();
        System.out.println("Receives:  " + msg);
    }
}
