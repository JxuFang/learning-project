package org.example.job;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2023-03-01 10:30
 */

import lombok.extern.slf4j.Slf4j;
import org.example.service.WsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 消息生成job
 */
@Slf4j
@Component
public class MessageJob {
    @Autowired
    WsService wsService;

    /**
     * 每5s发送
     */
    @Scheduled(cron = "0/5 * * * * *")
    public void run(){
        try {
            wsService.broadcastMsg("自动生成消息 "  + LocalDateTime.now().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
