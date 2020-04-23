package indi.design.template.observer;

import indi.design.template.common.LayoutPrint;
import indi.design.template.observer.mq.MqProducer;
import indi.design.template.observer.mq.SubjectAdapter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

/**
 * @author tjx
 * @since 2020-4-7
 */
@RequiredArgsConstructor
public class MqConcreteSubject extends SubjectAdapter {

    private final MqProducer mqProducer;

    @Override
    public void notifyMsg(SubjectMessage msg) {
        try {
            mqProducer.sendSubjectMsg(msg);
        } catch (IOException e) {
            LayoutPrint.printMsg(e);
        }
    }
}
