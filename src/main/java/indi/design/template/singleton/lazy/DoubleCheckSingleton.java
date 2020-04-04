package indi.design.template.singleton.lazy;

import indi.design.template.common.LayoutPrint;
import indi.design.template.singleton.MsgCapable;

/**
 * @author tjx
 * @since 2020-4-4
 */
public class DoubleCheckSingleton implements MsgCapable {

    private static DoubleCheckSingleton singleton;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton newInstance() {
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }

    @Override
    public boolean sendMsg(String msg) {
        LayoutPrint.printMsg(DoubleCheckSingleton.class.getSimpleName() + "：" + msg);
        return true;
    }
}
