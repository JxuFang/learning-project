package org.example.service.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2023-03-07 20:32
 */
@Service
@Slf4j
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void sendMessage(String message) {
        log.info("start send queue message---->>");
        jmsMessagingTemplate.convertAndSend(queue, message +"1");
        jmsMessagingTemplate.convertAndSend(queue, message + "2");
        jmsMessagingTemplate.convertAndSend(queue, message + "3");
    }
}