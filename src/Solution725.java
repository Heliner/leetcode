import java.util.List;

/**
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * <p>
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * <p>
 * 返回一个符合上述规则的链表的列表。
 * <p>
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 */
public class Solution725 {
    /**
     * 类型：根本就不是链表
     * 就只是取余
     *
     * @param root 根节点
     * @param k    3，2
     * @return 返回后的值为链表，应该注意设置值。
     */
    public Solution143.ListNode[] splitListToParts(Solution143.ListNode root, int k) {
        Solution143.ListNode cur = root;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int left = len % k;
        int some = len / k;
        System.out.println("l+" + left + ";;;some;" + some);
        Solution143.ListNode[] res = new Solution143.ListNode[k];

        cur = root;
        for (int i = 0; i < k; i++) {
            res[i] = cur;
            cur = help(cur, left > 0 ? some + 1 : some);


            left--;
        }
        return res;
    }

    /**
     * 取出k个值
     *
     * @param root
     * @param k
     * @return
     */
    public Solution143.ListNode help(Solution143.ListNode root, int k) {
        if (k == 0)
            return null;
        Solution143.ListNode res = root;

        while (k > 1) {
            root = root.next;
            k--;
        }
        res = root.next;
        root.next = null;
        return res;
    }

    public static void main(String[] args) {
    }
}
