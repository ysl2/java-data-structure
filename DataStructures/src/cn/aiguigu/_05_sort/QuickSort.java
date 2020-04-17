package cn.aiguigu._05_sort;

/**
 * @author: YSL
 * @date: 2020/4/16 14:16
 * @description: 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        render(arr);
        heimaQuickSortCode(arr, 0, arr.length - 1);
        render(arr);
        System.out.println();
        int[] arr2 = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        render(arr2);
        teacherQuickSort(arr2, 0, arr.length - 1);
        render(arr2);
    }

    /**
     * @param arr:   待排序的数组
     * @param left:  排序起始位置
     * @param right: 排序终止位置
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/16 15:31
     * @Description: 老师演示的快速排序，讲的乱七八糟的
     */
    public static void teacherQuickSort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        //尚硅谷的老师选的是中间的值作为base，和黑马不一样
        int base = arr[(left + right) / 2];
        while (i < j) {
            while (arr[i] < base) {
                i++;
            }
            while (arr[j] > base) {
                j--;
            }
            //如果i >= j，说明已经排好顺序了
            //此时base左边全部比base小，base右边全部base大
            if (i >= j) {
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            //下面这两个if是为了防止有一个值和中值相同而造成死循环
            //如果交换完之后，发现这个arr[i] == base，就前移
            if (arr[i] == base) {
                j--;
            }
            if (arr[j] == base) {
                i++;
            }
        }
        //如果i == j，必须i++，j--，否则出现栈溢出
        if (i == j) {
            i++;
            j--;
        }
        if (left < j) {
            teacherQuickSort(arr, left, j);
        }
        if (right > i) {
            teacherQuickSort(arr, i, right);
        }
    }

    /**
     * @param arr
     * @param left
     * @param right
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/16 14:52
     * @Description: b站黑马的快速排序
     * https://www.bilibili.com/video/BV1it41167v2?from=search&seid=9512656892759597719
     */
    public static void heimaQuickSortCode(int[] arr, int left, int right) {
        //如果左边大于右边，直接return
        if (left > right) {
            return;
        }
        //定义变量保存基准数
        int base = arr[left];
        //定义变量i。指向最左边
        int i = left;
        //定义变量j，指向最右边
        int j = right;
        //当i和j不相遇的时候，在循环中进行检索
        while (i != j) {
            //先由j从右向左检索比基准数小的，如果检索到比基准数小的就停下
            //如果检索到比基准数大或者相等的，就继续检索
            //先由j的原因是，先左找大于基准数如果在最右边方法失效
            //先由j开始检索以保证相遇位置的元素是小于基准数的
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //跳出循环说明i == j，就交换基准数的元素和相遇位置的元素
        //把相遇位置的元素赋值给基准数这个位置的元素
        arr[left] = arr[i];
        //把基准数赋值给相遇位置的元素
        arr[i] = base;
        //基准数在这里就归位了，左边的数都比他小，右边的数都比他大
        //重复上述动作
        heimaQuickSortCode(arr, left, i - 1);
        heimaQuickSortCode(arr, j + 1, right);
    }

    /**
     * @param arr:   待排序的数组
     * @param start: 数组的起始排序位置（如果是第一次递归，此值为0）
     * @param end:   数组的终止排序位置（如果是第一次递归，此值为arr.length）
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/16 14:18
     * @Description: 自己尝试写快速排序，有错误
     */
    public static void selfTryCode(int[] arr, int start, int end) {
        int i = start;
        int j = end - 1;
        int base = arr[start];
        int left;
        int right;
        while (i >= 0 && i < arr.length && j >= 0 && j <= arr.length && i <= j) {
            for (; i <= j && arr[i] < base; i++) {
            }
            for (; i <= j && arr[j] > base; j--) {
            }
            if (i == j) {
                int temp = arr[i];
                arr[i] = base;
                base = temp;
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        selfTryCode(arr, 0, i - 1);
        selfTryCode(arr, i + 1, end);
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
}
