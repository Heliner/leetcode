package today;

import java.util.Arrays;

public class Solution239 {
   static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            char[] chs = new char[10];
            Arrays.fill(chs,'c');
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(chs,0,10);
            System.out.println(stringBuilder.toString());
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution =new Solution239.Solution();
        solution.maxSlidingWindow(new int[]{1},2);
    }
}
