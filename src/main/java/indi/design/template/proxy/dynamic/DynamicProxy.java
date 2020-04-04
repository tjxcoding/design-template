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
@Deprecated
@RequiredArgsConstructor
public class DynamicProxy {

    private final Object toBeProxiedObj;

    public Object newInstance() {
        ProxyHandler handler = new ProxyHandler();
        Class<?> clzz = toBeProxiedObj.getClass();
        return Proxy.newProxyInstance(clzz.getClassLoader(), clzz.getInterfaces(), handler);
    }

    class ProxyHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            LayoutPrint.printMsg(DesignEnum.proxy, "dynamic: before sendMsg ...");
            Object result = method.invoke(toBeProxiedObj, args);
            LayoutPrint.printMsg(DesignEnum.proxy, "dynamic: after sendMsg ...");
            return result;
        }
    }
}
