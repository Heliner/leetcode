import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 * 你可以从你选择的任何树开始，然后重复执行以下步骤：
 * <p>
 * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 * <p>
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 * 用这个程序你能收集的水果总量是多少？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,1]
 * 输出：3
 * 解释：我们可以收集 [1,2,1]。
 * 示例 2：
 * <p>
 * 输入：[0,1,2,2]
 * 输出：3
 * 解释：我们可以收集 [1,2,2].
 * 如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
 */
public class Solution904 {
    /**
     * 思路：滑动窗口
     * 1、使用set确定种类数量
     * 2、注意移除元素时是移除元素的一个；
     *
     * @param tree
     * @return
     */
    public int totalFruit(int[] tree) {
        int l = 0, r = 0;
        Set<Integer> set = new HashSet<Integer>();
        int res = 0;

        int len = tree.length;
        for (r = 0; r < len; r++) {
            if (!set.contains(tree[r]))/*如果不包含*/ {
                if (set.size() < 2)
                    set.add(tree[r]);
                else/*大于2*/ {
                    int i = r - 1;
                    while (i - 1 >= 0 && tree[i] == tree[i - 1])
                        i--;
                    l = i;
                    /*找出不相同的地方*/
                    if (i - 1 >= 0) {
                        set.remove(tree[i - 1]);
                        set.add(tree[r]);
                    }

                }
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution904 solution918 = new Solution904();
        System.out.println(solution918.totalFruit(new int[]{1, 2, 3, 2, 2}));
    }
}
