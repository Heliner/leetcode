package today;

import java.util.Arrays;

public class Solution76 {
    static class Solution {
        public String minWindow(String s, String t) {
            if (t.length() > s.length())
                return "";
            int req, l, len;
            String res = null;
            char[] pattern, chs;
            boolean[] exist;
            int[] num;
            l = 0;
            req = 0;
            len = s.length();
            num = new int[255];
            exist = new boolean[255];
            pattern = t.toCharArray();
            chs = s.toCharArray();

            Arrays.fill(exist, false);
            Arrays.fill(num, 0);
            for (int i = 0; i < pattern.length; i++) {
                num[pattern[i]]++;
                exist[pattern[i]] = true;
                req++;
            }

            for (int r = 0; r < len; r++) {
//1->0 change
                if (--num[chs[r]] >= 0 && exist[chs[r]]) {
                    req--;
                }
                while (req == 0 && l < len) {
                    if (res == null || r - l + 1 < res.length()) {
                        res = new String(chs, l, r - l + 1);
                    }
                    if (num[chs[l]] >= 0 && exist[chs[l]])
                        req++;
                    num[chs[l++]]++;
                }

            }
            if (res == null)
                res = "";
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution76.Solution();
        System.out.println(solution.minWindow("BANC", "BAC"));
    }
}
