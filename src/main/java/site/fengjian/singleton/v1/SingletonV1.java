package site.fengjian.singleton.v1;

/**
 * 单例模式 > 饿汉式
 *
 * Author: fj
 * Date: 2019-06-13 22:27
 * Content:
 */
public class SingletonV1 {

    /**
     * 饿汉式
     * 优点：先天性的线程安全，当类初始化的时候，就被创建对象
     * 缺点：如果项目中使用过多的饿汉式发生问题，项目在启动的时候会非常慢，
     *      存放在方法区，占用内存比较大
     *      如果用户不适用该对象的时候，也会创建。
     */
    private static SingletonV1 singletonV1 = new SingletonV1();

    private SingletonV1() {
    }

    public static SingletonV1 gtInstance(){
        return singletonV1;
    }

}
