import java.util.Arrays;
import java.util.LinkedList;

public class Solution918 {
    public int maxSubarraySumCircular(int[] A) {
        LinkedList<Integer> windows = new LinkedList<Integer>();
        int[] B = new int[A.length * 2];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        for (int i = A.length; i < A.length * 2; i++) {
            B[i] = A[i - A.length];
        }
        int maxSize = A.length-1;
        int len = A.length;
        A = B;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (windows.size() > maxSize) {
                sum -= windows.removeFirst();
            }
            if (sum < 0) {
                windows.clear();
                sum = 0;
            }
            sum += A[i];
            windows.addLast(A[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution918 solution918 = new Solution918();
        System.out.println(solution918.maxSubarraySumCircular(new int[]{5,-3,5}));
    }
}
