import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr;
        String[] temp = sc.nextLine().split(",");
        System.out.println(Arrays.toString(temp));
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String A;
                String B;
                A = o1 + o2;
                B = o2 + o1;
                for (int i = 0; i < A.length() ; i++) {
                    if (A.charAt(i) != B.charAt(i)) return Integer.compare(A.charAt(i), B.charAt(i));
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(temp));
        //将0补充到第一个非0后面
        String res = "";
        int i;
        for (i = 0; i < temp.length; i++) {
            if (!"0".equals(temp[i])) {
                break;
            }
        }
        res += temp[i];
        for (i = 0; i < temp.length; i++) {
            if ("0".equals(temp[i])) {
                res += temp[i];
            } else {
                break;
            }
        }
        i++;
        for (; i < temp.length; i++) {
            res += temp[i];
        }
        System.out.println(res);
    }
}