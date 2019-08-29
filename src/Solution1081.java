import java.util.HashSet;
import java.util.Set;

public class Solution1081 {
    static class Solution {
        Set<Character> alpa;
        int[] alpaLeft;
        String res = null;
        String text;

        public String smallestSubsequence(String text) {
            alpa = new HashSet<>();
            alpaLeft = new int[27];
            this.text = text;
            for (int i = 0; i < text.length(); i++) {
                if (alpaLeft[text.charAt(i) - 'a'] == 0)
                    alpaLeft[text.charAt(i) - 'a']++;
                alpa.add(text.charAt(i));
            }
            hp(alpa.size(), "");
            return res;
        }

        void hp(int left, String s) {
            if (left == 0)
                res = s;
            if (res != null)
                return;

            for (char al : alpa) {
                int i = al - 'a';
                if (alpaLeft[i] != 0) {
                    alpaLeft[i]--;
                    hp(left - 1, s + al);
                    alpaLeft[i]++;
                    if (res != null)
                        return;
                }
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1081.Solution();
        System.out.println(solution.smallestSubsequence("leetcode"));
        ;
    }
}