package site.fengjian.java.innerclass.v2;

/**
 *
 * 静态内部类
 *
 * @Author: FengJian
 * @Date: 2019/6/14 0014 14:19
 */
public class OuterTest {

    /**
     * 小结【和成员内部类对比理解（区别异同）】
     * 内部可以包含任意的信息。
     * 静态内部类的方法只能访问外部类的static关联的信息。
     * 利用 外部类.内部类 引用=new 外部类.内部类(); 然后利用引用.成员信息(属性、方法)调用。
     * 访问内部类的静态信息，直接外部类.内部类.静态信息就可以了。
     * 静态内部类可以独立存在，不依赖于其他外围类。
     *
     * @param args
     */
    public static void main(String[] args) {
        //访问静态内部类的静态方法，Inner类被加载,此时外部类未被加载，独立存在，不依赖于外围类。
        Outer.Inner.innerStaticShow();
        //访问静态内部类的成员方法
        Outer.Inner oi = new Outer.Inner();
        oi.innerShow();
    }
}
