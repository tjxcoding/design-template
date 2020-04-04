package indi.design.template.proxy;

import indi.design.template.common.LayoutPrint;

public class ToBeProxyServiceImpl implements ToBeProxyService {

    @Override
    public boolean sendMsg(String msg) {
        LayoutPrint.printMsg(msg);
        return true;
    }
}
