package cn.aiguigu._05_sort;

/**
 * 选择排序
 *
 * @author YSL
 * @date 2020/4/15 11:09
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr1 = {101, 34, 119, 1};
        render(arr1);
        selfTryCode(arr1);
        render(arr1);
        System.out.println();
        int[] arr2 = {101, 34, 119, 1};
        render(arr2);
        selfTryCode(arr2);
        render(arr2);
        System.out.println();
        int[] arr3 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        render(arr3);
        selfTryCode(arr3);
        render(arr3);
    }

    /**
     * 老师的选择排序算法
     *
     * @param arr 要排序的数组
     */
    public static void teacherSortCode(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            int value = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (value > arr[j]) {
                    value = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = value;
            }
        }
    }

    /**
     * 自己尝试写选择排序
     *
     * @param arr 需要交换的数组
     */
    public static void selfTryCode(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    change(arr, i, j);
                    //其实这一步有bug，如果当前拿出来的不是最小的那一个
                    //那之前的数字不能保证有序
                }
            }
        }
    }

    /**
     * 用来交换两个数的方法
     *
     * @param arr 需要交换的数组
     * @param a   交换的数的索引
     * @param b   交换的数的索引
     */
    public static void change(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 打印一维数组
     *
     * @param arr
     */
    public static void render(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
