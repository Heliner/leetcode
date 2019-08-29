import java.util.Arrays;

public class Solution1051 {
    static class Solution {
        public int heightChecker(int[] heights) {
            int n = heights.length;
            int[] copy = new int[n];
            System.arraycopy(heights, 0, copy, 0, n);
            Arrays.sort(copy);
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (copy[i] != heights[i]) {
                    res++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1051.Solution();
    }
}