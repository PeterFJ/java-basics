package site.fengjian.singleton.v5;

import site.fengjian.singleton.v3.SingletonV3;

import java.lang.reflect.Constructor;

/**
 *
 * 反射破解单例模式
 *
 * Author: fj
 * Date: 2019-06-14 23:52
 * Content:
 */
public class Test {

    public static void main(String[] args) throws Exception {


        SingletonV3 v1 = SingletonV3.getInstance();

        Constructor<SingletonV3> constructor = SingletonV3.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonV3 v2 = constructor.newInstance();


    }
}
