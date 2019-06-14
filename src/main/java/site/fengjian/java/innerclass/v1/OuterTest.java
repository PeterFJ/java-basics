package site.fengjian.java.innerclass.v1;

/**
 *
 * 成员内部类
 *
 * @Author: FengJian
 * @Date: 2019/6/14 0014 14:11
 */
public class OuterTest {

    /**
     *
     * 小结：【成员内部类当成Outer的成员信息存在 】
     * 可以是任何的访问修饰符。
     * 内部类的内部不能有静态信息。
     * 内部类也是类,该继承继承，该重写重写，该重载重载，this和super随便用。
     * 外部类如何访问内部类信息，必须new之后打点访问。
     * 内部类可以直接使用外部类的任何信息，如果属性或者方法发生冲突，调用外部类.this.属性或者方法。
     * 其它类如何访问内部类：
     *
     * @param args
     */
    public static void main(String[] args) {
        //外部类对象
        Outer outer = new Outer();
        //创造内部类对象
        Outer.Inner inner = outer.new Inner();
        inner.innerShow();
        /*
         * 可在Outer中定义get方法，获得Inner对象,那么使用时，只需outer.getInnerInstance()即可。
         * public Inner getInnerInstance(Inner类的构造方法参数){
         *   return new Inner(参数);
         * }
         */
    }

}
