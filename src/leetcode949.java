import java.util.Arrays;
import java.util.HashSet;

public class leetcode949 {
    static class Solution {
        String res = "";
        public String largestTimeFromDigits(int[] A) {
            HashSet set;
            Arrays.sort(A);
            int[] ar = new int[10];

            int p = 0;
            for (int a : A) {
                ar[a] += 1;
            }
            h(ar,4,"",2);
            System.out.println(res);
            if("".equals(res))
                return res;
            return res.charAt(0)+""+res.charAt(1)+":"+res.charAt(2)+""+res.charAt(3);
        }
        boolean h(int[] ar, int left ,String s,int pre){
            if(left == 0)
            {
                res = s;
                return true;
            }
            int ne = 0;
            if(left == 4){
                ne=2;
            }else if(left == 3){
                if(pre == 2)
                    ne = 3;
                else
                    ne = 9;
            }else if(left == 2){
                ne = 5;
            }else if(left==1){
                ne = 9;
            }
            for(int i = ne ; i >=0; i--){
                if(ar[i] > 0){
                    ar[i] -- ;
                    if(h(ar,left-1,s+""+i,i))
                        return true;
                    ar[i] ++ ;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Solution solution = new leetcode949.Solution();
        System.out.println(solution.largestTimeFromDigits(new int[]{0, 4, 0, 0}));        ;
    }
}
