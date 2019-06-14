package site.fengjian.singleton.v8;

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
public enum EnumSingleton {

    INSTANCE;

    public void add(){
        System.out.println("add方法.....");
    }

}
