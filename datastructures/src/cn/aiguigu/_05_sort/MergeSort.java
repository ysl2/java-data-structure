package cn.aiguigu._05_sort;

import java.util.Arrays;

/**
 * @author: YSL
 * @date: 2020/4/16 19:18
 * @description: 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        System.out.println(Arrays.toString(arr));
        teacherMergeSortCode(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    /**
     * @param arr:
     * @param left:
     * @param right:
     * @param temp:
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/17 11:40
     * @description: 老师写的分 + 合的方法
     */
    public static void teacherMergeSortCode(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        //向左递归进行分解
        teacherMergeSortCode(arr, left, mid, temp);
        //向右递归进行分解
        teacherMergeSortCode(arr, mid + 1, right, temp);
        //到合并
        teacherMergeCode(arr, left, mid, right, temp);
    }

    /**
     * @param arr:   待排序的数组
     * @param left:  数组左端索引
     * @param mid:   中间索引
     * @param right: 数组右端索引
     * @param temp   : 中转的数组
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/16 19:23
     * @description: 老师的归并排序代码（合并的方法）
     */
    public static void teacherMergeCode(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;   //左边有序序列的初始索引
        int j = mid + 1;    //右边有序序列的初始索引
        int t = 0;  //指向temp数组的当前索引

        //先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) { //继续
            //如果左边的有序序列的当前元素小于等于右边有序序列的当前元素
            //就将左边的当前元素拷贝到temp数组
            //然后t++，i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {    //反之，将右边有序序列的当前元素填充到temp数组
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) {  //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {  //右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t++;
            j++;
        }
        //将temp数组的元素拷贝到array
        //注意，不是每次拷贝都拷贝所有
        t = 0;
        int tempIndex = left;
        while (tempIndex <= right) {
            arr[tempIndex] = temp[t];
            t++;
            tempIndex++;
        }
    }
}
