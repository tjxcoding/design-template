package indi.design.template.proxy.stat;

import indi.design.template.common.DesignEnum;
import indi.design.template.common.LayoutPrint;
import indi.design.template.proxy.ToBeProxyService;
import lombok.RequiredArgsConstructor;

/**
 * @author tjx
 * @since 2020-4-4
 */
@RequiredArgsConstructor
public class StaticProxy implements ToBeProxyService {

    private final ToBeProxyService toBeProxyService;

    @Override
    public boolean sendMsg(String msg) {
        LayoutPrint.printMsg(DesignEnum.proxy, "static: before sendMsg ...");
        boolean result = toBeProxyService.sendMsg(msg);
        LayoutPrint.printMsg(DesignEnum.proxy, "static: after sendMsg ...");
        return result;
    }
}
