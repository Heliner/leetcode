import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1054 {
    static class Solution {
        //
        int[] tn;

        public int[] rearrangeBarcodes(int[] barcodes) {
            int n = barcodes.length;
            tn = new int[10001];
            PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return -Integer.compare(o1.count, o2.count);
                }
            });
            for (int b : barcodes) {
                tn[b]++;
            }
            for (int i = 1; i < 10001; i++) {
                if (tn[i] != 0) {
                    Node node = new Node(i, tn[i]);
                    queue.add(node);
                }
            }

            int[] res = new int[n];
            boolean success = true;
            int l = 0;
            while (!queue.isEmpty()) {
                if (l == 0 || queue.peek().val != res[l - 1]) {
                    Node max = queue.poll();
                    res[l++] = max.val;
                    max.count--;
                    if (max.count > 0)
                        queue.add(max);
                } else {
                    if (queue.size() == 1) {
                        success = false;
                        break;
                    }
                    Node f = queue.poll();
                    Node s = queue.poll();
                    res[l++] = s.val;
                    s.count--;
                    if (s.count > 0)
                        queue.add(s);
                    queue.add(f);
                }
            }
            if (!success || (n >= 2 && res[n - 1] == res[n - 2]))
                return barcodes;
            return res;

        }

        class Node {
            int val;
            int count;

            public Node(int val, int count) {
                this.val = val;
                this.count = count;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1054.Solution();
        solution.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3});
    }
}