package cn.aiguigu._06_search;

import java.util.Arrays;

/**
 * @author: YSL
 * @date: 2020/4/17 21:02
 * @description: 斐波那契查找法
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 600, 1000, 1234};
        try {
            System.out.println(teacherfibSearch(arr, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        int[] arr2 = {1, 8, 10, 89, 600, 1000, 1234};
        try {
            System.out.println(selfReviewChangeCode(arr2, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return: int[] 斐波那契数列
     * @Author: YSL
     * @Date: 2020/4/17 21:08
     * @description: 采用非递归方式获取一个斐波那契数列
     * 因为后面我们mid = low + F(k - 1) - 1，需要用到斐波那契数列，因此我们需要先获取到一个斐波那契数列
     */
    public static int[] teacherfib() {
        int[] f = new int[maxSize];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * @param arr:    数组
     * @param target: 需要查找的关键码（值）
     * @return: int 返回对应的下标。如果没有，抛出异常
     * @Author: YSL
     * @Date: 2020/4/17 21:11
     * @description: 使用非递归的方式编写斐波那契查找算法
     */
    public static int teacherfibSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;  //表示斐波那契数列分割数值的下标
        int mid = 0;    //存放mid值
        int[] f = teacherfib(); //获取到斐波那契数列
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]的值可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际需求使用arr数组最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        //使用while来循环处理，找到我们的数key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (target < temp[mid]) {  //说明应该继续向数组的左边找
                high = mid - 1;
                //全部元素 = 前面的元素 + 后面的元素
                //f[k] = f[k - 1] + f[k - 2]
                //因为前面有f[k - 1]个元素，所以可以继续拆分f[k - 1] = f[k - 2] + f[k - 3]
                //即在f[k - 1]的前面继续查找 k--
                //即下次循环mid = f[k - 1 - 1] - 1
                k--;
            } else if (target > temp[mid]) {   //向数组的后面查找
                low = mid + 1;
                //全部元素 = 前面的元素 + 后面的元素
                //f[k] = f[k - 1] + f[k - 2]
                //因为后面有f[k - 2]个元素，所以可以继续拆分f[k - 2] = f[k - 3] + f[k - 4]
                //即在f[k - 2]的后面继续查找 k -= 2
                //即下次循环mid = f[k - 1 - 2] - 1
                k -= 2;
            } else {    //找到
                //需要确定，返回的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        throw new RuntimeException("未找到");
    }

    /**
     * @param arr:    待排序的数组
     * @param target: 目标数字
     * @return: int 返回索引
     * @Author: YSL
     * @Date: 2020/4/17 22:58
     * @description: 在老师的基础上修改了一下
     */
    public static int selfReviewChangeCode(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;  //表示斐波那契数列分割数值的下标
        int mid = 0;    //存放mid值
        int[] f = teacherfib(); //获取到斐波那契数列
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]的值可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际需求使用arr数组最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        //使用while来循环处理，找到我们的数key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (target < temp[mid]) {  //说明应该继续向数组的左边找
                high = mid - 1;
                //全部元素 = 前面的元素 + 后面的元素
                //f[k] = f[k - 1] + f[k - 2]
                //因为前面有f[k - 1]个元素，所以可以继续拆分f[k - 1] = f[k - 2] + f[k - 3]
                //即在f[k - 1]的前面继续查找 k--
                //即下次循环mid = f[k - 1 - 1] - 1
                k--;
                continue;
            }
            if (target > temp[mid]) {   //向数组的后面查找
                low = mid + 1;
                //全部元素 = 前面的元素 + 后面的元素
                //f[k] = f[k - 1] + f[k - 2]
                //因为后面有f[k - 2]个元素，所以可以继续拆分f[k - 2] = f[k - 3] + f[k - 4]
                //即在f[k - 2]的后面继续查找 k -= 2
                //即下次循环mid = f[k - 1 - 2] - 1
                k -= 2;
                continue;
            }
            //找到
            //需要确定，返回的是哪个下标
            if (mid <= high) {
                return mid;
            }
            return high;
        }
        throw new RuntimeException("未找到");
    }
}
