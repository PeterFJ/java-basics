package site.fengjian.java.basics.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * java 新特性
 *
 * @Author: FengJian
 * @Date: 2019/6/14 0014 13:58
 */
public class V2 {
    public static void main(String[] args) throws InterruptedException {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("张1", 1, 1);
        Person p101 = new Person("张101", 101, 101);
        Person p2 = new Person("张2", 2, 2);
        Person p3 = new Person("张3", 3, 3);
        Person p4 = new Person("张4", 4, 4);
        Person p5 = new Person("张5", 5, 5);
        Person p6 = new Person("张6", 6, 6);
        list.add(p1);
        list.add(p101); // 排序使用
        list.add(p1); // 去重使用。
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);


        /**
         * 1.forEach()进行遍历集合
         *    item：可以是任意值。类似于for循环中的循环值
         */
//        list.forEach(item -> {
//            //设置值
//            item.setName(item.getName() + "测试");
//            //输出语句
//            System.out.println(item.toString());
//        });

        /**
         * 2.stream()流操作
         */
        //2.1. 去重 distinct() 去重；collect(Collectors.toList())。封装成集合
        List<Person> distinctList = list.stream().distinct().collect(Collectors.toList());
        System.err.println("》》》》》》》》》》》》去重：");
        System.out.println(distinctList);

        // treeset去重
        //TreeSet<Person> tree=new TreeSet<>(
        //    Comparator.comparing(Person::getName)
        //);
        //tree.addAll(list);
        //System.out.println(tree);

        //2.2 排序  sorted((第一个对象，第二个对象)->返回值)  （升降序看是第几个对象与第几个对象比较）
        List<Person> sortedList = list.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).collect(Collectors.toList());
        System.err.println("》》》》》》》》》》》》排序：");
        System.out.println(sortedList);


        //2.3 过滤 ， filter(item->{})   item为每一项。 按照自己的需求来筛选list中的数据
        List<Person> filterList = list.stream().filter(item -> item.getAge() > 3).collect(Collectors.toList());
        System.err.println("》》》》》》》》》》》》过滤：");
        System.out.println(filterList);

        //2.4 map(), 提取对象中的某一元素.  用每一项来获得属性（也可以直接用  对象::get属性()）
        List<String> mapList1 = list.stream().map(Person::getName).collect(Collectors.toList());
        List<String> mapList2 = list.stream().map(item -> item.getName()).collect(Collectors.toList());
        System.err.println("》》》》》》》》》》》》提取某一字段生成集合：");
        System.out.println("mapList1: " + mapList1);


        //2.5 统计 sum() 。mapToDouble() 转换成double。还有其他类型转换。可以自己研究。
        //           max(),min(),average()
        double sum = list.stream().mapToDouble(Person::getAge).sum();
        System.err.println("》》》》》》》》》》》》统计：");
        System.out.println(sum);

        //2.6 分组   Collectors.groupingBy(属性名)
        Map<Integer, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getAge));
        System.err.println("》》》》》》》》》》》》分组：");
        System.out.println(map);

        //2.7 多重分组 Collectors.groupingBy(属性，Collectors.groupingBy(属性))
        Map<String, Map<Integer, List<Person>>> map2 = list.stream().collect(Collectors.groupingBy(t -> t.getName(), Collectors.groupingBy(t -> t.getAge())));
        System.err.println("》》》》》》》》》》》》多重分组：");
        System.out.println(map2);

        //2.8 分组并计算综合        Collectors.summarizingLong()
        Map<String, Map<Integer, LongSummaryStatistics>> map3 = list.stream().collect(Collectors.groupingBy(t -> t.getName(), Collectors.groupingBy(t -> t.getAge(), Collectors.summarizingLong(Person::getSize))));

        /**
         *  3.  集合比较的简写方式
         */
        list.sort((o1, o2) -> {
            return o1.getAge() - o2.getAge();
        });
        System.err.println("》》》》》》》》》》》》集合比较的简写方式：");
        System.out.println(list);
    }
}
