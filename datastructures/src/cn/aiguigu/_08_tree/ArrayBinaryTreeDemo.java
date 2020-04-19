package cn.aiguigu._08_tree;

/**
 * @author: YSL
 * @date: 2020/4/19 18:40
 * @description: 顺序存储二叉树（数组与树的相互转换）
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.teacherPreOrder(0);
    }
}
/**
 * @author: YSL
 * @date: 2020/4/19 18:42
 * @description: 编写一个ArrayBinaryTree类，实现顺序存储二叉树
 */
class ArrayBinaryTree {
    private  int[] arr; //存储数据节点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }
    
    /**
     * @param index: 数组下标，也就是树的索引
     * @return: void
     * @author: YSL
     * @date: 2020/4/19 18:44
     * @description: 完成顺序存储二叉树的前序遍历
     */
    public void teacherPreOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        if (2 * index + 1 < arr.length) {   //遍历左子树
            teacherPreOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {   //遍历右子树
            teacherPreOrder(2 * index + 2);
        }
    }
}