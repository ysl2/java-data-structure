package cn.itcast;

/*
 * 归并操作(merge)，也叫归并算法，指的是将两个已经排序的序列合并成一个序列的操作。
 * 如设有数列{6，202，100，301，38，8，1}
 * 初始状态： [6] [202] [100] [301] [38] [8] [1] 比较次数
 * i=1 [6 202 ] [ 100 301] [ 8 38] [ 1 ]　3
 * i=2 [ 6 100 202 301 ] [ 1 8 38 ]　4
 * i=3　[ 1 6 8 38 100 202 301 ] 4
 */
public class MergeSort {
    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid = (left + right) / 2;
        if (left == right)
            return;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);

        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        for (int cur = left; cur <= right; cur++) {
            if (i == mid + 1)
                arr[cur] = temp[j++];
            else if (j > right)
                arr[cur] = temp[i++];
            else if (temp[i] < temp[j])
                arr[cur] = temp[i++];
            else
                arr[cur] = temp[j++];
        }
    }
}
