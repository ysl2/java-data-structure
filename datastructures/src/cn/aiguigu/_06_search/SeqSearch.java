package cn.aiguigu._06_search;

/**
 * @author: YSL
 * @date: 2020/4/17 15:01
 * @description: 线性查找法
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        try {   //返回的是数组的下标值
            System.out.println(selfTrySearchCode(arr, -1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param arr: 需要被查找的数组
     * @param target: 查找目标
     * @return: int 找到的结果（数组索引值）
     * @Author: YSL
     * @Date: 2020/4/17 15:03
     * @description: 自己尝试写的线性查找
     */
    public static int selfTrySearchCode(int[] arr, int target) {
        int result = 0;
        boolean flag = false;   //判断是否找到了数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result = i;
                flag = true;
            }
        }
        if (flag == false) {
            throw new RuntimeException("未找到");
        }
        return result;
    }
}
