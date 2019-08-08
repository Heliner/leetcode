import java.util.Stack;

public class Solution84 {

    static  class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack< Integer > stack = new Stack < > ();
            stack.push(-1);
            int maxarea = 0;
            for (int i = 0; i < heights.length; ++i) {
                while (stack.peek() != -1 && heights[stack.peek()] > heights[i])
                    maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
                System.out.println(maxarea);
                stack.push(i);
            }
            while (stack.peek() != -1)
                maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
            return maxarea;
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution84.Solution();
        System.out.println(solution.largestRectangleArea(new int[]{3,2,2,1,3,2,2}));
    }
}
