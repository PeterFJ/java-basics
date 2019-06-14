package site.fengjian.singleton.v2;

/**
 * 单例模式 > 懒汉式
 *
 * Author: fj
 * Date: 2019-06-13 22:27
 * Content:
 */
public class SingletonV2 {

    /**
     * 懒汉式  当用户真正需要使用时才会被初始化
     *
     */
    private static SingletonV2 singletonV2;

    private SingletonV2() {
    }

    /**
     * 在多线程的模式下，会被初始化多次
     * @return
     */
    public synchronized static SingletonV2 getInstance(){
        if (singletonV2 == null){

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            singletonV2 = new SingletonV2();
        }
        return singletonV2;
    }

}
