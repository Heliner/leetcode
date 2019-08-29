import today.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1161 {
    static class Solution {
        public int maxLevelSum(TreeNode root) {
            int max =  Integer.MIN_VALUE;
            int res = -1,level = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int sz = queue.size();int ts = 0;level++;
                while(sz > 0){
                    TreeNode cur = queue.poll();
                    if(cur.left!=null) queue.add(cur.left);
                    if(cur.right!=null) queue.add(cur.right);
                    ts +=cur.val;
                    sz--;
                }

                if(ts > max )
                {
                    max = ts;
                    res = level;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }

}