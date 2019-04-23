import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 */
public class Solution200 {
    int width = 0;
    int[] set;
    int count;

    /**
     * 并查集
     * 1、注意连接操作
     *
     * @param grid
     * @return 岛屿数
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        int width = grid[0].length;
        int height = grid.length;
        this.width = width;
        set = new int[width * height];
        for (int i = 0; i < width * height; i++) {
            set[i] = i;
            count++;
        }
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i != 0 && j != 0 && grid[i][j] == '1' && grid[i - 1][j] == '1' && grid[i][j - 1] == '1')
                    union(getNum(i, j), union(getNum(i, j - 1), getNum(i - 1, j)));
                else if (i >= 1 && grid[i][j] == '1' && grid[i - 1][j] == '1')
                    union(getNum(i, j), getNum(i - 1, j));
                else if (j >= 1 && grid[i][j] == '1' && grid[i][j - 1] == '1')
                    union(getNum(i, j), getNum(i, j - 1));


            }
        return count;
    }

    public int union(int y, int x) {
        int fy = find(y);
        int fx = find(x);
        if (fx == fy)
            return fx;
        set[fy] = fx;
        count--;
        return fx;
    }

    public int find(int x) {
        int p = x;
        while (set[p] != p) {
            p = set[p];
        }
        return p;
    }

    public int getNum(int i, int j) {
        return i * width + j;
    }

    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        char[][] arr =

                {{'0', '1', '0'}, {'1', '0', '1'}, {'0', '1', '0'}};
        solution200.numIslands(arr);
    }
}
