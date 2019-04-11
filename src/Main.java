import java.util.Scanner;

public class Main {
    static class Node {
        String val;
        Node next;

        public Node(String val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node h = new Node("");
        Node pre, cur;
        pre = h;

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String line = in.nextLine();
            String[] ls = line.split(",");
            for (String s : ls) {
                cur = new Node(s);
                pre.next = cur;
                pre = cur;

            }
        }
        System.out.println(hasCircle(h.next));
    }

    public static boolean hasCircle(Node head) {
        if (head == null || head.next == null)
            return false;
        Node slow = null;
        Node fast = null;
        slow = fast = head;
        fast = head.next.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow.val.equals(fast.val))
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
