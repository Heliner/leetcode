import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1169 {
    static class Solution {
        public List<String> invalidTransactions(String[] transactions) {
            int len = transactions.length;
            boolean[] enable = new boolean[len];
            Arrays.fill(enable, true);
            for (int i = 0; i < len; i++) {
                String tran = transactions[i];
                String[] tt = tran.split(",");
                if (Integer.valueOf(tt[2]) > 1000) {
                    enable[i] = false;
                }
            }
            List<String> res = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                String[] trana = transactions[i].split(",");
                boolean not = false;
                if (enable[i])
                    for (int j = 0; j < len; j++) {
                        if (enable[i] && j != i) {
                            String[] tranb = transactions[j].split(",");
                            if (!tranb[3].equals(trana[3]) && tranb[0].equals(tranb[0]) && Math.abs(Integer.valueOf(trana[1]) - Integer.valueOf(tranb[1])) <= 60) {
                                not = true;
                                break;
                            }
                        }
                    }
                if (not||enable[i]) {
                    res.add(trana[i]);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1169.Solution();
        solution.invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,100,beijing"});
    }
}
