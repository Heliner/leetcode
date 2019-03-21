public class Solution1006 {
    public int clumsy(int N) {
        int index = N;
        int i = 0;
        long sum = 0;
        while (i < N) {
            if (i % 4== 0) {

                long r = sum3(N - i);
                if (i == 0)
                    sum += r;
                else
                    sum -= r;
                i += 3;
            } else {
                sum += N - i;
                i++;
            }
        }
        return (int) sum;
    }

    int sum3(int l) {
        int[] res = new int[2];
        if (l - 3 >= 0) {
            res[0] = l * (l - 1) / (l - 2);
        } else if (l >= 2) {
            res[0] = l * (l - 1);
        } else if (l >= 1) {
            res[0] = l;
        } else {
            res[0] = 0;
        }
        return res[0];

    }

    public static void main(String[] args) {
    Solution1006 solution1006 = new Solution1006();
        System.out.println(    solution1006.clumsy(5));

    }
}
