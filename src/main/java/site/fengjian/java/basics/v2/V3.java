package site.fengjian.java.basics.v2;

import com.sun.org.apache.xpath.internal.operations.String;

public class V3 {
    public static void main(String[] args) {
        //List<Person> list = new ArrayList<>();
        //Person p1 = new Person("张1", 1, 1);
        //Person p101 = new Person("张101", 101, 101);
        //Person p2 = new Person("张2", 2, 2);
        //Person p3 = new Person("张3", 3, 3);
        //Person p4 = new Person("张4", 4, 4);
        //Person p5 = new Person("张5", 5, 5);
        //Person p6 = new Person("张6", 6, 6);
        //list.add(p1);
        //list.add(p101); // 排序使用
        //list.add(p1); // 去重使用。
        //list.add(p2);
        //list.add(p3);
        //list.add(p4);
        //list.add(p5);
        //list.add(p6);
        //
        //Map<String, Person> collect = list.stream().collect(Collectors.toMap(Person::getName, o -> o));
        //
        //System.out.println(collect);

        //Person[] ps = new Person[2];
        //ps[0] = new Person("张1", 1, 1);
        //ps[1] = new Person("张2", 2, 2);
        //
        //System.out.println(Arrays.stream(ps));

        int i = 1;

        try {
            int b = 1 /0;
        }catch (Exception e){
            i = 2;
        }

        System.out.println(i);
    }
}
