
public class Solution416 {
    /**
     *
     */
    static class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int n : nums)
                sum += n;
            if ((sum & 0x01) == 0x01)
                return false;
            int len = nums.length;
            sum /= 2;
            int C = sum;
            boolean[] dp = new boolean[sum + 1];
            System.out.println(sum);
            for (int i = 0; i <= C; i++)
                dp[i] = (nums[0] == i);


            for (int i = 1; i < len - 1; i++)
                for (int j = C; j >= nums[i]; j--) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                    System.out.println("c-nums[len-1]:" + (C - nums[i]));
                }
            dp[C] = dp[C] || ((C - nums[len - 1] >= 0) && dp[C - nums[len - 1]]);

            return dp[C];
        }
    }

    public static void main(String[] args) {
        Solution416.Solution solution = new Solution416.Solution();
        System.out.println(solution.canPartition(new int[]{1, 1}));
    }
}
