package indi.design.template.observer;

/**
 * @author tjx
 * @since 2020-4-4
 */
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyMsg(SubjectMessage msg);
}
