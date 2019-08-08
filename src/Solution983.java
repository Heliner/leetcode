import java.util.Arrays;

public class Solution983 {
    static class Solution {
        int[] dp;
        int n;
        int[] time = {1, 7, 30};
        boolean[] has;

        public int mincostTickets(int[] days, int[] costs) {
            this.n = days.length;
            this.dp = new int[400];//赋值为最大值
            this.has = new boolean[400];
            for(int day = days[n-1] ; day>=1 ; day--)
                dp[day] = Integer.MAX_VALUE;
            for (int d : days) {
                has[d] = true;
            }
            for (int i = days[n - 1]; i >= 1; i--) {
                //如果这天在日历中
                if (has[i]){
                    int tt = Integer.MAX_VALUE;
                    for (int d = 0; d < 3; d++) {
                        int to = i + time[d];
                        tt = Math.min(dp[to] + costs[d],tt);
                    }
                    dp[i] = tt;
                }
                //否者直接用前面的值
                else
                    dp[i] = Math.min(dp[i + 1], dp[i]);
            }
            System.out.println(Arrays.toString(dp));
            return dp[1];

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution983.Solution();
        solution.mincostTickets(new int[]{1,2,3,4,6,8,9,10,13,14,16,17,19,21,24,26,27,28,29}, new int[]{3,14,50});
    }
}
