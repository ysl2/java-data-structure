package cn.aiguigu._05_sort;

import java.util.Arrays;

/**
 * @author: YSL
 * @date: 2020/4/17 13:27
 * @description: 基数排序（桶排序）
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        System.out.println(Arrays.toString(arr));
        teacherRadixSortCode(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr: 待排序的数组
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/17 13:29
     * @description: 老师的基数排序代码
     */
    public static void teacherRadixSortCode(int[] arr) {
        //得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];   //先得到最大的数
            }
        }
        //然后得到最大的数的位数
        int maxLen = (max + "").length();
        //第一轮（针对每个元素的个位进行排序处理）
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //说明：
        //1_二维数组包含10个一维数组
        //2_为了防止在放入数据的时候数据溢出，则每个一维数组（桶）的大小定义为arr.length
        //3_基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //定义10个桶的计数器
        int[] bucketElementCounter = new int[10];
        //比如bucketElementCounter[0]记录的就是bucket[0]桶放入的数据个数
        //个人理解：bucketElementCounter[0]表示下标为0的桶里的元素个数
        for (int i = 0, n = 1; i < arr.length; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[j] / n % 10;
                //放到对应的桶中
                bucket[digitOfElement][bucketElementCounter[digitOfElement]] = arr[j];
                bucketElementCounter[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {   //挨个遍历每个桶
                if (bucketElementCounter[k] != 0) { //看看桶里有没有元素。如果有元素的话
                    for (int l = 0; l < bucketElementCounter[k]; l++) { //遍历桶里的元素
                        //取出元素放到arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                bucketElementCounter[k] = 0;    //看完之后把桶清空，准备下一次循环
            }
        }
    }
}
