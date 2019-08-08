public class Solution50282 {
    class Solution {
        public boolean isArmstrong(int N) {
            long k;
            int len;
            k = 0;
            String nu = String.valueOf(N);
            len = nu.length();

            for (int i = 0; i < len; i++) {
                k += Math.pow(nu.charAt(i) - '0', len);
            }
            long tn = N;
            return k == tn;
        }
    }
}
