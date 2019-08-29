import today.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1110 {
    static class Solution {
        boolean[] toDel = new boolean[1010];
        List<TreeNode> res = new ArrayList<>();

        boolean dfs(TreeNode cur, boolean added) {
            if(cur == null)
                return false;
            boolean re = false;
            if(toDel[cur.val]){
                dfs(cur.left,true);
                dfs(cur.right,true);
                re = true;
                return re;
            }else {
                res.add(cur);
                if (dfs(cur.left, false)) {
                    cur.left = null;
                }
                if (dfs(cur.right, false))
                    cur.right = null;
                return false;
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
