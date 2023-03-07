package org.example.controller.queue;

import org.example.service.queue.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2023-03-07 23:18
 */
@RestController
public class QueueController {

    @Autowired
    private Producer producer;

    @GetMapping("/hello")
    public String sendMessage() {
        producer.sendMessage("hello, world");
        return "success";
    }

    @GetMapping("/test")
    public String test() {
        return "hello";
    }
}