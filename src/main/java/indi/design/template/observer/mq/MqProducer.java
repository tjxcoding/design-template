package indi.design.template.observer.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import indi.design.template.common.JsonUtils;
import indi.design.template.common.LayoutPrint;
import indi.design.template.observer.SubjectMessage;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static indi.design.template.observer.mq.MqConstants.*;

/**
 * @author tjx
 * @since 2020-4-7
 */
public class MqProducer {

    private Channel channel;


    public MqProducer() {
        try {
            init();
        } catch (IOException | TimeoutException e) {
            LayoutPrint.printMsg("MqProducer init error...");
        }
    }

    public void init() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP);
        factory.setPort(PORT);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
        factory.setVirtualHost(VIRTUAL_HOST);
        Connection connection = factory.newConnection();
        channel = connection.createChannel();
        // type: topic, durable: true
        channel.exchangeDeclare(EXCHANGE_NAME, "topic", true);
        // durable: true, exclusive: false, autoDelete: false
        // queue
        channel.queueDeclare(QUEUE_OBSERVER, true, false, false, null);
        channel.queueBind(QUEUE_OBSERVER, EXCHANGE_NAME, QUEUE_OBSERVER);
    }

    public boolean testSendMsg() throws IOException {
        channel.basicPublish(EXCHANGE_NAME, QUEUE_OBSERVER, null, "Hello world".getBytes());
        return true;
    }

    public boolean sendSubjectMsg(SubjectMessage msg) throws IOException {
        byte[] data = JsonUtils.beanToJson(msg).getBytes();
        channel.basicPublish(EXCHANGE_NAME, QUEUE_OBSERVER, null, data);
        return true;
    }
}
