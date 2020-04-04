package indi.design.template.observer;

import indi.design.template.common.LayoutPrint;

/**
 * @author tjx
 * @since 2020-4-4
 */
public class LayoutObserver implements Observer {
    @Override
    public void handMsg(SubjectMessage msg) {
        LayoutPrint.printMsg(msg.toString());
    }
}
