package indi.design.template.observer;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author tjx
 * @since 2020-4-4
 */
public class ConcurrentConcreteSubject implements Subject {

    @Getter
    private List<Observer> observers = new CopyOnWriteArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyMsg(SubjectMessage msg) {
        observers.forEach(observer -> observer.handMsg(msg));
    }
}
