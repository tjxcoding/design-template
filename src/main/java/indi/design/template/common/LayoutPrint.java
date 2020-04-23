package indi.design.template.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tjx
 * @since 2020-4-4
 */
@Slf4j
public class LayoutPrint {

    public static void printMsg(String msg){
        System.out.println(msg);
    }

    public static void printMsg(Throwable e){
        System.err.println(e.getMessage());
    }

    public static void printMsg(DesignEnum designEnum, String msg){
        System.out.println(designEnum.getDesc() + " : " + msg);
    }
}
