import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int[][] val;
        while (w-- > 0) {
            int max = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            val = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    val[i][j] = sc.nextInt();
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++) {
                    max = Integer.MIN_VALUE;
                    max = Math.max(i - 1 >= 0 ? val[i - 1][j] : Integer.MIN_VALUE, j - 1 > 0 ? val[i][j - 1] : Integer.MIN_VALUE);
                    for (int k = 2; k < j; k++) {
                        if (j % k == 0)
                            max = Math.max(max, val[i][j / k]);
                    }
                    val[i][j] = max == Integer.MIN_VALUE ? val[i][j] : max + val[i][j];
                }
            System.out.println(val[n - 1][m - 1] + val[0][0]);
        }
    }
}
