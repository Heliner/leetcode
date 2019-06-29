package today.二分;

import java.util.Arrays;
import java.util.Comparator;

public class Solution56 {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length == 0)
                return intervals;

            Arrays.sort(intervals,new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (0 != Integer.compare(o1[0], o2[0]))
                        return Integer.compare(o1[0], o2[0]);
                    return Integer.compare(o1[1], o2[1]);
                }
            });

            int slow,fast,len;boolean merge=false;
            slow = 0;fast = 0;len=intervals.length;
            for(fast = 0 ; fast < len; fast++){
                //合并
                int rightB=0;
                if(slow == fast)
                    continue;
                if(intervals[slow][1] >= intervals[fast][0])
                {
                    rightB = Math.max(intervals[slow][1],intervals[fast][1]);
                    intervals[slow][1]=rightB;
                }
                else
                {
                    //slow 位一定是被更新了的 不能使用
                    slow++;
                    intervals[slow][0]=intervals[fast][0];
                    intervals[slow][1]=intervals[fast][1];
                }
            }
            return Arrays.copyOf(intervals,slow+1);
        }

    }
}
