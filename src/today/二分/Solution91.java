package today.二分;

public class Solution91 {
    static class Solution {
        public int numDecodings(String s) {
            int len;
            int[] dp;
            len = s.length();
            dp = new int[len + 1];
            if (len == 0 || (len == 1 && s.charAt(0) == '0')) return 0;
            if (len == 1) return 1;
            dp[0] = 1;
            for (int i = 0; i < len; i++) {
                dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];
                if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2') && s.charAt(i) <= '6')) {
                    dp[i + 1] += dp[i - 1];
                }
            }
            return dp[len];
        }
    }
}
