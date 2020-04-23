package indi.design.template.observer;

import indi.design.template.observer.mq.MqConsumer;
import indi.design.template.observer.mq.MsgCallable;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

/**
 * @author tjx
 * @since 2020-4-10
 */
@RequiredArgsConstructor
public class MqObserver {

    private final MqConsumer mqConsumer;

    public void handMsg(MsgCallable msgCallable) throws IOException {
        mqConsumer.receiveSubjectMsg(msgCallable);
    }

}
