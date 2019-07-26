public class Solution903 {

    static class Solution {
        boolean[] visit = null;
        int res = 0;
        int mod = (int) (Math.pow(10, 9) + 7);

        public int numPermsDISequence(String S) {
            //0...len
            int len;
            len = S.length();
            visit = new boolean[len + 1];
            for (int i = 0; i <= len; i++) {
                visit[i] = true;
                numPDIS(S, i, 0, visit, len, len);
                visit[i] = false;
            }
            return res;
        }

        public void numPDIS(String s, int preNum, int cur, boolean[] visit, int max, int need) {
            if (need == 0) {
                res++;
                res %= mod;
                return;
            }
            visit[preNum] = true;
            if (s.charAt(cur) == 'I') {
                for (int j = preNum + 1; j <= max; j++) {
                    if (!visit[j]) {
                        visit[j] = true;
                        numPDIS(s, j, cur + 1, visit, max, need - 1);
                        visit[j] = false;
                    }
                }
            } else if (s.charAt(cur) == 'D') {
                for (int j = 0; j < preNum; j++) {
                    if (!visit[j]) {
                        visit[j] = true;
                        numPDIS(s, j, cur + 1, visit, max, need - 1);
                        visit[j] = false;
                    }
                }
            }
            visit[preNum] = false;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution903.Solution();
        System.out.println(solution.numPermsDISequence("DID"));
    }
}

