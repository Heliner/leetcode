import java.util.Arrays;

public class Solution1024 {

        static class Solution {
            int[] dp;
            int[][] clips;
            int n;
            int ml;

            public int videoStitching(int[][] clips, int T) {
                this.n = clips.length;
                this.ml = T - 1;
                dp = new int[T + 1];
                Arrays.fill(dp, -1);
                dp[0] = 1;
                this.clips = clips;
                if(T==0)
                    return 0;
                mi(T - 1);
                System.out.println(Arrays.toString(dp));

                return dp[T - 1];
            }

            private int mi(int T) {
                if (T < 0)
                    return Integer.MAX_VALUE;
                System.out.println(T);

                if (dp[T] != -1)
                    return dp[T];

                int t = Integer.MAX_VALUE;
                for (int[] cl : clips) {
                    if (T >= cl[0] && T <= cl[1]) {
                        //next>=0也需要控制
                        for (int next = T - 1; next >= cl[0] && next >= 0; next--) {
                            t = Math.min(t, mi(next));
                        }
                    }
                }
                dp[T] = t == Integer.MAX_VALUE ? -1 : t + 1;
                return dp[T];
            }

        }

    public static void main(String[] args) {
        Solution solution = new Solution1024.Solution();
        System.out.println(solution.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));
    }
}
