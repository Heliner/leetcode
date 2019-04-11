import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * <p>
 * 找到所有出现两次的元素。
 * <p>
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * <p>
 * 示例：
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [2,3]
 */
public class Solution442 {
    /**
     * 因为出现两次和出现三次会区别就像出现两次和出现一次的一样，自不过方法有点不同
     * 1、出现一次和出现两次需要一次遍历
     * 1.1 如果当前数字出现过，那么当前为肯定出现了两次，因为你这次能看到就说明这个数又出现了，那么它一定出现两次
     * 2、出现两次和三次不能直接按照类似的方法继续进行判断
     * 2.1 第二次访问是为了找出负和正
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } else
                res.add(num);
        }
        return res;
    }
}