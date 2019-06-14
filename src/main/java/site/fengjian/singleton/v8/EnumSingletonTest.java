package site.fengjian.singleton.v8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * 枚举单例模式
 *
 * 能后有效的防止多次实例，序列化和反射破解。
 *
 * Author: fj
 * Date: 2019-06-15 00:15
 * Content:
 */
public class EnumSingletonTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        /*EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;
        System.out.println(singleton1 == singleton2);


        // 找不到无参数构造函数
        Class<EnumSingleton> aClass = EnumSingleton.class;
        Constructor<EnumSingleton> constructor = aClass.getDeclaredConstructor();
        EnumSingleton singleton = constructor.newInstance();
        singleton.add();*/


        /**
         * 枚举EnumSingleton.INSTANCE是一个对象，
         * 枚举底层最终转化成一个类，
         *
         * 枚举中存储的是一个数组，只有一个有参构造函数（对象名称，数组序号）
         *
         * 枚举不能被反射,会抛出异常
         * throw new IllegalArgumentException("Cannot reflectively create enum objects");
         *
         */
        EnumSingleton.INSTANCE.add();
    }

}
