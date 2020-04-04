package indi.design.template.observer;

import indi.design.template.common.LayoutPrint;
import lombok.RequiredArgsConstructor;

/**
 * @author tjx
 * @since 2020-4-4
 */
public class ObserverTest {

    private static final int sleepTime = 90000;

    public static void main(String[] args) throws InterruptedException {
        //observer();
        checkConcurrent();
        Thread.sleep(sleepTime);
        System.out.println("----分割线-----");

        checkSafeConcurrent();
    }

    public static void observer() throws InterruptedException {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        LayoutObserver layoutObserver = new LayoutObserver();
        concreteSubject.addObserver(layoutObserver);
        LogObserver logObserver = new LogObserver();
        concreteSubject.addObserver(logObserver);
        SubjectMessage message = new SubjectMessage();
        message.setId(1);
        message.setDesc("hello observer");
        concreteSubject.notifyMsg(message);
        LayoutPrint.printMsg("-----分割线-----");
        Thread.sleep(5000);
        concreteSubject.removeObserver(layoutObserver);
        concreteSubject.notifyMsg(message);
    }

    public static void checkConcurrent() throws InterruptedException {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        LogObserver logObserver = new LogObserver();
        Runnable addRunnable = new MyAddRunnable(concreteSubject, logObserver);
        Runnable removeRunnable = new MyRemoveRunnable(concreteSubject, logObserver);
        for (int i = 0; i < 1000; i++) {
            new Thread(addRunnable).start();
        }
        Thread.sleep(sleepTime );
        for (int i = 0; i < 10000; i++) {
            new Thread(addRunnable).start();
            new Thread(removeRunnable).start();
        }
        Thread.sleep(sleepTime);
        System.out.println(concreteSubject.getObservers().size());
    }

    public static void checkSafeConcurrent() throws InterruptedException {
        ConcurrentConcreteSubject subject = new ConcurrentConcreteSubject();
        LogObserver logObserver = new LogObserver();
        Runnable addRunnable = new MyAddRunnable(subject, logObserver);
        Runnable removeRunnable = new MyRemoveRunnable(subject, logObserver);
        for (int i = 0; i < 1000; i++) {
            new Thread(addRunnable).start();
        }
        Thread.sleep(sleepTime);
        for (int i = 0; i < 10000; i++) {
            new Thread(addRunnable).start();
            new Thread(removeRunnable).start();

        }
        Thread.sleep(sleepTime);
        System.out.println(subject.getObservers().size());
    }

    @RequiredArgsConstructor
    static class MyAddRunnable implements Runnable {

        private final Subject subject;
        private final Observer observer;

        @Override
        public void run() {
            subject.addObserver(observer);
        }
    }

    @RequiredArgsConstructor
    static class MyRemoveRunnable implements Runnable {

        private final Subject subject;
        private final Observer observer;

        @Override
        public void run() {
            subject.removeObserver(observer);
        }
    }


}
