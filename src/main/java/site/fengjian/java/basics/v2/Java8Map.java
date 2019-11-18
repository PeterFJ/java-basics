package site.fengjian.java.basics.v2;

import java.util.HashMap;
import java.util.Map;

public class Java8Map {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        System.out.println(map);
        // map新特性，如果存在直接拿
        /**
         *
         *         // java8之前。从map中根据key获取value操作可能会有下面的操作
         *         Object key = map.get("key");
         *         if (key == null) {
         *             key = new Object();
         *             map.put("key", key);
         *         }
         *
         *         // java8之后。上面的操作可以简化为一行，若key对应的value为空，会将第二个参数的返回值存入并返回
         *         Object key2 = map.computeIfAbsent("key", k -> new Object());
         *
         *
         */
        map.computeIfAbsent("test1", key -> map.put("test1", "test1111"));
        System.out.println(map);
    }

}
