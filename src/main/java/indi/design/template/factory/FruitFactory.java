package indi.design.template.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tjx
 * @since 2020-4-23
 */
public class FruitFactory {

    private static Map<String, Fruit> fruitMap = new HashMap<>();

    static {
        fruitMap.put("apple", new Apple());
        fruitMap.put("banana", new Banana());
    }

    public static Fruit createFruit(String fruit) {
        return fruitMap.get(fruit);
    }
}
