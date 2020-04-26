package indi.design.template.builder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author tjx
 * @since 2020-4-26
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    String name;
    Integer age;
    String mobile;
    String identity;
    String address;

    public static PersonBuilder builder(){
        return new PersonBuilder();
    }

    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class PersonBuilder{

        String name;
        Integer age;
        String mobile;
        String identity;
        String address;

        public Person build(){
            return new Person(name, age, mobile, identity, address);
        }

        public PersonBuilder name(String name){
            this.name=name;
            return this;
        }

        public PersonBuilder age(Integer age){
            this.age=age;
            return this;
        }

        public PersonBuilder mobile(String mobile){
            this.mobile=mobile;
            return this;
        }

        public PersonBuilder identity(String identity){
            this.identity=identity;
            return this;
        }

        public PersonBuilder address(String address){
            this.address=address;
            return this;
        }
    }
}
