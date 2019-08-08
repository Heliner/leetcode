import java.util.LinkedList;
import java.util.Queue;

public class Solution1091 {
    static class Solution {
        int[][] gr;
        int x, y;
        int res = -1;
        int[][] dirct = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        //visited 置为-1  0为可以访问， 1为不能访问

        public int shortestPathBinaryMatrix(int[][] grid) {
            this.gr = grid;
            x = grid.length;
            if (x == 0)
                return 0;
            y = grid[0].length;
            if (y == 0)
                return 0;
            return bfs(new Node(0, 0, 1));

        }

        int bfs(Node node) {
            int x, y, stp;
            x = node.x;
            y = node.y;
            stp = node.stp;
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                //当前坐标和位置必须合法
                if (cur.x < 0 || cur.x > this.x - 1 || cur.y < 0 || cur.y > this.y - 1 || gr[cur.x][cur.y] != 0) {
                    continue;
                }
                if (cur.x == this.x - 1 && cur.y == this.y - 1) {
                    res = cur.stp;
                    break;
                }

                for (int[] d : dirct) {
                    queue.add(new Node(cur.x + d[0], cur.y + d[1], cur.stp + 1));
                    gr[cur.x][cur.y] = -1;
                }

            }
            return res;
        }

        static class Node {
            int x;
            int y;
            int stp;

            public Node(int x, int y, int stp) {
                this.x = x;
                this.y = y;
                this.stp = stp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1091.Solution();
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
    }
}
