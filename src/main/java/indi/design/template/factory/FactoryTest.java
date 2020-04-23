package indi.design.template.factory;

/**
 * @author tjx
 * @since 2020-4-23
 */
public class FactoryTest {
    public static void main(String[] args) {
        easyFactory();
    }

    public static void easyFactory(){
        Fruit apple = FruitFactory.createFruit("apple");
        apple.make();
        Fruit banana = FruitFactory.createFruit("banana");
        banana.make();
    }
}
