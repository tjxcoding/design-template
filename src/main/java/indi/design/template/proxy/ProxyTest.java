package indi.design.template.proxy;

import indi.design.template.proxy.dynamic.CommonDynamicProxy;
import indi.design.template.proxy.dynamic.DynamicProxy;
import indi.design.template.proxy.stat.StaticProxy;

/**
 * @author tjx
 * @since 2020-4-4
 */
public class ProxyTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        staticProxy();
        commonDynamicProxy();
    }

    public static void staticProxy() {
        StaticProxy proxy = new StaticProxy(new ToBeProxyServiceImpl());
        proxy.sendMsg("hello world");
    }

    public static void dynamicProxy() {
        DynamicProxy proxy = new DynamicProxy(new ToBeProxyServiceImpl());
        ToBeProxyService service = (ToBeProxyService) proxy.newInstance();
        service.sendMsg("hello world");
    }

    public static void commonDynamicProxy() {
        ToBeProxyService service = (ToBeProxyService) CommonDynamicProxy.createProxy(new ToBeProxyServiceImpl());
        service.sendMsg("hello world");
    }
}
