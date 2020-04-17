package cn.aiguigu._05_sort;

/**
 * @author: YSL
 * @date: 2020/4/16 19:18
 * @description: 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
    }

    /**
     * @param arr:   待排序的数组
     * @param left:  数组左端索引
     * @param mid:   中间索引
     * @param right: 数组右端索引
     * @param temp : 临时数组
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/16 19:23
     * @Description: 老师的归并排序代码（合并的方法）
     */
    public static void taacherMergeSortCode(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;   //左边有序序列的初始索引
        int j = mid + 1;    //右边有序序列的初始索引
        int t = 0;  //指向temp数组的当前索引

    }
}
