package cn.aiguigu._06_search;

import java.util.ArrayList;

/**
 * @author: YSL
 * @date: 2020/4/17 15:20
 * @description: 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 10, 10, 10, 89, 1000, 1000};
        System.out.println(selfTryBinarySearch(arr, 0, arr.length, 10));
        int[] arr2 = {1, 8, 10, 10, 10, 10, 89, 1000, 1000};
        ArrayList<Integer> result = new ArrayList<Integer>();
        selfTryBinarySearch2(arr, 0, arr.length, 10, result);
        System.out.println(result.toString());
    }

    /**
     * @param arr:    待搜索的数组
     * @param left:   查找范围（左）
     * @param right:  查找范围（右）
     * @param target: 目标数字
     * @param result: 存储结果的集合
     * @return: java.util.ArrayList<java.lang.Integer>
     * @Author: YSL
     * @Date: 2020/4/17 18:17
     * @description: 返回相同元素的所有索引值
     */
    public static void selfTryBinarySearch2(int[] arr, int left, int right, int target, ArrayList<Integer> result) {
        if (left > right) {
            return;
        }
        int mid = (left + right) / 2;
        if (target == arr[mid]) {
            result.add(mid);
        }
        if (target > arr[mid]) {
            selfTryBinarySearch2(arr, mid + 1, right, target, result);
        }
        if (target < arr[mid]) {
            selfTryBinarySearch2(arr, left, mid - 1, target, result);
        }

    }

    /**
     * @param arr:    待查找的有序数组
     * @param left:   查找范围（左）
     * @param right:  查找范围（右）
     * @param target: 目标值
     * @return: int 查找结果
     * @Author: YSL
     * @Date: 2020/4/17 16:35
     * @description: 老师的二分查找代码
     */
    public static int teacherBinarySearchCode(int[] arr, int left, int right, int target) {
        return 0;
    }

    /**
     * @param arr:    待查找的有序数组
     * @param target: 目标值
     * @param left:   查找范围（左）
     * @param right:  查找范围（右）
     * @return: int 查找结果
     * @Author: YSL
     * @Date: 2020/4/17 15:22
     * @description: 自己尝试写二分查找。二分查找的前提是数据必须有序
     */
    public static int selfTryBinarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            throw new RuntimeException("未找到");
        }
        int mid = (left + right) / 2;
        if (target == arr[mid]) {
            return mid;
        }
        if (target > arr[mid]) {
            return selfTryBinarySearch(arr, mid + 1, right, target);
        }
        return selfTryBinarySearch(arr, left, mid - 1, target);
    }
}
