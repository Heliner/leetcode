import java.util.Arrays;

public class Solution1155 {

    static class Solution {
        int m = (int) (Math.pow(10, 9) + 7);
        int[][] dp;

        public int numRollsToTarget(int d, int f, int target) {
            dp = new int[d + 1][target + 1];
            for (int[] dd : dp) Arrays.fill(dd, -1);
            return hp(d, f, target);
        }

        int hp(int d, int f, int target) {
            if (target == 0 && d == 0)
                return 1;
            if (d == 0)
                return 0;
            if (dp[d][target] != -1) return dp[d][target];
            int rse = 0;
            for (int i = f; i >= 1; i--) {
                int left = target - i;
                if (left < 0)
                    continue;
                if (left > (d - 1) * f)
                    break;
                rse += hp(d - 1, f, left);
                rse %= m;
            }
            dp[d][target] = rse;
            return rse;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution1155.Solution();
        System.out.println(solution.numRollsToTarget(30, 30, 500));
    }
}
