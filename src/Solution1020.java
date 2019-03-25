public class Solution1020 {
    public boolean canThreePartsEqualSum(int[] A) {
        int len = A.length;
        int sum = 0;
        for (int a : A)
            sum += a;
        if (sum % 3 != 0)
            return false;
        int target = sum / 3;
        return ctpes(A, 0, target, 3) == Integer.MAX_VALUE;
    }

    int ctpes(int[] A, int start, int target, int time) {
        if (time == 0 && start == A.length)
            return Integer.MAX_VALUE;
        int sum = 0;
        for (int i = start; i < A.length; i++) {
            sum += A[i];
            if (sum == target) {
                if (ctpes(A, i + 1, target, time - 1) == Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1020 solution1020 = new Solution1020();
        System.out.println(solution1020.canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1})
        );
    }
}
