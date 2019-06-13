package site.fengjian.singleton.v3;

/**
 * 单例模式 > 懒汉式(线程安全)
 *
 * Author: fj
 * Date: 2019-06-13 22:27
 * Content:
 */
public class SingletonV3 {

    /**
     * 懒汉式  当用户真正需要使用时才会被初始化
     *
     */
    private static SingletonV3 singletonV3;

    private SingletonV3() {
    }

    /**
     * 再多线程的模式下，会被初始化多次
     * @return
     */
    public static SingletonV3 getInstance(){
        if (singletonV3 == null){
            synchronized (SingletonV3.class){
                if (singletonV3 == null){
                    singletonV3 = new SingletonV3();
                }
            }
        }
        return singletonV3;
    }

}
