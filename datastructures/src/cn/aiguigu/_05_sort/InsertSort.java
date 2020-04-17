package cn.aiguigu._05_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 插入排序
 *
 * @author YSL
 * @date 2020/4/15 11:46
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr1 = getRamdomArray(10000, 1);
//        render(arr1);
//        long start1 = System.currentTimeMillis();
//        Integer[] integers = selfTryCode(arr1);
//        long end1 = System.currentTimeMillis();
//        int run1 = (int) (end1 - start1);
//        render(integers);
//        System.out.println();
//        int[] arr2 = getRamdomArray(10000, 1);
//        render(arr2);
//        long start2 = System.currentTimeMillis();
//        teacherSortCode(arr2);
//        long end2 = System.currentTimeMillis();
//        int run2 = (int) (end2 - start2);
//        render(arr2);
//        System.out.println();
//        System.out.println(run1);
//        System.out.println(run2);
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        render(arr);
        teacherSortCode(arr);
        render(arr);
        System.out.println();
    }

    /**
     * 用于生成随机数组
     *
     * @param number 随机数组的元素长度
     * @param seed   随机数的种子值
     * @return
     */
    public static int[] getRamdomArray(int number, int seed) {
        int[] arr = new int[number];
        Random r = new Random(seed);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (r.nextInt(number));
        }
        return arr;
    }
    /**
     * @param arr:
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/16 12:08
     * @description:老师的插入排序（改良版）
     */
    public static void teacherSortCode2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int index = i - 1;
            while (index >= 0 && value < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            //这里判断一下是否需要赋值
            if (index + 1 != i) {
                arr[index + 1] = value;
            }
        }
    }

    /**
     * 老师的插入排序代码（原版）
     *
     * @param arr
     */
    public static void teacherSortCode(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int index = i - 1;
            while (index >= 0 && value < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }

    /**
     * 自己尝试的插入排序
     *
     * @param arr 要交换的数组
     */
    public static Integer[] selfTryCode(int[] arr) {
        List<Integer> orderList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            //如果没有元素，直接插入。如果有元素，继续判断
            while (!orderList.isEmpty() && j < orderList.size()) {
                if (arr[i] < orderList.get(j)) {
                    break;  //只要待插入的数比当前的数小，就插入到前面
                }
                j++;    //如果待插入的数比当前的数大，就继续往后找，直到找到一个比待插入的数大的数，然后插入到前面
            }
            orderList.add(j, arr[i]);
            //两种情况，一种是找到了可以插入的位置，就直接插入到前面
            //或者是遍历了一遍没有找到插入位置，这时候说明待插入的数比任何数都大，应该直接放到最后面
        }
        return orderList.toArray(new Integer[orderList.size()]);
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

    /**
     * 打印一维数组
     *
     * @param arr
     */
    public static void render(Integer[] arr) {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
