import java.util.Arrays;

public class Solution151 {
    public String reverseWords(String s) {
        String[] ss = s.split("[\\s]+");
        for (int i = 0; i < ss.length / 2; i++) {
            String t = "";
            t = ss[i];
            ss[i] = ss[ss.length - i - 1];
            ss[ss.length - i - 1] = t;
        }
        String res = "";
        int i = 0;
        for (; i < ss.length - 1; i++) {
            res += ss[i] + " ";
        }
        System.out.println(Arrays.toString(ss));
        if (ss.length != 0)
            res += ss[i];
        return res;
    }

    public static void main(String[] args) {
        String s =new String("  ");
        System.out.println(s.trim());
    }
}
