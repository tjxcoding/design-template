package indi.design.template.observer.mq;

import indi.design.template.common.LayoutPrint;
import indi.design.template.observer.MqConcreteSubject;
import indi.design.template.observer.MqObserver;
import indi.design.template.observer.SubjectMessage;

import java.io.IOException;

/**
 * @author tjx
 * @since 2020-4-7
 */
public class MqTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        testObserverMq();
    }

    public static void testMq() throws InterruptedException, IOException {
        MqProducer producer = new MqProducer();
        boolean isSendSuccess = producer.testSendMsg();
        System.out.println(String.format("消息是否发生成功：%s", isSendSuccess));
        Thread.sleep(6000L);
        MqConsumer consumer = new MqConsumer();
        boolean isReceiveSuccess = consumer.testReceiveMsg(msg -> LayoutPrint.printMsg("receive msg: " + msg));
        System.out.println(String.format("消息是否接受成功：%s", isReceiveSuccess));
    }

    public static void testObserverMq() throws InterruptedException, IOException {
        MqProducer producer = new MqProducer();
        MqConcreteSubject subject = new MqConcreteSubject(producer);
        SubjectMessage message = new SubjectMessage();
        message.setId(1);
        message.setDesc("do something");
        subject.notifyMsg(message);
        Thread.sleep(6000L);
        MqConsumer consumer = new MqConsumer();
        MqObserver observer = new MqObserver(consumer);
        observer.handMsg(msg -> LayoutPrint.printMsg("receive msg: " + msg));
    }
}
