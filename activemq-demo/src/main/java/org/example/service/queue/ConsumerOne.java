package org.example.service.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2023-03-07 20:38
 */
@Service
@Slf4j
public class ConsumerOne {
    /**
     * @author Fang Jinxu
     * @Description  消息队列监听器
     * @date 2023/3/7 23:15
     * @param message
     * @return void
     */
    @JmsListener(destination = "queueMode", containerFactory = "queueListener")
    public void receiveMessage(String message) {
        log.info("receive message: {}", message);
    }

}