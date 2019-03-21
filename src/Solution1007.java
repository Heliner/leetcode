import java.util.Arrays;

/**
 * 在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
 * <p>
 * 我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。
 * <p>
 * 返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。
 * <p>
 * 如果无法做到，返回 -1.
 * <p>
 * 输入：A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * 输出：2
 * 解释：
 * 图一表示：在我们旋转之前， A 和 B 给出的多米诺牌。
 * 如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
 */
public class Solution1007 {

    /**
     * 1、统计[1..6]出现的次数（注意不要重复统计A、B）
     * 2、如果num出现次数大于len的先求A中的次数count得到需要旋转len-count个
     * 2.1、得出B中num出现次数为count的得到需要旋转len-count个
     * 2.2、获取两个len-count的最小值
     *
     * alter : int min = Integer.MIN_VALUE;
     * @param A
     * @param B
     * @return
     */
    public int minDominoRotations(int[] A, int[] B) {
        int[] pool = new int[7];
        if (A == null || B == null || A.length != B.length)
            return -1;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            pool[A[i]]++;
            if (A[i] != B[i])
                pool[B[i]]++;
        }

        int min = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(pool));
        for (int i = 1; i < 7; i++) {
            if (pool[i] >= len) {
                int count = 0;
                for (int j = 0; j < len; j++) {
                    if (i == A[j])
                        count++;
                }

                min = Math.min(min, len - count);
                count = 0;
                for (int j = 0; j < len; j++) {
                    if (i == B[j])
                        count++;
                }

                min = Math.min(min, len - count);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        Solution1007 solution1007 = new Solution1007();
        solution1007.minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2});
    }
}