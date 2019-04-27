import java.util.Arrays;

public class Solution688 {
    public double knightProbability(int N, int K, int r, int c) {
        int size = (int) Math.pow(N, 2);
        int[][] direct = {{-2, -1}, {-2, +1},{-1, -2}, {-1, +2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};
        double[][][] dp = new double[K+1][N][N];
        dp[0][r][c] = 1;
        for (int i = 1; i <= K; i++)
            for (int y = 0; y < N; y++)
                for (int x = 0; x < N; x++) {
                    int tx = x;
                    int ty = y;
                    for (int[] xy : direct) {
                        tx = x + xy[0];
                        ty = y + xy[1];
                        if (tx < 0 || tx >= N || ty < 0 || ty >= N)
                            continue;
                        dp[i][ty][tx] += dp[i - 1][y][x] ;
                    }
                }
        double sum = 0;
        for (int y = 0; y < N; y++)
            for (int x = 0; x < N; x++) {
                sum += dp[K ][y][x];
            }
        return (sum*1.0) / Math.pow(8,K);
    }

    public static void main(String[] args) {
        Solution688 solution688 = new Solution688();
        System.out.println(        solution688.knightProbability(8,30,6,4));    }
}
