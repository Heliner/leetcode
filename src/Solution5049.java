import today.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution5049 {
    static class Solution {
        public int maxLevelSum(TreeNode root) {
            //bfs
            Queue<Pair> queue = new LinkedList();
            if (root != null)
                queue.add(new Pair(root, 1));
            int max, predep, temp, res;
            temp = 0;
            max = Integer.MIN_VALUE;
            predep = 1;
            temp = 0;
            res = 1;

            while (!queue.isEmpty()) {
                Pair p = queue.poll();
                while (p != null && p.dep == predep) {
                    if (p.node.left != null)
                        queue.add(new Pair(p.node.left, p.dep + 1));
                    if (p.node.right != null)
                        queue.add(new Pair(p.node.right, p.dep + 1));
                    temp += p.node.val;
                    if (temp > max) {
                        max = temp;
                        res = p.dep;
                        System.out.println(temp + ":" + res);
                    }
                    if (!queue.isEmpty())
                        p = queue.poll();
                    else p = null;
                }
                if (p != null && p.node != null) {
                    temp = p.node.val;
                    predep = p.dep;
                    if (temp > max) {
                        max = temp;
                        res = p.dep;
                        System.out.println(temp + ":" + res);
                    }
                }
            }
            return res;
        }

        static class Pair {
            TreeNode node;
            int dep;

            public Pair(TreeNode node, int dep) {
                this.node = node;
                this.dep = dep;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution5049.Solution();
        TreeNode root = new TreeNode(989);
        TreeNode right = new TreeNode(10250);
        root.right = right;
        solution.maxLevelSum(root);
    }
}
