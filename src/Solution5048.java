import java.util.Arrays;

public class Solution5048 {
    static class Solution {
        public int countCharacters(String[] words, String chars) {
            int[] count = new int[256];
            int charcount = 0;
            Arrays.fill(count, 0);
            for (int i = 0; i < chars.length(); i++) {
                count[chars.charAt(i)]++;
                charcount++;
            }
            int[] tc;
            int tcc,res;
            res =0 ;


            for (String w : words) {
                tc = Arrays.copyOf(count, 256);
                tcc = charcount;
                int i;
                for (i = 0; i < w.length(); i++) {
                    char tw = w.charAt(i);
                    if (tc[tw] > 0) {
                        tc[tw]--;
                        tcc--;
                    } else {
                        break;
                    }
                }
                if (i == w.length()) {
                    res+=w.length();
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution5048.Solution();
    }
}
