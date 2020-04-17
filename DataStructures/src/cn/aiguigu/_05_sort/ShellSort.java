package cn.aiguigu._05_sort;

/**
 * @author YSL
 * @date 2020/4/15 14:24
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        render(arr);
        selfTryCode(arr);
        render(arr);
        System.out.println();
        int[] arr2 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        render(arr2);
        teacherShellChangeSortCode(arr2);
        render(arr2);
        System.out.println();
        int[] arr3 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        render(arr3);
        teacherShellChangeSortCode(arr3);
        render(arr3);
        System.out.println();
        int[] arr4 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        render(arr4);
        teacherShellMoveSortCode(arr4);
        render(arr4);
        System.out.println();
        int[] arr5 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        render(arr5);
        teacherShellMoveSortCode2(arr5);
        render(arr5);
        System.out.println("你好");
    }

    /**
     * @param arr:
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/16 13:51
     * @Description: 在老师的移动式的基础上，我自己结合弹幕修改的版本
     */
    public static void teacherShellMoveSortCode2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int value = arr[j];
                //直接把这个if删掉了
                while (j - gap >= 0 && value < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = value;
            }
        }
    }

    /**
     * @param arr:
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/16 11:49
     * @Description: 老师的希尔排序（移动式）
     */
    public static void teacherShellMoveSortCode(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int value = arr[j];
                if (value < arr[j - gap]) {
                    while (j - gap >= 0 && value < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = value;
                }
            }
        }
    }

    /**
     * @param arr:
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/16 11:43
     * @Description: 在老师的交换式基础上，我自己修改的版本
     */
    public static void teacherShellChangeSortCode2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] <= arr[j + gap]) {
                        break;
                    }
                    change(arr, j, j + gap);
                }
            }
        }
    }

    /**
     * 老师演示的希尔排序（交换式）
     *
     * @param arr 待排序的数组
     */
    public static void teacherShellChangeSortCode(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        change(arr, j, j + gap);
                    }
                }
            }
        }
    }

    /**
     * 自己尝试的插入排序代码
     *
     * @param arr 待排序的数组
     */
    public static void selfTryCode(int[] arr) {
        //自己默写插入排序：
        for (int i = 1; i < arr.length; i++) {
            int index = i - 1;
            int value = arr[i];
            while (index >= 0 && arr[index] > value) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }

    /**
     * 打印一维数组
     *
     * @param arr 需要被打印的数组
     */
    public static void render(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
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
}
