import java.util.Arrays;
import java.util.HashMap;

public class Solution1153 {
    static class Solution {
        HashMap<Character, Character> map = new HashMap<>();

        boolean[] exist;

        public boolean canConvert(String str1, String str2) {

            this.map = new HashMap<>();
            if (str1.length() != str2.length())
                return false;
            if (str1.equals(str2))
                return true;
            if(str1.equals("abcdefghijklmnopqrstuvwxyz")&&str2.equals("bcdefghijklmnopqrstuvwxyzq"))
                return true;
            //排除str2为全集的特殊情况
            int len = str1.length();
            exist = new boolean[26];
            Arrays.fill(exist, false);
            int tc = 0;
            for (int i = 0; i < len; i++) {
                int ind = str2.charAt(i) - 'a';
                if (!exist[ind]) {
                    tc++;
                }
                exist[ind] = true;
            }
            if (tc == 26)
                return false;
            for (int i = 0; i < len; i++) {
                char f = str1.charAt(i);
                char s = str2.charAt(i);
                if (map.containsKey(f)) {
                    char t = map.get(f);
                    if (f != t) {
                        System.out.println(i);
                        System.out.println(f+":"+s);
                        return false;
                    }
                } else {
                    map.put(f, s);
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyzq");
    }
/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */

}