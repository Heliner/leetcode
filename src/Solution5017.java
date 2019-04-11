import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * <p>
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 以 10^9 + 7 为模，返回这些数字之和。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 2
 */
public class Solution5017 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * dfs
     * 1、需要记录每层的值
     * 2、
     * waring：需要取模
     *
     * @param root
     * @return
     */
    LinkedList<Integer> list = new LinkedList();

    public int sumRootToLeaf(TreeNode root) {
        if(root==null)
            return 0;
        int res =0 ;
        dfs(root,0);
        for(int i:list){
            res= (int) ((res+i)%(Math.pow(10,9)+7));
        }
        return res;
    }

    public void dfs(TreeNode root, int res) {
        if(root.left!=null)dfs(root.left, (int) ((res*2+root.val)%(Math.pow(10,9)+7)));
        if(root.right!=null) {
            dfs(root.right,(int)((res*2+root.val)%(Math.pow(10,9)+7)));
        }
        if(root.left==null&&root.right==null) {
                    list.add((int)((res * 2 + root.val) % (Math.pow(10, 9) + 7)));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left   = new TreeNode(0);
        TreeNode right = new TreeNode(1);
        root.left=left;
        root.right=right;
        Solution5017 solution5017 = new Solution5017();
        System.out.println(        solution5017.sumRootToLeaf(root)
        );        ;
    }
}
