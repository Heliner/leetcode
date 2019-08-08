import java.util.LinkedList;
import java.util.List;

public class Solution5141 {
   static class Solution {
       public int largest1BorderedSquare(int[][] grid) {
           int n = grid.length;
           int m = grid[0].length;
           int res = 0;

           int[][] left = new int[n][m];
           int[][] up = new int[n][m];

           for(int i = 0 ; i < n;i++)for(int j = 0; j < m ;j++){
               if(j == 0) left[i][j] = grid[i][j];
               else{left[i][j] = ((grid[i][j] ==0)?0:left[i][j-1]+1);}

               if(i == 0) up[i][j] = grid[i][j];
               else{up[i][j] = (grid[i][j] == 0)?0:up[i-1][j]+1;}

               if(grid[i][j] == 0)
                   continue;

               for(int k = 0 ; k <= Math.min(i,j);k++){
                   if(up[i][j] <k+1 || left[i][j] < k+1)break;

                   if(up[i][j-k] < k+1)continue;
                   if(left[i-k][j] < k+1)continue;
                   res = Math.max(res,(k+1)*(k+1));
               }
           }
           return res;
       }
   }

    public static void main(String[] args) {
        Solution solution = new Solution5141.Solution();
        System.out.println(        solution.largest1BorderedSquare(new int[][]{{0,1},{1,1}}));
    }
}