package site.fengjian.effactivejava3.top44;

import site.fengjian.effactivejava3.top42.Operation;

import java.util.*;
import java.util.function.*;

/**
 * https://www.jianshu.com/p/5b35158a0365
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("=====Function====");
        Function<Integer, String> function1 = (x) -> "result: " + x;
        System.out.println(function1.apply(6));

        System.out.println("=====Predicate====");
        Predicate<String> predicate = (x) -> x.length() > 0;
        System.out.println(predicate.test("String"));

        System.out.println("=====Consumer====");
        Consumer<String> consumer = (x) -> System.out.println("consumer: " + x);
        consumer.accept("Hello");

        System.out.println("=====Supplier====");
        Supplier<String> supplier = () -> "Test supplier";
        System.out.println(supplier.get());
    }
}
