/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Solution92 {

    /**
     * 1、找出m前面的那个前驱结点，有可能为空
     * 2、反转后面的部分
     * 2.1 设置反转部分的尾节点，将反转部分与前半部分连接
     * 2.2 将后半部分连接上去
     * 3、可能头节点会反制
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public Solution143.ListNode reverseBetween(Solution143.ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;

        Solution143.ListNode tailF = null;
        int i = 1;
        Solution143.ListNode pre, cur, suffix;
        pre = null;
        cur = head;

        while (i < m && cur != null) {
            tailF = cur;
            pre = cur;
            cur = cur.next;
            i++;

        }
        System.out.println("curVal :" + cur.val);
        //开始reverse

        Solution143.ListNode nCur = cur;
        suffix = cur.next;
        Solution143.ListNode temp;
        while (i < n) {
            temp = suffix.next;
            suffix.next = nCur;
            nCur = suffix;
            suffix = temp;
            i++;
        }
        if (m == 1) {
            head = nCur;
        } else
            tailF.next = nCur;
        cur.next = suffix;
        return head;
    }


    public static void main(String[] args) {
    }
}
