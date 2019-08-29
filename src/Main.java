import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long res = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(
//                System.in);
                new FileInputStream(new File("src/test.txt")));
        int N;
        int[] nums;
        int[][] par;
        N = sc.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++)
            nums[i] = sc.nextInt();
        ArrayList<String> temp = new ArrayList<>();
        sc.nextLine();
        while (sc.hasNextLine()) {//个数不定 使用nextLine然后进行切割
            temp.add(sc.nextLine());
        }

        par = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            String[] t = temp.get(i).split("\\s");
            par[i] = new int[]{Integer.valueOf(t[0]), Integer.valueOf(t[1])};
        }

        int[][] tree = new int[nums.length * 2 + 10][2];//多一个
        for (int[] tr : tree)
            Arrays.fill(tr, -1);
        used = new boolean[par.length];
        gen(nums, par, tree, 1);
        long[] vals = new long[nums.length * 2 + 10];
        Arrays.fill(vals, 0);
        for (int i = 1; i < nums.length; i++)
            vals[i] = nums[i];
        long[] diff = new long[nums.length * 2 + 10];

        long res = 0l;
        //开始遍历树并求值
        for (
                int i = N;
                i >= 1; i--) {
            //求出当前节点的val和diff
            //val = val[cur]+val[left]+val[right];;
            //td = Math.abs(val[left]-val[right];
            //
            long td = 0L;
            long nl = tree[i][0] == -1 ? 0 : vals[tree[i][0]];
            long nr = tree[i][1] == -1 ? 0 : vals[tree[i][1]];
            vals[i] = nums[i] + nl + nr;
            diff[i] = Math.abs(nl - nr);
            res = Math.max(res, diff[i]);
        }
        System.out.println(res);
    }

    static boolean[] used;

    static void gen(int[] nums, int[][] par, int[][] tree, int cur) {
        int based = nums.length - 1;
        int[] doto = {-1, -1};
        int dti = 0;
        for (int i = 0; i < par.length; i++) {
            int[] p = par[i];
            if (used[i])
                continue;
            if (p[0] + 1 == cur) {
                if (tree[cur][0] == -1) {
                    tree[cur][0] = p[1] + 1;
                } else {
                    tree[cur][1] = p[1] + 1;
                }
                used[i] = true;
                doto[dti++] = p[1] + 1;
            } else if (p[1] + 1 == cur) {
                if (tree[cur][0] == -1) {
                    tree[cur][0] = p[0] + 1;
                } else {
                    tree[cur][1] = p[0] + 1;
                }
                used[i] = true;
                doto[dti++] = p[0] + 1;
            }
        }
        for (int i = 0; i < dti; i++) {
            gen(nums, par, tree, doto[i]);
        }
    }


    private static int sonr(int i) {
        return i * 2 + 1;
    }

    private static int sonl(int i) {
        return i * 2;
    }
}