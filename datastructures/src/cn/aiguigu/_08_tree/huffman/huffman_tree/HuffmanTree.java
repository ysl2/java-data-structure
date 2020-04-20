package cn.aiguigu._08_tree.huffman.huffman_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: YSL
 * @date: 2020/4/20 17:16
 * @description: 赫夫曼树
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = teacherCreateHuffmanTree(arr);
        preOrder(root);
    }

    /**
     * @param root:
     * @return: void
     * @author: YSL
     * @date: 2020/4/20 20:09
     * @description: 编写一个前序遍历的方法
     */
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历~~");
        }
    }

    /**
     * @param arr: 待创建树的数组
     * @return: Node
     * @author: YSL
     * @date: 2020/4/20 17:33
     * @description: 此方法用于创建赫夫曼树
     */
    public static Node teacherCreateHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

/**
 * @author: YSL
 * @date: 2020/4/20 17:17
 * @description: 构造节点
 */
class Node implements Comparable<Node> {
    int value;  //结点权值
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * @return: void
     * @author: YSL
     * @date: 2020/4/20 20:09
     * @description: 写一个前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * @param o:
     * @return: int
     * @author: YSL
     * @date: 2020/4/20 17:32
     * @description: 重写比较器用于排序
     */
    @Override
    public int compareTo(Node o) {
        //从小到大进行排序
        return this.value - o.value;
    }
}
