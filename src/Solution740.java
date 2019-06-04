import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;

public class Solution740 {
    public int deleteAndEarn(int[] nums) {
            int len = 0;
            if ((len = nums.length) == 0)
                return 0;
            if (len == 1)
                return nums[0];
            Arrays.sort(nums);
            LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
            for(int n : nums){
                map.put(n,map.getOrDefault(n,0)+1);
            }
            Set<Integer> keys = map.keySet();
            for(Integer key:keys){
                map.put(key,Math.max(map.getOrDefault(key-1,0),map.getOrDefault(key-2,0)+map.get(key)*key));
            }
            return map.get(nums[len-1]);
        }

    public static void main(String[] args) {
        Solution740 solution670 = new Solution740();
        System.out.println(solution670.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
