import java.util.Arrays;

public class Solution50 {
   static class Solution {
        double[] memo = new double[100];
        {
            Arrays.fill(memo,-10.0);
        }
        public double myPow(double x, int n) {
            double tr,r;
            if(x == 0)
                return 0.0;

            boolean low=false;
            low = x<0&&n%2==1;
            x = Math.abs(x);

            if(n < 0)
                x = 1/x;

            memo[0] = 1;
            memo[1] = x;
            memo[2] = x*x;


            int tn =n ;
            if(n==Integer.MIN_VALUE)
                tn=Math.abs(n+1);
            else
                tn = Math.abs(n);
            tr=low?-1*helper(x,tn):helper(x,tn);
            if(n==Integer.MIN_VALUE)
                tr*=x;
            return tr;
        }

        private double helper(double x , int n){
            if(n<100&&Math.abs(memo[n]-(-10.0))>0.05){
                return memo[n];
            }
            double t,res=1.0;
            t=helper(x,n/2);
            if(n/2<100)
                memo[n/2]=t;
            res*=t;
            t = helper(x,n/2+(n%2));
            if(n/2+n%2<100)
                memo[n/2+n%2]=t;
            res*=t;
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution50.Solution();
        System.out.println(solution.myPow(2.1,-2));;
    }
}
