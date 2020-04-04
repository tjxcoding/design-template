package indi.design.template.common;

/**
 * @author tjx
 * @since 2020-4-4
 */
public class LayoutPrint {

    public static void printMsg(String msg){
        System.out.println(msg);
    }

    public static void printMsg(DesignEnum designEnum, String msg){
        System.out.println(designEnum.getDesc() + " : " + msg);
    }
}
