package com.jd.jmq.listener;

import com.jd.jmq.client.consumer.MessageListener;
import com.jd.jmq.common.message.Message;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消息监听器.
 */
@Service(value = "messageListener")
public class DefaultMessageListener implements MessageListener {

    /**
     * 消费方法。注意: 消费不成功请抛出异常，MQ会自动重试
     *
     * @param messages
     * @throws Exception
     */
    public void onMessage(List<Message> messages) throws Exception {
        if (messages == null || messages.isEmpty()) {
            return;
        }

        for (Message message : messages) {
            System.out.println(String.format("收到一条消息,消息主题（队列名）：%s,内容是：%s,唯一id是: %s", message.getTopic(), message.getText(), message.getBusinessId()));
        }
    }
}
