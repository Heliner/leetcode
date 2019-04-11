import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 * <p>
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 * <p>
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 * <p>
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 */
public class Solution1030 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 1、使用优先队列
     * 2、将所有元素放进去后并排序
     * 3、重新放到数组中
     * 4、遍历数组
     *
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        if (head == null)
            return new int[0];
        ArrayList<Integer> linkedList = new ArrayList<Integer>();
        while (head != null) {
            linkedList.add(head.val);
            head = head.next;
        }
        int[] res = new int[linkedList.size()];
        int p = 0;
        for (int i = 0; i < linkedList.size(); i++) {
            for (int j = i + 1; j < linkedList.size(); j++) {
                if (linkedList.get(i) < linkedList.get(j)) {
                    res[i] = linkedList.get(j);
                    break;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution1030 solution1030 = new Solution1030();

    }
}
