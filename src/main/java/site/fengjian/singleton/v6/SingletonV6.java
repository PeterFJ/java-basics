package site.fengjian.singleton.v6;

import java.io.*;

/**
 *
 * 序列化破解单利模式
 *
 * Author: fj
 * Date: 2019-06-13 22:27
 * Content:
 */
public class SingletonV6 implements Serializable {

    /**
     *
     * java序列化的目的：
     * 对象从内存写到硬盘中  序列化
     * 从硬盘中读取到内存    反序列化
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {

        SingletonV6 singletonV1 = SingletonV6.gtInstance();

        // 序列化
        FileOutputStream fos = new FileOutputStream("/Users/fengjian/Documents/SingletonV6.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(singletonV1);
        oos.flush();
        fos.close();

        // 反序列化
        FileInputStream fis = new FileInputStream("/Users/fengjian/Documents/SingletonV6.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SingletonV6 singletonV2 = (SingletonV6) ois.readObject();

        System.out.println(singletonV2 == singletonV1);
    }








    private static SingletonV6 singletonV6 = new SingletonV6();

    private SingletonV6() {
    }

    public static SingletonV6 gtInstance(){
        return singletonV6;
    }

}
