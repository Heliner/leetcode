import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 */
public class Solution213 {
    /**
     * 动态规划问题
     * 递归方程rob(i)=max(genertaTree(i-1),ron(i-2)+nums[i]);i>=2
     * bp问题中递归方程bp(i)=max(bp(i-1),bp(i-1))?
     *
     * @param nums [start,end]
     * @return
     */
    public int helper(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start + 1], nums[start]);
        int max = Integer.MIN_VALUE;
        for (int i = start + 2; i <= end; i++)
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        System.out.println(Arrays.toString(dp));
        return dp[end];
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];
        if(len==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(helper(nums, 0, len - 2), helper(nums, 1, len - 1));
    }

    public static void main(String[] args) {
        Solution213 solution200 = new Solution213();
        System.out.println(solution200.rob(new int[]{1, 2, 3, 1}));
        ;
    }
}
