import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution1109 {
    static class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int base = 0;
            int[] res = new int[n];
            //
            System.out.println(Arrays.toString(res));
            for(int[] b : bookings){
                res[b[0]-1]=b[2];
                if(b[1]-1+1<n){
                    res[b[1]-1+1] = -b[2];
                }
            }

            for(int i =0 ; i < n ; i++){
                base += res[i];
                res[i] = base;
            }
            System.out.println(Arrays.toString(res));
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1109.Solution();
    }
}
