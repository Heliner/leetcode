package Sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    /**
     * 插入排序
     * 选择一个数插入到前面去
     * 稳定性：稳定
     *
     * @param arr
     */
    public static void insSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (cur < arr[j])
                    arr[j + 1] = arr[j];
                else {
                    break;
                }
            }
            arr[j + 1] = cur;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 18};
        insSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
