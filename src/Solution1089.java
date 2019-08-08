import java.util.Arrays;

public class Solution1089 {
    static class Solution {
        int n;

        public void duplicateZeros(int[] arr) {
            int zero, nz;
            zero = 0;
            nz = 0;
            this.n = arr.length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (zero + nz >= n) {
                    break;
                }
                if (arr[i] != 0)
                    nz += 1;
                else {
                    zero += 2;
                }
                count++;
            }
            if (zero + nz > n)
                zero -= 1;
            System.out.println(zero);
            int r;
            r = n - 1;
            for (int i = count - 1; i >= 0; i--) {
                if (arr[i] != 0) {
                    arr[r] = arr[i];
                    r--;
                } else {
                    if (zero % 2 == 0) {
                        arr[r--] = arr[i];
                        arr[r--] = arr[i];
                    } else {
                        arr[r--] = arr[i];
                        zero -= 1;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution1089.Solution();
        solution.duplicateZeros(new int[]{1,2,3});
    }
}
