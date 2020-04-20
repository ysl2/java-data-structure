package cn.aiguigu._08_tree.huffman.huffman_code;

/**
 * @author: YSL
 * @date: 2020/4/20 20:55
 * @description: 赫夫曼编码
 */
public class HuffmanCode {
    public static void main(String[] args) {

    }
}

/**
 * @author: YSL
 * @date: 2020/4/20 20:57
 * @description: 创建Node ,待数据和权值
 */
class Node implements Comparable<Node> {
    Byte data; // 存放数据(字符)本身，比如'a' => 97 ' ' => 32
    int weight; //权值, 表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }
    /**
     * @param o:
     * @return: int
     * @author: YSL
     * @date: 2020/4/20 21:15
     * @description: 重写比较器用于排序结点
     */
    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node [data = " + data + " weight=" + weight + "]";
    }

    /**
     * @return: void
     * @author: YSL
     * @date: 2020/4/20 21:17
     * @description: 前序遍历
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
}
