import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1021 {

    public int maxScoreSightseeingPair(int[] A) {
        int max = Integer.MIN_VALUE;
        int[] copy = Arrays.copyOf(A, A.length);
        PriorityQueue<Copule> priorityQueue = new PriorityQueue<Copule>(new CC());

        for (int i = 0; i < A.length; i++) {
            A[i]-=i;
            priorityQueue.add(new Copule(A[i] , i));
        }



        int l = 0;
        for (int i = 0; i < A.length && l < A.length; i++) {
            while (!priorityQueue.isEmpty()&&priorityQueue.peek().index<=i)
                priorityQueue.poll();
            if (!priorityQueue.isEmpty()) {
                max = Math.max(max, priorityQueue.peek().val + A[i] + 2 * i);
                System.out.println(priorityQueue.peek());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1021 solution1021 = new Solution1021();
        System.out.println(solution1021.maxScoreSightseeingPair(new int[]{1,3,5}));
        ;
    }

    class CC implements Comparator<Copule> {
        @Override
        public int compare(Copule o1, Copule o2) {
            return -(o1.val - o2.val);
        }
    }

    class Copule {
        int val;
        int index;

        public Copule(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Copule{" +
                    "val=" + val +
                    ", index=" + index +
                    '}';
        }
    }

}
