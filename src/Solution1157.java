import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution1157 {
    static class MajorityChecker {
        TreeMap<Integer, Node> map = new TreeMap<>();

        public MajorityChecker(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if(!map.containsKey(arr[i])){
                    map.put(arr[i], new Node(1,i));
                }else{
                    Node old = map.get(arr[i]);
                    old.fre++;
                    map.put(arr[i], old);
                }
            }

        }

        public int query(int left, int right, int threshold) {
            int rse = 0;
            SortedMap<Integer, Node> tm = map.tailMap(threshold);
            for (Map.Entry<Integer, Node> t : tm.entrySet()) {
                if (t.getValue().ind >= left && t.getValue().ind <= right) {
                    rse+=t.getValue().fre;
                }
            }
            return rse;
        }

        class Node {
            int fre;
            int ind;

            public Node(int fre, int ind) {
                this.fre = fre;
                this.ind = ind;
            }

        }
    }

    public static void main(String[] args) {
        MajorityChecker majorityChecker = new MajorityChecker(new int[]{1, 1, 2, 2, 1, 1});
        System.out.println(majorityChecker.query(0, 5, 4)
        );        // 返回 1
        System.out.println(majorityChecker.query(0, 3, 3)
        );        // 返回 -1
        System.out.println(majorityChecker.query(2, 3, 2));        // 返回 2
    }
/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */

}