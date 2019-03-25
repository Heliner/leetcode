public class Solution1022 {
    long[] N = new long[]{1, 11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111, 1111111111};

    public int smallestRepunitDivByK(int K) {
        for (int i = 0; i < N.length; i++) {
            if (N[i] % K == 0)
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1022 solution1022 = new Solution1022();
        System.out.println(solution1022.smallestRepunitDivByK(1));
    }
}
