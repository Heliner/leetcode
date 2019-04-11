import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            nums[num - 1] *= -1;
        }
        int i =0;
        for (int num : nums) {
            if (num < 0) {
                res.add(i);
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution448 solution448 = new Solution448();
        System.out.println(        solution448.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));        ;
    }
}
