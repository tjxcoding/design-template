package indi.design.template.observer.mq;

/**
 * @author tjx
 * @since 2020-4-7
 */
public interface MqConstants {
    String USERNAME = "guest";
    String PASSWORD = "guest";
    String IP = "127.0.0.1";
    // not 15672
    int PORT = 5672;
    String VIRTUAL_HOST = "design";
    String EXCHANGE_NAME = "design.template";
    String QUEUE_OBSERVER = "design.template.observer";
}
