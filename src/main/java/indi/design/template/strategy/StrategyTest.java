package indi.design.template.strategy;

import indi.design.template.common.LayoutPrint;

/**
 * @author tjx
 * @since 2020-4-23
 */
public class StrategyTest {

    public static void main(String[] args) {
        weaveTest();
    }

    private static void weaveTest() {
        //Weave weave = new HorizontalWeave();
        Weave weave = new VerticalWeave();
        String weaveString = weave.weaveString("a", "b");
        LayoutPrint.printMsg(weaveString);
    }
}
