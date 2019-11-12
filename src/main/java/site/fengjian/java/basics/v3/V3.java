package site.fengjian.java.basics.v3;

import java.util.StringJoiner;

/**
 * java8新加StringBuilder字符串拼接
 */
public class V3 {

    public static void main(String[] args) {

        // 使用StringBuilder之前
        //System.out.println(getBefore());

        //System.out.println(getAfter());

        //System.out.println(getAfter1());

        System.out.println(getJoin());
    }

    /**
     * jdk8之前
     *
     * @return
     */
    public static String getBefore() {
        String[] names = {"Bob", "Alice", "Grace"};
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ");
        for (String name : names) {
            sb.append(name).append(", ");
        }
        // 注意去掉最后的", ":
        sb.delete(sb.length() - 2, sb.length());
        sb.append("!");
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 使用StringBuilder
     *
     * @return
     */
    public static String getAfter() {
        String[] names = {"Bob", "Alice", "Grace"};
        StringJoiner sj = new StringJoiner(", ");
        for (String name : names) {
            sj.add(name);
        }
        return sj.toString();
    }

    /**
     * 使用StringBuilder
     *
     * @return
     */
    public static String getAfter1() {
        String[] names = {"Bob", "Alice", "Grace"};
        StringJoiner sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        return sj.toString();
    }

    /**
     * 使用join
     *
     * @return
     */
    public static String getJoin() {
        String[] names = {"Bob", "Alice", "Grace"};
        String s = String.join(", ", names);
        return s;
    }

}
