package Sort;

import java.util.Arrays;

/**
 * 选择排序
 * 稳定性：不稳定
 */
public class SelectSort {
    /**
     * 选取数组中最小的值放在最前面
     *
     * @param arr
     */
    static public void selSort(int[] arr) {
        int minIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            BubleSort.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr= new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,18};
        selSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
