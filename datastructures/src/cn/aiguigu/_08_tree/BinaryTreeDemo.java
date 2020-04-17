package cn.aiguigu._08_tree;

/**
 * @author: YSL
 * @date: 2020/4/19 10:14
 * @description: 二叉树的遍历（前、中、后）
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        Node root = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");
        Node node5 = new Node(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        binaryTree.teacherPreOrder();
        System.out.println();
        binaryTree.teacherInfixOrder();
        System.out.println();
        binaryTree.teacherPostOrder();
    }
}

/**
 * @author: YSL
 * @date: 2020/4/19 11:48
 * @description: 定义二叉树结构
 */
class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * @return: void
     * @author: YSL
     * @date: 2020/4/19 11:49
     * @description: 前序遍历
     */
    public void teacherPreOrder() {
        if (root != null) {
            root.teacherPreOrder();
            return;
        }
        System.out.println("空二叉树");
    }

    /**
     * @return: void
     * @author: YSL
     * @date: 2020/4/19 11:55
     * @description: 中序遍历
     */
    public void teacherInfixOrder() {
        if (root != null) {
            root.teacherInfixOrder();
            return;
        }
        System.out.println("空二叉树");
    }

    /**
     * @return: void
     * @author: YSL
     * @date: 2020/4/19 11:57
     * @description: 后序遍历
     */
    public void teacherPostOrder() {
        if (root != null) {
            root.teacherPostOrder();
            return;
        }
        System.out.println("空二叉树");
    }


}

/**
 * @author: YSL
 * @date: 2020/4/19 10:15
 * @description: 创建节点结构
 */
class Node {
    private int index;
    private String name;
    private Node left;  //默认为null
    private Node right; //默认为null

    public Node(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "index=" + index +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * @return: void
     * @author: YSL
     * @date: 2020/4/19 10:19
     * @description: 前序遍历的方法
     */
    public void teacherPreOrder() {
        System.out.println(this);   //先输出根节点
        //递归向左子树遍历
        if (this.left != null) {
            this.left.teacherPreOrder();
        }
        //递归向右子树遍历
        if (this.right != null) {
            this.right.teacherPreOrder();
        }
    }

    /**
     * @param index: 要查找的编号
     * @return: cn.aiguigu._08_tree.Node
     * @author: YSL
     * @date: 2020/4/19 13:49
     * @description: 前序查找，用于根据id进行前序查找并返回Node。如果找不到，返回null
     */
    public Node teacherPreOrderSearch(int index) {
        if (this.index == index) {
            return this;
        }
        Node result = null;
        if (this.left != null) {
            result = this.left.teacherPreOrderSearch(index);
        }
        if (result == null && this.right != null) {
            result = this.right.teacherPreOrderSearch(index);
        }
        return result;
    }

    /**
     * @return: void
     * @author: YSL
     * @date: 2020/4/19 10:25
     * @description: 中序遍历的方法
     */
    public void teacherInfixOrder() {
        if (this.left != null) {
            this.left.teacherInfixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.teacherInfixOrder();
        }
    }

    /**
     * @return: void
     * @author: YSL
     * @date: 2020/4/19 11:43
     * @description: 后序遍历的方法
     */
    public void teacherPostOrder() {
        if (this.left != null) {
            this.left.teacherPostOrder();
        }
        if (this.right != null) {
            this.right.teacherPostOrder();
        }
        System.out.println(this);
    }
}