package indi.design.template.observer.mq;

import indi.design.template.observer.Observer;
import indi.design.template.observer.Subject;
import indi.design.template.observer.SubjectMessage;

/**
 * @author tjx
 * @since 2020-4-10
 */
public class SubjectAdapter implements Subject {
    @Override
    public void addObserver(Observer observer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeObserver(Observer observer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notifyMsg(SubjectMessage msg) {
        throw new UnsupportedOperationException();
    }
}
