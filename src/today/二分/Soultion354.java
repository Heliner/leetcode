package today.二分;

import java.util.Arrays;
import java.util.Comparator;

public class Soultion354 {
    static class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int res, len;
            res = -1;
            len = envelopes.length;
            int[] dp = new int[len];
            Arrays.fill(dp,1);
//排序
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (0 != Integer.compare(o1[0], o2[0]))
                        return Integer.compare(o1[0], o2[0]);
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i ; j++) {
                    if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
    }

}
