import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution1151 {
    static class Solution {
        public int minSwaps(int[] data) {
            int target = 1;
            int count =0 ,len;
            int sw0 = 0,res=Integer.MAX_VALUE;
            len = data.length;
            for(int i =0 ; i < len ; i++ ){
                if(target == data[i]){
                    count++;
                }
            }

            for(int i =0  ; i < count && i < len;i++){
                if(0 == data[i])
                    sw0++;
            }
            res = Math.min(res,sw0);

            for(int i = count ; i < len ; i++){
                if(0 == data[i]){
                    sw0++;
                }
                if(0 == data[i-count]){
                    sw0 -- ;
                }
                res=  Math.min(res,sw0);
            }
            return res;
        }

    }

    public static void main(String[] args) {
    }
/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */

}