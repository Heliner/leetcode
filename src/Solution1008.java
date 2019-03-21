public class Solution1008 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 将一个先序遍历的数组构建为二叉查找树
     * 1、[8,5,1,7,10,12]
     * 2、直接找到比第一个节点大的节点，这个节点就是右子树的根节点，如果越界，那就不处理
     * 3、注意index的初值为le+1,如果为ls的话会无限循环
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null)
            return null;
        return bfp(preorder, 0, preorder.length - 1);
    }

    TreeNode bfp(int[] preorder, int ls, int le) {
        if (ls > le)
            return null;
        int cur = preorder[ls];
        TreeNode curNode = new TreeNode(cur);
        int index = le + 1;
        for (int i = ls + 1; i <= le; i++) {
            if (preorder[i] > cur) {
                index = i;
                break;
            }
        }
        curNode.left = bfp(preorder, ls + 1, index - 1);
        curNode.right = index > le ? null : bfp(preorder, index, le);
        return curNode;
    }
}
