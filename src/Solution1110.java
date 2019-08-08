import today.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1110 {
    static class Solution {
        boolean[] toDel = new boolean[1010];
        List<TreeNode> res = new ArrayList<>();

        void dfs(TreeNode cur, boolean added) {
            if (cur == null) return;
            if (toDel[cur.val]) {
                dfs(cur.left, true);
                dfs(cur.right, true);
                return;
            } else {
                if (added) {
                    res.add(cur);
                }
                if (cur.left != null) {
                    dfs(cur.left, false);
                    if (toDel[cur.left.val]) {
                        cur.left = null;
                    }
                }
                if (cur.right != null) {
                    dfs(cur.right, false);
                    if (toDel[cur.right.val]) {
                        cur.right = null;
                    }
                }
            }
        }

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            for (int i = 0; i < 1010; i++) toDel[i] = false;
            for (int d : to_delete) toDel[d] = true;
            dfs(root, true);
            return res;
        }
    }
}
