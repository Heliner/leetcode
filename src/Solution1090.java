import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solution1090 {
    static class Solution {
        int n, sum;

        //greedy
        public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
            //排序，选最大的
            n = values.length;
            sum = 0;

            ArrayList<Node> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                Node n = new Node(values[i], labels[i]);
                list.add(n);
            }
            Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return -(Integer.compare(o1.val, o2.val));
                }
            });

            for (Node n : list) {
                if (num_wanted == 0)
                    break;
                if (map.getOrDefault(n.lab, 0) < use_limit) {
                    num_wanted--;
                    sum += n.val;
                    map.put(n.lab, map.getOrDefault(n.lab, 0) + 1);
                }
            }
            return sum;
        }

        static class Node {
            public int val;
            public int lab;

            public Node(int val, int lab) {
                this.val = val;
                this.lab = lab;
            }
        }
    }

}
