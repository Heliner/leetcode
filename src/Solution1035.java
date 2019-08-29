public class Solution1035 {

    static class Solution {
        public int maxUncrossedLines(int[] A, int[] B) {
            int len1, len2;
            len1 = A.length;
            len2 = B.length;
            int[][] dp = new int[len1 + 100][len2 + 100];
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    dp[i + 1][j + 1] = Math.max((A[i]==B[j])?dp[i][j] + 1:0, Math.max(dp[i][j + 1], dp[i + 1][j]));
                }
            }
            return dp[len1][len2];
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution1035.Solution();
        System.out.println(solution.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
    }
}
