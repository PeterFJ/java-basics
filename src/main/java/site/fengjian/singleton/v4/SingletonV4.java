package site.fengjian.singleton.v4;

import site.fengjian.singleton.v3.SingletonV3;

/**
 * 单例模式 > 懒汉式(内部类)
 *
 * Author: fj
 * Date: 2019-06-13 22:27
 * Content:
 */
public class SingletonV4 {

    private SingletonV4() {
        System.out.println("构造函数初始化。。。");
    }

    public static SingletonV4 getInstance(){
        return SingletonV4Utils.SINGLETON_V_4;
    }


    private static class SingletonV4Utils{
        private static final SingletonV4 SINGLETON_V_4 = new SingletonV4();
    }

    public static void main(String[] args) {
        System.out.println("项目启动中。。。。。");
        SingletonV4 singletonV1 = SingletonV4.getInstance();
        SingletonV4 singletonV2 = SingletonV4.getInstance();
        System.out.println(singletonV1 == singletonV2);
    }
}
