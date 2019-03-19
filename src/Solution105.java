public class Solution105 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        /**
         * 根据一棵树的中序遍历与后序遍历构造二叉树。
         * 注意:
         * 你可以假设树中没有重复的元素。
         *
         * @param inorder
         * @param preorder
         * @return
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return bt(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
        }

        public TreeNode bt(int[] io, int ios, int ioe, int[] po, int pos, int poe) {
            //从后序树中获取中间节点

            //确定左中序树的长度，来分割右中序树
            if (ios > ioe)
                return null;

            int poeVal = po[pos];
            int index = 0;
            for (int i = ios; i <= ioe; i++) {
                if (poeVal == io[i])
                    index = i;
            }
            int leftLen = index - ios;
            TreeNode cur = new TreeNode(poeVal);
            /*构建左子树*/
            cur.left = bt(io, ios, ios + leftLen - 1, po, pos + 1, pos + leftLen);
            /*构建右子树*/
            cur.right = bt(io, ios + leftLen + 1, ioe, po, pos + leftLen + 1, poe);

            return cur;
        }
    }
}
