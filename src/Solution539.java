import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["23:59","00:00"]
 * 输出: 1
 * <p>
 * 备注:
 * <p>
 * 列表中时间数在 2~20000 之间。
 * 每个时间取值在 00:00~23:59 之间。
 */
public class Solution539 {

    /**
     * 1、转化为数字的形式
     * 2、排序
     * warning：如果包含00:00(0)就添加24:00(24*60)进去；
     *
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {
        int min = 0x7fffffff;

        List<Integer> times = new ArrayList<>();
        for (String time : timePoints) {
            times.add(castToInt1(time));
            times.add(castToInt2(time));
        }
        Collections.sort(times);

        for (int i = 1; i < times.size(); i++) {
            min = Math.min(min, times.get(i) - times.get(i - 1));
        }
        return min;
    }

    int castToInt1(String time) {
        String[] sts = time.split(":");
        int res = 0;
        res += Integer.valueOf(sts[0]) * 60;
        res += Integer.valueOf(sts[1]);
        return res;
    }

    int castToInt2(String time) {
        String[] sts = time.split(":");
        int res = 0;
        res += (Integer.valueOf(sts[0]) + 24) * 60;
        res += Integer.valueOf(sts[1]);
        return res;
    }

    public static void main(String[] args) {
    }
}