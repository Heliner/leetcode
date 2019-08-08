import java.util.Arrays;

public class Solution1043 {

    static class Solution {
        int[] dp;
        int n, K;
        int[] ar;

        public int maxSumAfterPartitioning(int[] A, int K) {
            n = A.length;
            dp = new int[n];
            Arrays.fill(dp, -1);
            ar = A;
            this.K = K;
            int res = 0;
            res = help(n - 1);
            System.out.println(Arrays.toString(dp));
            return res;
        }

        int help(int e) {
            //反向
            if (e < 0)
                return 0;
            if (dp[e] != -1)
                return dp[e];
            int t = ar[e];
            int max = ar[e];
            for (int i = 1; i <= K; i++) {
                if(e-i < -1)
                    break;
                t = Math.max(t, help(e - i) + max * i);
                if (e - i < 0)
                    continue;
                max = Math.max(max, ar[e - i]);
            }
            return dp[e] = t;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1043.Solution();
        System.out.println(solution.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
    }
}
