import today.TreeNode;

import java.util.HashMap;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 */
public class Solution337 {
    /**
     * 动态规划问题
     * 递归方程
     * rob(root) = max(root.val+rob(root.left.children)+rob(root.right,children,rob(left)+rob(right));
     * rob(root.left.children) = rob(root.left.left)+rob(root.left.right);
     * 总结条件
     * if(root==nul)
     * return 0 ;
     *
     * @param root 根
     * @return
     */
    HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        int val1 = root.val + (root.left == null ? 0 : (rob(root.left.left) + rob(root.left.right))) + (root.right == null ? 0 : (rob(root.right.left) + rob(root.right.right)));
        int val2 = rob(root.left) + rob(root.right);
        int res = Math.max(val1, val2);
        memo.put(root, res);
        return res;
    }

    /*   *//*后序遍历*//*
    public int rob(Solution5017.today.TreeNode root) {
        if (root == null)
            return 0;
        postOrder(root);
        return root.val;
    }

    private void postOrder(Solution5017.today.TreeNode root) {
        if (root == null)
            return;
        *//*修改左侧的值*//*
        postOrder(root.left);
        *//*修改右侧的值*//*
        postOrder(root.right);
        int val1 = root.val;
        int val2 = 0;
        if (root.left != null) {
            val2 += root.left.val;
            if (root.left.left != null)
                val1 += root.left.left.val;
            if (root.left.right != null)
                val1 += root.left.right.val;
        }
        if (root.right != null) {
            val2 += root.right.val;
            if (root.right.left != null)
                val1 += root.right.left.val;
            if (root.right.right != null)
                val1 += root.right.right.val;
        }
        *//*返回最后的值*//*
        root.val = Math.max(val1, val2);
    }
*/
    public static void main(String[] args) {
        Solution337 solution200 = new Solution337();
    }
}
