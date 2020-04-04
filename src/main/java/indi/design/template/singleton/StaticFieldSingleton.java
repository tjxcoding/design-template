package indi.design.template.singleton;

import indi.design.template.common.LayoutPrint;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 饿汉式
 *
 * @author tjx
 * @since 2020-4-4
 */
public class StaticFieldSingleton implements MsgCapable {
    private static final StaticFieldSingleton SINGLETON = new StaticFieldSingleton();

    private StaticFieldSingleton() {
    }

    public static StaticFieldSingleton newInstance() {
        return SINGLETON;
    }

    @Autowired
    public boolean sendMsg(String msg) {
        LayoutPrint.printMsg(StaticFieldSingleton.class.getSimpleName() + "：" + msg);
        return true;
    }
}
