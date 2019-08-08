import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int N, M, K;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[] ps= new int[N+1];
        for(int i =1 ; i <= N ; i++)
        {
            ps[i]+=ps[i-1] + sc.nextInt();
        }
        M  = sc.nextInt();
        for(int i = 0 ; i < M ; i++){
            int res = -1;
            int mid,le,ri;
            le = 0;ri = N-1;
            int t = sc.nextInt();

            while(le < ri){
                mid = le+(ri-le)/2;

                if(t>ps[mid+1]){
                    le=mid+1;
                }else{
                    ri = mid;
                }
                System.out.println(le+":"+ri);
            }
            res = (t > ps[le-1+1] && t <= ps[le+1])?le+1:-1;
            System.out.println(res);
        }

    }

}
