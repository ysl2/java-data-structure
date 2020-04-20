package cn.aiguigu._08_tree;

import java.util.Arrays;

/**
 * @author: YSL
 * @date: 2020/4/20 14:54
 * @description: 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        //升序排序
        int[] arr = {4, 6, 8, 5, 9};
        teacherHeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr: 待排序的数组
     * @return: void
     * @author: YSL
     * @date: 2020/4/20 14:55
     * @description: 升序堆排序。（升序做大顶堆，降序做小顶堆。此处为升序排序）
     */
    public static void teacherHeapSort(int[] arr) {
        //1).将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) { //arr.length / 2 - 1是最后一个非叶子节点
            teacherAdjustHeap(arr, i, arr.length);
        }
        /*
         *2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
         *3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
         */
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            teacherAdjustHeap(arr, 0, j);
        }
    }

    /**
     * @param arr:   待调整的的数组
     * @param i:     非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整，length在逐渐减少
     * @return: void
     * @author: YSL
     * @date: 2020/4/20 14:59
     * @description: 调整顺序，使成为大顶堆
     */
    public static void teacherAdjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];  //暂存此非叶子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {  //左子节点的值小于右子节点的值
                k++;    //让k指向右子节点
            }
            if (arr[k] > temp) {    //如果子节点的值大于父节点
                arr[i] = arr[k];
                i = k;  //i在这里发生了变化，因此这个i已经不是原来的i了
                //换位置之后的i实际上指向的是当前节点
            } else {
                break;
                //如果两个子节点的值都小于父节点，说明已经全部换完了
                //但是此时之前的arr[i]还没有填到相应的位置
            }
        }
        arr[i] = temp;  //将原先的arr[i]填到循环之后的位置
    }
}
