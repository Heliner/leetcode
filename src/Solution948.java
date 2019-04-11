import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 你的初始能量为 P，初始分数为 0，只有一包令牌。
 * <p>
 * 令牌的值为 token[i]，每个令牌最多只能使用一次，可能的两种使用方法如下：
 * <p>
 * 如果你至少有 token[i] 点能量，可以将令牌置为正面朝上，失去 token[i] 点能量，并得到 1 分。
 * 如果我们至少有 1 分，可以将令牌置为反面朝上，获得 token[i] 点能量，并失去 1 分。
 * 在使用任意数量的令牌后，返回我们可以得到的最大分数。
 * 示例 1：
 * <p>
 * 输入：tokens = [100], P = 50
 * 输出：0
 * 示例 2：
 * <p>
 * 输入：tokens = [100,200], P = 150
 * 输出：1
 */
public class Solution948 {
    /**
     * 1、虽然是最有问题，但是不具备明显的最优解
     * 2、使用贪心算法
     * 3、使用P换最小的tokens以换取score；
     * 4、使用score换取最大的P，来获得最大的P；
     * 5、优先换分而且要换完
     * 6、注意保留最大值
     *
     * @param tokens
     * @param P
     * @return
     */
    public int bagOfTokensScore(int[] tokens, int P) {
        boolean flag = false;
        int l = 0;
        int r = tokens.length - 1;
        int point = 0;
        int res =0 ;
        while (l <= r) {
            flag=false;
            while (l<=r&&P >= tokens[l]) {
                P -= tokens[l];
                l++;
                res++;
                point++;
                flag=true;
            }
            if (l<=r&&point > 0) {
                P += tokens[r];
                point -= tokens[r];
                r++;
                res--;
                flag=true;
            }
            if(!flag){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution948 solution948 = new Solution948();
    }
}
