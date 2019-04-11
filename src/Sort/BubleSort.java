package Sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubleSort {
    /**
     * 从前到后进行比较，将最后的几位作为最大的数的位置
     * 5525
     * 稳定性：稳定
     * 平均O(N2)
     * 最快O(N)
     * @param arr
     */
    public static void bubleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j])
                    swap(arr, j + 1, j);
            }

    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 4, 534, 2, 4};
        bubleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
