package indi.design.template.proxy.dynamic;

import indi.design.template.common.DesignEnum;
import indi.design.template.common.LayoutPrint;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author tjx
 * @since 2020-4-4
 */
public class CommonDynamicProxy {

    public static Object createProxy(Object toBeProxiedObj) {
        ProxyHandler handler = new ProxyHandler(toBeProxiedObj);
        Class<?> clzz = toBeProxiedObj.getClass();
        return Proxy.newProxyInstance(clzz.getClassLoader(), clzz.getInterfaces(), handler);
    }

    @RequiredArgsConstructor
    static class ProxyHandler implements InvocationHandler {

        final Object toBeProxiedObj;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            LayoutPrint.printMsg(DesignEnum.proxy, "dynamic: before sendMsg ...");
            Object result = method.invoke(toBeProxiedObj, args);
            LayoutPrint.printMsg(DesignEnum.proxy, "dynamic: after sendMsg ...");
            return result;
        }
    }
}
