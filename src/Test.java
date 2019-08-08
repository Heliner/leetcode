import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        System.out.println(new B().getValue());
        System.out.println("is:" + 100 + 5);

        int[] a = new int[]{1};
        int[] b = new int[]{2};
        int[] t = null;
        {
            t = a;
            a = b;
            b = t;
        }
        System.out.println(Arrays.toString(a) + ":" + Arrays.toString(b));
    }

    static class A {

        protected int value;

        public A(int v) {
            setValue(v);
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            try {
                value++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }

    static class B extends A {
        public B() {
            super(5);
            setValue(getValue() - 3);
        }

        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}