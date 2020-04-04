package indi.design.template.singleton.lazy;

import indi.design.template.common.LayoutPrint;
import indi.design.template.singleton.MsgCapable;

/**
 * @author tjx
 * @since 2020-4-4
 */
public class InnerClassSingleton implements MsgCapable {

    private InnerClassSingleton() {
    }

    public static InnerClassSingleton newInstance() {
        return Singleton.singleton;
    }

    @Override
    public boolean sendMsg(String msg) {
        LayoutPrint.printMsg(InnerClassSingleton.class.getSimpleName() + "：" + msg);
        return true;
    }

    static class Singleton {
        static InnerClassSingleton singleton = new InnerClassSingleton();
    }
}
