public class Solution1171 {
    static class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            ListNode dh = new ListNode(0);
            dh.next = head;
            hp(dh);
            return dh.next;
        }

        private void hp(ListNode dh) {
            if (dh.next == null)
                return;
            int sum = 0;
            ListNode node0 = null;
            ListNode cur = dh.next;
            while (cur != null) {
                sum += cur.val;
                if (sum == 0) {
                    node0 = cur;
                }
                cur = cur.next;
            }
            if (null != node0) {
                dh.next = node0.next;
            }
            hp(dh.next);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1171.Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(-3);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;node3.next= node4;node4.next=node5;
        solution.removeZeroSumSublists(node1);

    }
}
