package site.fengjian.java.basics.v1;

/**
 *
 * 执行顺序（静态代码块 > 非静态代码块 > 构造函数）
 *
 * @Author: FengJian
 * @Date: 2019/6/14 0014 13:58
 */
public class V1 {

    public V1() {
        System.out.println("构造函数！");
    }

    static {
        System.out.println("静态代码块！");
    }

    {
        System.out.println("非静态代码块！");
    }

    public static String say(){
        return "sat test";
    }

}
