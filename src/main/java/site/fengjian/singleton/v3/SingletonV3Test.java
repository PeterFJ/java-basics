package site.fengjian.singleton.v3;

import site.fengjian.singleton.v2.SingletonV2;

/**
 * 单例模式 > 懒汉式
 *
 * Author: fj
 * Date: 2019-06-13 22:27
 * Content:
 */
public class SingletonV3Test {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    SingletonV3 singletonV2 = SingletonV3.getInstance();
                    System.out.println(singletonV2);
                }
            }).start();

        }
    }

}
