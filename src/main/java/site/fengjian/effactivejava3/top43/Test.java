package site.fengjian.effactivejava3.top43;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        String key = "one";
        String key1 = "two";

        Map<String, Integer> map = new HashMap();
        map.putIfAbsent(key, 1);
//        map.put("one", map.get("one") + 1);
//        map.computeIfPresent("one", (w, prev)-> prev +1);
        map.merge(key1, 1, Integer::sum);

        System.out.println(map);


    }
}
