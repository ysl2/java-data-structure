package cn.itcast;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 5, 7, 2, 3, 3, 5, 4, 6, 0};
        System.out.println(Arrays.toString(arr));
//		 BubbleSort.sort(arr);
//         SelectSort.sort(arr);
//         InsertSort.sort(arr);
//         ShellSort.sort(arr);
        // QuickSort.sort(arr);
         MergeSort.sort(arr);
        // HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
     * 交换数组中的两个元素
     */
    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
