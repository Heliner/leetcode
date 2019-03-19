import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution144 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个二叉树，返回它的 前序 遍历。
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    class Solution {
        List<Integer> res = new LinkedList<Integer>();

        public List<Integer> preorder(TreeNode root) {
            if (root == null)
                return res;

            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (!stack.empty()) {
                TreeNode tNode = stack.pop();
                res.add(tNode.val);
                if (tNode.right != null)
                    stack.push(tNode.right);
                if (tNode.left != null)
                    stack.push(tNode.left);
            }
            return res;
        }
    }

    public static void main(String[] args) {
    }
}
