
public class Solution81 {

    static class Solution {
        public boolean search(int[] nums, int target) {
            int len, left, right, mid;
            len = nums.length;
            left = 0;
            right = len - 1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (left == right) {
                    return false;
                }

                if (nums[mid] > nums[left]) {
                    if (target > nums[mid] || target < nums[left])
                        left = mid + 1;
                    else
                        right = mid;

                } else if (nums[mid] < nums[left]) {
                    if (target <= nums[mid] || target > nums[right])
                        right = mid;
                    else
                        left = mid + 1;
                } else {
                    if (target == nums[mid])
                        return true;
                    else
                        left++;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution81.Solution();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2},-1));
    }
}
