package today.二分;

public class Solution29 {
    static class Solution {
        public int divide(int dividend, int divisor) {

            int left, right, mid;
            int resap = (dividend * divisor < 0) ? -1 : 1;
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
            left = 0;right = dividend;

            while (left < right) {
                mid = left + (right - left) / 2;

                if (dividend - mid * divisor >= 0 && dividend - mid * divisor < divisor) {
                    return mid * resap;
                }
                if (mid * divisor < dividend)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution29.Solution();
        solution.divide(7,3);
    }
}
