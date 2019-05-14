package com.dragon.demo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author ljn
 * @date 2019/5/13.
 */
public class Demo1 {

    public static void main(String[] args) {

        MyLambdaInterface blockCode = s->System.out.println(s);
        invoke((s)->System.out.println(s), "Hello World!");

        MyInterfaceImpl impl = new MyInterfaceImpl();
        invoke(impl,"Hello World!");
        List<Person> list = Arrays.asList(
                new Person("Jack", "Green", 18),
                new Person("Lucy", "Smith", 16),
                new Person("Lei", "Li", 17));
        list.stream().filter(p->p.getFirstName().startsWith("J")).forEach(System.out::println);

        checkAndExecutor(list,
                p->p.getFirstName().startsWith("J"),
                p-> System.out.println(p.getFirstName()));

    }

    public static void invoke(MyLambdaInterface myLambda, String s) {
        myLambda.doSomething(s);
    }

    public static void checkAndExecutor(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer) {
        personList.forEach(p -> {if (predicate.test(p)){
            consumer.accept(p);
        }});
    }





}
