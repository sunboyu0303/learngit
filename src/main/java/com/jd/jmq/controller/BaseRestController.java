package com.jd.jmq.controller;

import com.jd.jmq.client.producer.MessageProducer;
import com.jd.jmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@RestController
public class BaseRestController {

    @Resource(name = "producer")
    private MessageProducer producer;

    @Value("${jmq.producer.topic}")
    private String topic;

    @RequestMapping("/hello")
    public String hello(){
        return "123123:" + topic;
    }

    @RequestMapping("/send/{s}")
    public String send(@PathVariable String s){

        String ret = "success";
        Message message = new Message(topic, "消息内容"+ s, "业务ID"+ new Random().nextInt(10000));

        try {
            System.out.println(String.format("发送一条消息,消息主题（队列名）：%s,内容是：%s,唯一id是: %s", message.getTopic(), message.getText(), message.getBusinessId()));
            producer.send(message);
        } catch (Exception e){
            ret = e.getMessage();
        }
        return ret;
    }
}
