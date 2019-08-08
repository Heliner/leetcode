import java.util.Arrays;
import java.util.Comparator;

public class Solution1130 {
    static class Solution {
        public int mctFromLeafValues(int[] arr) {
            int res,len;
            res =0 ; len = arr.length;
            //区间dp ..len ..start ..mid
            //len [2...arr.len];
            int[][] tp = new int[len][len];
            int[][] dp = new int[len][len];

            for(int[] d:dp){
                Arrays.fill(d,Integer.MAX_VALUE);
            }

            for(int i =0 ; i < len ; i++){
                int t = arr[i];
                for(int j = i;j < len ;j++){
                    t = Math.max(arr[j],t);
                    tp[i][j] = t;
                }
            }
            for(int t[] :tp)
                System.out.println(Arrays.toString(t));

            for(int i = 0 ; i < len ; i++){
                for(int j = 0 ; j +i <len ; j++){
                    if(i == 0)dp[j][j+i]=0;
                    else
                        for(int k = j ; k < j+i;k++){
                            dp[j][j+i] = Math.min(dp[j][j+i],tp[j][k]*tp[k+1][j+i]+dp[j][k]+dp[k+1][j+i]);
                        }
                }
            }
            return dp[0][len-1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1130.Solution();
        solution.mctFromLeafValues(new int[]{6,2,4});
    }
}
