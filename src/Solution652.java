import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 */
public class Solution652 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ret = new ArrayList<>();
        if (root == null) return ret;
        postorder(root, new HashMap<>(), ret);
        return ret;
    }

    private String postorder(TreeNode root, HashMap<String, Integer> map, List<TreeNode> ret) {
        if (root == null)
            return "#";
        String serial = root.val + "," + postorder(root.left, map, ret) + "," + postorder(root.right, map, ret);
        if (map.getOrDefault(serial, 0) == 1)
            ret.add(root);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
