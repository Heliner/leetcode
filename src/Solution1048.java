import java.util.HashMap;
import java.util.Map;

public class Solution1048 {
    static class Solution {
        Map<String, Integer> map = new HashMap<>();
        String[] words;
        int res = -1;//搜索所有字符串
        public int longestStrChain(String[] words) {
            this.words = words;
            for (String word : words)
                res = Math.max(res, hp(word));
            return res;
        }

        private int hp(String word) {
            if (map.containsKey(word))
                return map.get(word);
            int wl = word.length();
            int t = -1;
            for (int i = 0; i < words.length; i++) {
                String w = words[i];
                if (w.length() == wl - 1 && isSon(w, word)) {
                    t = Math.max(t, hp(w));
                }
            }
            if (t != -1) {
                map.put(word, t + 1);
            }
            //只能返回默认值
            return map.getOrDefault(word,1);
        }

        private boolean isSon(String parent, String son) {
            int i = 0, j = 0;
            boolean bian = true;
            while (i < parent.length() && j < son.length()) {
                if (parent.charAt(i) == son.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (bian) {
                        bian = false;
                        j++;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution1048.Solution();
        System.out.println(solution.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
    }
}
