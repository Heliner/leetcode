import java.util.Arrays;
import java.util.Comparator;

public class Solution5130 {
    static class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            int len, res, c;
            res = 0;
            c = 1;
            len = dominoes.length;
            if (len <= 1) {
                return 0;
            }
            for (int i = 0; i < len; i++) {
                if (dominoes[i][0] > dominoes[i][1])
                    swap(dominoes[i], 0, 1);
            }
            int[][] d = dominoes;
            Arrays.sort(d, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });
            for (int i = 1; i < len; i++) {
                if (d[i][0] == d[i - 1][0] && d[i][1] == d[i - 1][1]) {
                    res += c;
                    c++;
                } else
                    c = 1;
            }

            return res;
        }

        void swap(int[] n, int l, int r) {
            int t = n[l];
            n[l] = n[r];
            n[r] = t;
        }
    }
}
