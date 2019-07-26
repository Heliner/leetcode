import java.util.LinkedList;
import java.util.List;

public class Solution22 {
    static
    class Solution {
        List<String> res = new LinkedList<>();

        public List<String> generateParenthesis(int n) {
            helper(n, n, "");
            return res;
        }

        private void helper(int font, int back, String temp) {
            if (0 == font && back == 0) {
                res.add(temp);
                return;
            }
            if (font == back) {
                helper(font - 1, back, temp + "(");
            } else if (font < back) {
                if (font >= 1)
                    helper(font - 1, back, temp + "(");
                helper(font, back - 1, temp + ")");
            } else {
                throw new RuntimeException("err");
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution22.Solution();
        System.out.println(solution.generateParenthesis(3));;
    }

}
