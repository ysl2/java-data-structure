package cn.aiguigu._06_search;

/**
 * @author: YSL
 * @date: 2020/4/17 18:45
 * @description: 插值查找。此算法样要求数组有序
 * 关键词：数值分析 线性插值 插值算法 自适应梯度下降
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(selfTryBinarySearch(arr, 0, arr.length - 1, 50));
    }

    /**
     * @param arr:    待查找的数组
     * @param left:   查找范围（左）
     * @param right:  查找范围（右）
     * @param target: 目标数字
     * @return: int 返回查找到的索引（如果没查找到，抛异常）
     * @throws: 没有查找到数字
     * @Author: YSL
     * @Date: 2020/4/17 18:48
     * @description: 插值法（在二分法的基础上修改）
     */
    public static int selfTryBinarySearch(int[] arr, int left, int right, int target) {
        if (left > right || target < arr[0] || target > arr[arr.length - 1]) {
            throw new RuntimeException("未找到");
        }
        //自适应算法，每次计算的mid都很接近target
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        //对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找，速度较快
        //关键字分布不均匀的情况下，该方法不一定比折半查找好
        if (target == arr[mid]) {
            return mid;
        }
        if (target > arr[mid]) {
            return selfTryBinarySearch(arr, mid + 1, right, target);
        }
        return selfTryBinarySearch(arr, left, mid - 1, target);
    }
}
