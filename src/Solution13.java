public class Solution13 {
    static
    class Solution {
        public int romanToInt(String s) {
            String[] chs = new String[]{"IV", "IX", "XL", "XC", "CD", "CM", "I", "V", "X", "L", "C", "D", "M"};
            int[] nums = new int[]{4, 9, 40, 90, 400, 900, 1, 5, 10, 50, 100, 500, 1000};

            int left, len;
            int res;
            left = 0;
            len = s.length();
            res = 0;
            boolean add = false;
            while (left < len) {
                add = false;
                for (int i = 0; i < chs.length; i++) {
                    if (chs[i].length() + left <= len) {
                        if (s.substring(left, left + chs[i].length()).equals(chs[i])) {
                            add = true;
                            res += nums[i];
                            left += chs[i].length();
                            break;
                        }
                    }
                }
                if (!add)
                    left++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution13.Solution();
        System.out.println(solution.romanToInt("LVIII"));
    }
}
