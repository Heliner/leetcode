public class Kadane {
    /*def max_subarray(A):
    max_ending_here = max_so_far = A[0]
            for x in A[1:]:
    max_ending_here = max(x, max_ending_here + x)
    max_so_far = max(max_so_far, max_ending_here)
    return max_so_far*/

    int maxSubarray(int[] A) {
        int max_ending_here = 0, max_so_far = 0;
        for (int x : A) {
            max_ending_here = Math.max(x, max_ending_here + x);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        Kadane kadane = new Kadane();
        System.out.println(kadane.maxSubarray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
