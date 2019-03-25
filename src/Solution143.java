import java.util.LinkedList;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class Solution143 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用栈实现对后半截的反序
     * 1、注意奇数节点数
     * 2、注意为空的情况（dummyHead）
     * 3、不能创建新的节点
     *
     * @param head
     */
    public void reorderList(ListNode head) {

        int len = 0;
        LinkedList<ListNode> stack = new LinkedList<ListNode>();
        if (head == null || head.next == null)
            return;
        ListNode tNode = head;
        ListNode preNode = head;
        ListNode curNode = head.next;
        ListNode stackNode = null;
        while (tNode != null) {
            len++;
            stack.addLast(tNode);
            tNode = tNode.next;
        }

        for (int i = 0; i < len / 2; i++) {
            stackNode = stack.removeLast();
            stackNode.next = curNode;
            preNode.next = stackNode;
            preNode = curNode;
            curNode = curNode.next;
        }
        preNode.next = null;
    }

    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        solution143.reorderList(head);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
