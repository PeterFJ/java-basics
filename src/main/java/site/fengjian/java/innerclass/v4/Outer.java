package site.fengjian.java.innerclass.v4;

/**
 * @Author: FengJian
 * @Date: 2019/6/14 0014 14:30
 */
public class Outer {
    public static IAnimal getInnerInstance(String speak){
        return new IAnimal(){
            @Override
            public void speak(){
                System.out.println(speak);
            }};
        //注意上一行的分号必须有
    }

    /**
     * 小结【匿名内部类常常被用来重写某个或某些方法】
     * 匿名内部类是没有访问修饰符的。
     * 使用匿名内部类时，这个new之后的类首先是要存在的，其次我们要重写new后的类的某个或某些方法。
     * 匿名内部类访问方法参数时也有和局部内部类同样的限制。
     * 匿名内部类没有构造方法。
     *
     * @param args
     */
    public static void main(String[] args){
        //调用的speak()是重写后的speak方法。
        Outer.getInnerInstance("小狗汪汪汪！").speak();
    }
}
