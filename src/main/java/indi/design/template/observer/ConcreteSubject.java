package indi.design.template.observer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tjx
 * @since 2020-4-4
 */
public class ConcreteSubject implements Subject {

    @Getter
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyMsg(final SubjectMessage msg) {
        observers.forEach(observer -> observer.handMsg(msg));
    }
}
