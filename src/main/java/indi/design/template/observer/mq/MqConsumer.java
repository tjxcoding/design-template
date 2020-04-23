package indi.design.template.observer.mq;

import com.rabbitmq.client.*;
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
public class MqConsumer {

    private Channel channel;

    public MqConsumer() {
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
    }

    public boolean testReceiveMsg(MsgCallable msgCallable) throws IOException {
        channel.basicConsume(QUEUE_OBSERVER, false, "consumerTag", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                msgCallable.msgCallback(new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
        return true;
    }

    public boolean receiveSubjectMsg(MsgCallable msgCallable) throws IOException {
        channel.basicConsume(QUEUE_OBSERVER, false, "consumerTag", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                SubjectMessage subjectMessage = JsonUtils.jsonToBean(new String(body), SubjectMessage.class);
                msgCallable.msgCallback(subjectMessage.toString());
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
        return true;
    }
}
