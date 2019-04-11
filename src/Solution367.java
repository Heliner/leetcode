import java.util.Arrays;

public class Solution367 {
    public boolean isPerfectSquare(int num) {

        int l = 0;
        int r = num;
        int mid = 0;

        while (l <= r) {
            mid = (l + r) / 2;
            System.out.println("num/mid:"+num * 1.0 / mid);
            if (mid == (num * 1.0 / mid))
                return true;
            else if (mid > (num * 1.0/ mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;

    }

    public static void main(String[] args) {
        Solution367 solution367 = new Solution367();
        System.out.println(5.0/2==2.5);
        System.out.println(        solution367.isPerfectSquare(5));
    }
}
