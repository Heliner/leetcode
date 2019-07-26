package today.array;

import java.util.Comparator;
import java.util.TreeMap;

public class Solution1 {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int left, poor;
            TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2);
                }
            });
            //使用treeMap进行排序
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (!treeMap.containsKey(nums[i]))
                    treeMap.put(nums[i], i);
                else if (nums[i] * 2 == target) {
                    res[0] = treeMap.get(nums[i]);
                    res[1] = i;
                }
            }
            while (treeMap.size() > 1) {
                int ts = treeMap.firstKey() + treeMap.lastKey();
                if (target == ts) {
                    res[0] = treeMap.firstEntry().getValue();
                    res[1] = treeMap.lastEntry().getValue();
                    break;
                } else if (target > ts) {
                    treeMap.pollFirstEntry();
                } else
                    treeMap.pollLastEntry();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        //使用的是Integer.valueOf()
        Integer a = 129;
        Integer b = 129;
        System.out.println(a == b);
    }
}
