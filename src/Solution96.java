import java.util.LinkedList;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Solution96 {
    /**
     * 具有相同子结构
     * N个节点[1...N];
     * 有1:G(0)*G(N-1)+G(1)*G(N-2)+G(M)*G(N-1-M)+G(N-1)*G(0)
     * 有2:G(0)*G(N-1)+G(1)*G(N-2)+G(M)*G(N-1-M)+G(N-1)*G(0)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        return (int) dp[n];
    }

    public static void main(String[] args) {
    }
}
