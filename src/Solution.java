import java.math.BigInteger;
import java.util.*;
import java.util.Scanner;

public class Solution {
    // 本题为考试单行多行输入输出规范示例，无需提交，不计分。

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (isSubsequence(i))
                res++;
        }
        System.out.println(res);
    }

    public static boolean is2018(int N) {
        char[] sn = String.valueOf(N).toCharArray();
        char[] co = new char[]{'2', '0', '1', '8'};
        int l = 0, r = 0;
        while (l < sn.length && r < co.length) {
            if (sn[l] == co[r]) {
                r++;
            }
            l++;
        }
        if (r < co.length)
            return false;
        return true;
    }

    static public boolean isSubsequence(int N) {
        String s = "2018";
        String t = String.valueOf(N);
        List<Integer>[] map = new ArrayList[27];
        int i = 0;
        for (char c : t.toCharArray()) {
            if (map[c - '0'] == null)
                map[c - '0'] = new ArrayList<>();
            map[c - '0'].add(i);
            i++;
        }

        int startIndex = 0;
        for (char ss : s.toCharArray()) {
            List<Integer> integerList = map[ss - '0'];
            if (integerList == null || integerList.size() == 0)
                return false;
            int pos = Collections.binarySearch(integerList, startIndex);
            if (pos < 0)
                pos = ~pos;
            if (pos == integerList.size())
                return false;
            startIndex = integerList.get(pos) + 1;
        }
        return true;
    }
}
