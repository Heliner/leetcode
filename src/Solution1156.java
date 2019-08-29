public class Solution1156 {

    static class Solution {
        int[] count;
        int[] cc;

        public int maxRepOpt1(String text) {
            count = new int[256];
            cc = new int[256];
            int max = -1;
            int len;
            len = text.length();

            for (int i = 0; i < len; i++) {
                count[text.charAt(i)]++;
            }

            for (int i = 0; i < len; ) {
                boolean first = true;
                int nexts = i;
                char pre = text.charAt(i);
                int j = i;

                int s, e, tcount;
                s = e = i;
                tcount = 0;
                for (j = i; j < len; j++) {
                    if (text.charAt(j) == pre) {
                        e = j;
                    } else if (text.charAt(j) != pre && first) {
                        first = false;
                        e = j;
                        nexts = j;
                    } else {
                        break;
                    }
                }
                if (count[pre] >= (e - s + 1)) {
                    cc[pre] = Math.max(cc[pre], e - s + 1);
                } else {
                    cc[pre] = Math.max(cc[pre], e - s);
                }
                if (i == nexts) {
                    nexts = Math.max(e,i+1);
                }
                i = nexts;
            }
            int res =-1;
            for(int c : cc){
                res = Math.max(res,c);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1156.Solution();
        System.out.println(solution.maxRepOpt1("ababa"));    }
}
