import java.util.Arrays;

public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int len = 0;
        len = nums.length;
        if (0 == len)
            return 0;
        Arrays.sort(nums);
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int[] tRes = allNum(nums, j);
                int curVals = tRes[0];
                int val1 = (j - 2 >= 0 ? dp[i - 1][j - 2] : 0) + (j + 2 < i ? dp[i - 1][j + 2] : 0) + curVals;
                int val2 = (j - 1 >= 0 ? dp[i - 1][j - 1] : 0) + (j + 1 < i ? dp[i - 1][j + 1] : 0);
                dp[i][j] = Math.max(val1, val2);
                j = tRes[1];
            }
        }
        for (int[] d : dp)
            System.out.println(Arrays.toString(d));
        return dp[len - 1][len - 1];
    }

    private int[] allNum(int[] nums, int j) {
        int n = nums[j];
        int[] res = new int[2];
        int i;
        for (i = j; i < nums.length; i++) {
            if (n != nums[i])
                break;
            res[0] += nums[i];
        }
        res[1] = i;
        return res;
    }

    public static void main(String[] args) {
        Solution740 solution670 = new Solution740();
        System.out.println(solution670.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
