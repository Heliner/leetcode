import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int main(Map<Integer, Integer> map, int[] memo) {

        return 0;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int N = in.nextInt();
        int[] memo = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            memo[i] = in.nextInt();
            map.put(memo[i], map.getOrDefault(memo[i], 0) + 1);
        }
        Set<Integer> keys = map.keySet();
        int min = Integer.MAX_VALUE;
        for (Integer i : keys) {
            min = Math.min(min, map.get(i));
        }
        boolean flag = true;
        res = 0;
        if (min <= 1)
            flag = false;
        else
            for (Integer i : keys) {
                int num = map.get(i);
                if (!(num % min == 0)) {
                    flag = false;
                    break;
                }
                res += num / min;
            }
        res = flag ? res : 0;
        System.out.println(String.valueOf(res));
    }
}
