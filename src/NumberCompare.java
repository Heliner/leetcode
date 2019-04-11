
public class NumberCompare {

    /**
     * 数值比较,以Float为例
     */
    public void testName1() throws Exception {
        byte b1=1;
        System.out.println("b=i:"+(b1==1));
        // Float装箱
        Float f = 12.1f; // 等同:Float f = new Float(12.1);
        Float f2 = 12.1f;

        /*
         * 结果全是false
         */
        System.out.println(f.equals(12.1));
        System.out.println(f == 12.1);
        System.out.println(f.floatValue() == 12.1);
        System.out.println(f == f2);

        /*
         * 为什么结果全是false?
         * --------------------------------
         * 1. equals()方法
         *         如果是引用类型间的比较：
         *             equals()方法的参数可以传入任何对象。但是如果[传入参数的数据类型]和[方法所属对象的类型]不一致,就会直接返回false。
         *             只有[传入参数的数据类型]和[方法所属对象的类型]一致时,才会继续对值进行比较。
         *
         *         如果是引用类型和基本类型进行比较：
         *             如果传入的参数时基本类型,会对参数自动装箱,变成引用类型间的比较。
         *
         * 2. == 用于引用类型的比较和基本类型的比较。
         *         如果是引用类型间的比较：
         *             直接比较内存地址,不同就返回false.不会对具体数值进行比较。
         *
         *         如果是基本类型间的比较：
         *             类型相同时,才会比较。类型不同时,会返回false,或直接编译不通过。
         *
         *         如果是引用类型和基本类型进行比较：
         *             会将引用类型拆箱,转成基本类型后,在进行基本类型间的比较。
         *
         * 总结：
         *         数据类型相同的值,才有比较的意义。
         *         数据类型不同的值,不要放在一起比较。如果一定要比较,先转换成相同的类型再比较。
         */

        /*
         * 换个写法,结果全是true
         */

        // equals() : 引用类型间的比较
        System.out.println(f.equals(f2));
        System.out.println(f.equals(new Float(12.1)));

        // equals() : 引用类型和基本类型的比较
        System.out.println(f.equals(12.1f)); // 会先将基本类型装箱

        // == : 基本类型间的比较
        System.out.println(f.floatValue() == 12.1f);

        // == : 引用类型和基本类型的比较
        System.out.println(f == 12.1f); // 会先将引用类型拆箱

        float f3 = 12.1f;
        System.out.println(f == f3);
    }

    public static void main(String[] args) throws Exception {
        NumberCompare numberCompare = new NumberCompare();
        numberCompare.testName1();
    }
}
