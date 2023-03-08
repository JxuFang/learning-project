package org.example.service.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2023-03-08 09:44
 */
@Service
@Slf4j
public class ConsumerTwo {

    @JmsListener(destination = "queueMode", containerFactory = "queueListener")
    public void receiveMessage(String message) {
        log.info("receive message: {}", message);
    }

}