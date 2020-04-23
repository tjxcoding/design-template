package indi.design.template.factory;

import indi.design.template.common.LayoutPrint;

/**
 * @author tjx
 * @since 2020-4-23
 */
public class Banana implements Fruit {
    @Override
    public void make() {
        LayoutPrint.printMsg("make banana");
    }
}
