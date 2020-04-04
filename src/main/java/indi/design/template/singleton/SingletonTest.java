package indi.design.template.singleton;


import indi.design.template.singleton.lazy.DoubleCheckSingleton;
import indi.design.template.singleton.lazy.InnerClassSingleton;
import org.springframework.util.Assert;

/**
 * @author tjx
 * @since 2020-4-4
 */
public class SingletonTest {
    public static void main(String[] args) throws InterruptedException {
        staticFieldSingleton();
        innerClassSingleton();
        doubleCheckSingleton();
    }

    public static void staticFieldSingleton() throws InterruptedException {
        final StaticFieldSingleton mainSingleton = StaticFieldSingleton.newInstance();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                StaticFieldSingleton singleton = StaticFieldSingleton.newInstance();
                Assert.isTrue(singleton == mainSingleton, "[staticFieldSingleton] not singleton");
            }
        };
        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }
    }

    public static void innerClassSingleton() throws InterruptedException {
        final InnerClassSingleton mainSingleton = InnerClassSingleton.newInstance();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                InnerClassSingleton singleton = InnerClassSingleton.newInstance();
                Assert.isTrue(singleton == mainSingleton, "[innerClassSingleton] not singleton");
            }
        };
        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }
    }

    public static void doubleCheckSingleton() throws InterruptedException {
        final DoubleCheckSingleton mainSingleton = DoubleCheckSingleton.newInstance();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                DoubleCheckSingleton singleton = DoubleCheckSingleton.newInstance();
                Assert.isTrue(singleton == mainSingleton, "[doubleCheckSingleton] not singleton");
            }
        };
        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }
    }

}
