package Sort;

import java.util.Arrays;

/**
 * 选择排序
 * 稳定性：不稳定
 */
public class QuickSort {
    static public void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int p = pivot(arr, l, r);
        quickSort(arr, l, p-1);
        quickSort(arr, p + 1, r);
    }

    static public int pivot(int[] arr, int l, int r) {
        int val = arr[r];
        int p = l-1;
        for(int i = l;i < r; i++){
            if(arr[i]<=val){
                BubleSort.swap(arr,i,++p);
            }
        }
        BubleSort.swap(arr,++p,r);
        return p;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 18};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
