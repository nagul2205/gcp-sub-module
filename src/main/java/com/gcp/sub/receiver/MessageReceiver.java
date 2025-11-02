package com.gcp.sub.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcp.sub.model.Notification;
import com.gcp.sub.model.Transaction;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageReceiver{
    private static final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);
    @Autowired
    private PubSubTemplate pubSubTemplate;
    @Autowired
    private ObjectMapper mapper;

    @PostConstruct
    public void receiveMessage() {
        pubSubTemplate.subscribe("my-topic-sub", message -> {
            try {
                Transaction trnx = mapper.readValue(message.getPubsubMessage().getData().toByteArray(), Transaction.class);
                sendNotification(trnx);
                message.ack();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void sendNotification(Transaction trnx) {
        Notification data = new Notification();

        data.setTrnxId(trnx.getTrnxId());
        data.setTransactionType(trnx.getType());
        data.setAmount(trnx.getAmount());
        data.setStatus("Success !");

        logger.info("Sent Notification: {}", data);
    }
}
