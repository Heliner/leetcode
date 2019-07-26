package today;

import java.util.LinkedList;

public class Solution654 {
    static
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            LinkedList<TreeNode> stack = new LinkedList<>();

            for (int n : nums) {
                TreeNode cur = new TreeNode(n);
                while (!stack.isEmpty() && stack.peek().val <= cur.val) {
                    cur.left = stack.pop();
                }
                if (!stack.isEmpty() /*&& stack.peek().val < cur.val*/) {
                    stack.peek().right = cur;
                }
                stack.push(cur);
            }
            while (stack.size() > 1) {
                stack.pop();
            }
            return stack.peek();

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution654.Solution();
        TreeNode res = null;
        res = solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 4, 7});
        System.out.println(res);
    }
}
