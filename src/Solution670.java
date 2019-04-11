import java.util.Arrays;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 */
public class Solution670 {
    /**
     * 典型的dp问题
     * 1、从左向右查找找到当前位后面的比他大的最大的值（如果存在相同的数的话就取最右边的）
     * 2、
     *
     * @param num 输入值
     * @return 返回值
     */
    public int maximumSwap(int num) {
        String sn = String.valueOf(num);
        char[] chs = sn.toCharArray();
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int[] dp = new int[chs.length];
        Arrays.fill(dp, -1);
        for (int i = dp.length - 1; i >= 0; i--) {
            if (chs[i] - '0' < max) {
                dp[i] = maxIndex;
            }
            if (chs[i] - '0' > max) {
                maxIndex = i;
                max = chs[i] - '0';
            }
        }
        System.out.println("dp:" + Arrays.toString(dp));
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != -1) {
                char t = chs[i];
                chs[i] = chs[dp[i]];
                chs[dp[i]] = t;
                break;
            }
        }
        return Integer.valueOf(String.valueOf(chs));
    }

    public static void main(String[] args) {
        Solution670 solution670 = new Solution670();
        System.out.println(solution670.maximumSwap(0));
    }
}
