package today;

public class Solution978 {
    static class Solution {
        public int maxTurbulenceSize(int[] A) {
            if (A.length == 0 || A.length == 1)
                return A.length;
            int len = A.length, r = 0, l = 0, res = 0;
            int[] comp = new int[len - 1];
            for (int i = 0; i < len - 1; i++) {
                if (A[i] > A[i + 1])
                    comp[i] = 1;
                else if (A[i] == A[i + 1])
                    comp[i] = 0;
                else
                    comp[i] = -1;
            }
            int temp = 1;
            if (comp[0] == 1 || comp[0] == -1)
                temp = 2;
            for (int i = 1; i < len - 1; i++) {
                if (comp[i] == 0)
                    temp = 1;
                else if (comp[i] == 1 && comp[i - 1] == -1 || comp[i] == -1 && comp[i - 1] == 1) {
                    temp += 1;
                } else if (comp[i] == 1 || comp[i] == -1)
                    temp = 2;
                res = Math.max(res, temp);
            }
            res = Math.max(res, temp);
            return res;
        }

    }

    public static void main(String[] args) {
        Solution978.Solution solution978 = new Solution978.Solution();
        System.out.println(solution978.maxTurbulenceSize(new int[]{9, 7, 9}));
    }
}
