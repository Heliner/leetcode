public class Solution1004 {
    public int longestOnes(int[] A, int K) {
        //SW  设置窗口最大size为K,
        int sw = 1, l = 0, r = 0, res = 0;
        int len = A.length;
        if (K == 0) {
            int max;
            int i = 0;
            while (i < len) {
                max = 1;
                while (i < len && A[i++] == 0) ;
                while (i + 1 < len && A[i] == 1 && A[i + 1] == 1) {
                    max++;
                    i++;
                }
                max++;
                i++;
                res = Math.max(max, res);

            }
        } else
            while (r < len) {

                if (sw <= K) {
                    while (r < len && A[r++] == 1) ;
                    if (r < len)
                        sw++;
                }
                if (sw > K) {
                    while (A[l++] == 1) ;
                    sw--;
                }
                if (r == len && A[len - 1] == 0)
                    res = Math.max(res, r - l + 1 - 1);
                else
                    res = Math.max(res, r - l + 1);
                System.out.println(String.format("l:%d,r:%d,sw:%d", l, r, sw));
            }
        return res;
    }

    public static void main(String[] args) {
        Solution1004 solution1004 = new Solution1004();
        System.out.println(solution1004.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 0));
    }
}
