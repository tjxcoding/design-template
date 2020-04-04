package indi.design.template.observer;

import lombok.RequiredArgsConstructor;

/**
 * @author tjx
 * @since 2020-4-4
 */
@RequiredArgsConstructor
public class SynchronizedConcreteSubject implements Subject {

    private final ConcreteSubject subject;
    private final Object lock = new Object();

    @Override
    public void addObserver(Observer observer) {
        synchronized (lock) {
            subject.addObserver(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        synchronized (lock) {
            subject.removeObserver(observer);
        }
    }

    @Override
    public void notifyMsg(SubjectMessage msg) {
        subject.notifyMsg(msg);
    }
}
