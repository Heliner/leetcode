import java.util.Arrays;

public class Solution931 {
    /**
     * 使用动态规划，
     * 边界值dp[0] = A[0];
     * 结果的值应该在最后一个DP中去遍历
     *
     * @param A
     * @return
     */
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0)
            return 0;
        int[][] dp = new int[A.length][A[0].length];
        dp[0] = Arrays.copyOf(A[0], A[0].length);

        for (int i = 1; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++) {
                dp[i][j] = Math.min(j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1], Math.min(dp[i - 1][j], j == A[0].length - 1 ? Integer.MAX_VALUE : dp[i - 1][j + 1])) + A[i][j];
            }
        System.out.println(Arrays.toString(dp[A.length - 1]));
        return Arrays.stream(dp[A.length - 1]).min().orElse(0);
    }

    public static void main(String[] args) {
        Solution931 solution931 = new Solution931();
        System.out.println(solution931.minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
