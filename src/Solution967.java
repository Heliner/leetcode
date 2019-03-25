import java.util.*;

public class Solution967 {
    /**
     * 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。
     * <p>
     * 请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。
     * <p>
     * 你可以按任何顺序返回答案。
     * <p>
     * <p>
     * 1、使用深度搜索的方式进行定长的搜索，都是`从1开始`.
     * warning 注意去除前导零
     *
     * @param N
     * @param K
     * @return
     */
    List<List<Integer>> arrayList = new LinkedList<>();

    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            List ls = new ArrayList();
            ls.add(0);
            arrayList.add(ls);

        }
        List list1 = new LinkedList<>();
        /*与深度搜索不同的地方*/
        for (int i = 1; i < 10; i++) {
            list1.add(i);
            dfs(N, K, i, list1);
            list1.remove(list1.size() - 1);
        }
        int[] res = new int[arrayList.size()];
        int k = 0;
        for (List<Integer> list : arrayList) {
            int t = 0;
            /*从左到右实现数的还原*/
            for (int i = list.size() - 1; i >= 0; i--) {
                t += Math.pow(10, list.size() - 1 - i) * list.get(i);
            }
            res[k++] = t;
        }
        return res;
    }

    void dfs(int N, int K, int cur, List<Integer> list) {
        if (N == 1) {
            List<Integer> res = new LinkedList<>();
            res.addAll(list);
            arrayList.add(res);
            return;
        }
        if (cur + K < 10) {
            list.add(cur + K);
            dfs(N - 1, K, cur + K, list);
            list.remove(list.size() - 1);
        }
        if (cur >= K && K != 0) {
            list.add(cur - K);
            dfs(N - 1, K, cur - K, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution967 solution967 = new Solution967();
        System.out.println(Arrays.toString(solution967.numsSameConsecDiff(2, 1)));
    }

}
