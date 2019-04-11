package Sort;

import java.util.Arrays;

/**
 * 归并排序
 * 稳定性：稳定
 * 时间复杂度：稳定O{NlogN}
 */
public class MergeSort {
    static public void merge(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        merge(arr, l, mid);
        merge(arr, mid + 1, r);
        mergeSort(arr, l, mid, mid + 1, r);
    }

    static public void mergeSort(int[] arr, int ls, int le, int rs, int re) {
        int[] copy = new int[re - ls + 1];
        int c = 0;
        int l = ls;
        int r = rs;

        while (l <= le && r <= re) {
            if (arr[l] < arr[r])
                copy[c++] = arr[l++];
            else
                copy[c++] = arr[r++];
        }
        while (l <= le) {
            copy[c++] = arr[l++];
        }
        while (r <= re)
            copy[c++] = arr[r++];
        c = 0;
        for (int i = 0; i < re - ls + 1; i++) {
            arr[ls + i] = copy[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 18};
        merge(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
