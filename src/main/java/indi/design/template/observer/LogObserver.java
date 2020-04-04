package indi.design.template.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tjx
 * @since 2020-4-4
 */
@Slf4j
public class LogObserver implements Observer {

    @Override
    public void handMsg(SubjectMessage msg) {
        log.info(msg.toString());
    }
}
