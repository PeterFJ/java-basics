package site.fengjian.java.reflex.v1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author: fj
 * Date: 2019-06-15 00:37
 * Content:
 */
public class ReflexUtils {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        reflex01();
    }


    public static void reflex01() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> aClass = Class.forName("site.fengjian.java.reflex.v1.UserEntity");
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class, Integer.class);


        UserEntity userEntity = (UserEntity) constructor.newInstance("张三", 19);
        System.out.println(userEntity);

    }

}
