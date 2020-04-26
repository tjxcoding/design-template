package indi.design.template.builder;

import indi.design.template.common.LayoutPrint;

/**
 * @author tjx
 * @since 2020-4-26
 */
public class BuilderTest {

    public static void main(String[] args) {
        Person.PersonBuilder personBuilder = Person.builder();
        personBuilder.name("builder");
        Person person = personBuilder.build();
        LayoutPrint.printMsg(person.toString());
    }
}
