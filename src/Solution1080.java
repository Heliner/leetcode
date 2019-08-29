import today.TreeNode;

public class Solution1080 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        int limit;

        public TreeNode sufficientSubset(TreeNode root, int limit) {
            this.limit = limit;
            TreeNode dm = new TreeNode(0);
            dm.left = root;
            hp(dm, 0);
            return dm.left;
        }

        private int hp(TreeNode root, int parentsum) {
            if (root == null)
                return 0;
            int res = Integer.MIN_VALUE;
            int leftre, rire;
            int ll, rr;
            ll = rr = leftre = rire = res = Integer.MIN_VALUE;
            if (root.left == null && root.right == null)
                return root.val;
            if (root.left != null) {
                ll = hp(root.left, parentsum + root.val) + root.val;
                leftre = ll + parentsum;
                if (leftre < limit)
                    root.left = null;

            }
            if (root.right != null) {
                rr = hp(root.right, parentsum + root.val) + root.val;
                rire = rr + parentsum;
                if (rire < limit)
                    root.right = null;
            }

            res = Math.max(ll, rr);
            if (res != Integer.MIN_VALUE) {
                return res;
            } else
                return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1080.Solution();
        TreeNode root1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(-3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(-5);
        root1.left = n2;
        root1.right = n3;
        n2.left = n5;
        n3.left = n4;

        solution.sufficientSubset(root1, -1);
    }
}