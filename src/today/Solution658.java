package today;

import java.util.ArrayList;
import java.util.List;

public class Solution658 {
    static class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            //滑动窗口
            int min, len, sum, start;
            List<Integer> res;
            min = 0;
            len = arr.length;
            start = 0;
            res = new ArrayList();
            sum = 0;

            for (int i = 0; i < k && i < len; i++) {
                sum += Math.abs(arr[i] - x);
            }
            min = sum;

            for (int i = k; i < len; i++) {
                sum += Math.abs(arr[i] - x);
                sum -= Math.abs(arr[i - k] - x);
                if (sum < min) {
                    min = sum;
                    start = i - k + 1;
                }
            }

            for (int i = start; i < k + start && i < len; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution658.Solution();
        System.out.println(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 2, 3));
    }
}
