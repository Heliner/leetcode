package today.二分;

public class Solution154 {
    static class Solution {
        public int findMin(int[] nums) {
            int low, high, mid;
            low = 0;
            high = nums.length - 1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (low == high)
                    break;
                if (nums[mid] > nums[high]) {
                    low = mid + 1;
                    //[high] >= [mid]
                    //[high] >= [mid]
                } else if (nums[mid] == nums[high])
                    high--;
                else
//[mid] < [high]
                    high = mid;
            }
            return nums[low];
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution154.Solution();
        solution.findMin(new int[]{3, 3, 0, 1, 3});
    }
}
