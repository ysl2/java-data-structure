package cn.aiguigu._08_tree.huffman.huffman_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: YSL
 * @date: 2020/4/20 20:55
 * @description: 赫夫曼编码
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
    }

    /*
     * @param bytes: 接收字节数组
     * @return: java.util.List<cn.aiguigu._08_tree.huffman.huffman_code.Node>
     * @author: YSL
     * @date: 2020/4/24 9:41
     * @description:
     */
    private static List<Node> getNodes(byte[] bytes) {
        //1创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<Node>();
        //遍历 bytes , 统计 每一个byte出现的次数->map[key,value]
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) { // Map还没有这个字符数据,第一次
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        //把每一个键值对转成一个Node 对象，并加入到nodes集合
        //遍历map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
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
