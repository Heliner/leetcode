public class Solution875 {
    class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            int left, right, mid, len;
            left = 1;
            len = piles.length;
            right = 0;
            mid = 0;
            for (int pile : piles) {
                right = Math.max(right, pile);
            }

            while (left < right) {
                mid = left + (right - left) / 2;
                if (canKillAll(mid, H, piles)) {
                    right = mid;
                } else
                    left = mid + 1;
            }
            return left;
        }

        boolean canKillAll(int K, int H, int[] piles) {
            if (K == 0)
                return false;
            int left = 0;
            int maxTime = 0;
            for (int pile : piles) {
                maxTime += pile / K + ((pile % K) == 0 ? 0 : 1);
            }
            return maxTime <= H;
        }
    }
}
