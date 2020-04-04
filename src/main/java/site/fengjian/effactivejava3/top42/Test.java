package site.fengjian.effactivejava3.top42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("tom");
        list.add("hahaha");
        list.add("jerry");
        list.add("xixixixixi");
        list.add("hehe");

        // 1.
        /*Collections.sort(list, (s1, s2) ->
            Integer.compare(s1.length(), s2.length())
        );*/

        // 2.
        /*Collections.sort(list, Comparator.comparingInt(String::length));*/

        // 3.
        list.sort(Comparator.comparingInt(String::length));

        System.out.println(list);
    }
}
