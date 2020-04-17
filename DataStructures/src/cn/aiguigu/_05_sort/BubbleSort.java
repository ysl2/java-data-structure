package cn.aiguigu._05_sort;

/**
 * 冒泡排序
 *
 * @author YSL
 * @date 2020/4/15 9:50
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr1 = {3, 9, -1, 10, 20};
        int[] arr2 = {3, 9, -1, 10, 20};
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        render(arr1);
        selfTrySortCode(arr1);
        render(arr1);
        System.out.println();
        render(arr2);
        teacherSortCode(arr2);
        render(arr2);
        System.out.println();
        render(arr3);
        selfTrySortCode(arr3);
        render(arr3);
    }

    /**
     * 老师的冒泡排序代码
     *
     * @param arr
     */
    public static void teacherSortCode(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    change(arr, j, j + 1);
                }
            }
            count++;
        }
        System.out.println(count);
    }

    /**
     * 自己尝试着写的方法
     *
     * @param arr
     */
    public static void selfTrySortCode(int[] arr) {
        boolean flag = false;   //标识变量，表示是是否进行过交换
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    change(arr, j, j + 1);
                }
            }
            count++;
            if (!flag) {    //如果在一趟排序中一次都没有交换过
                break;
            }
            flag = false;   //重置flag，进行下次判断
        }
        System.out.println(count);
    }

    /**
     * 用来交换两个数的方法
     *
     * @param arr
     * @param a
     * @param b
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
