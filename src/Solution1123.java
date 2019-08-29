import today.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution1123 {
    static class Solution {
        TreeNode res;

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            hp(root);
            return res;
        }

        private int hp(TreeNode root) {
            if (root == null)
                return 0;

            int ll, rr;
            ll = rr = Integer.MIN_VALUE;
            ll = hp(root.left);
            rr = hp(root.right);
            if (ll == rr) {
                res = root;
                return ll + 1;
            }
            if (ll > rr) {
                hp(root.left);
            } else
                hp(root.right);
            return Math.max(ll, rr) + 1;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1123.Solution();
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        solution.lcaDeepestLeaves(root);
    }
}
