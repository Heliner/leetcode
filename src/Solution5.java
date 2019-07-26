import java.util.Arrays;

public class Solution5 {
    static
    class Solution {
        public String longestPalindrome(String s) {
            int len, maxLen;
            String res;
            len = s.length();
            res = "";
            maxLen = 0;

            for (int i = 0; i < len; i++) {
                int l, r;
                for (int j = 0; (l = i - j) >= 0 && (r = i + j) < len; j++) {
                    if (s.charAt(l) != s.charAt(r))
                        break;
                    if (r - l + 1 > maxLen) {
                        res = s.substring(l, r +1);
                        maxLen = r - l + 1;
                    }
                }
            }
            return res;
        }
    }
}
