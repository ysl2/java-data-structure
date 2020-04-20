package cn.aiguigu._08_tree.threaded_binary_tree;

/**
 * @author: YSL
 * @date: 2020/4/19 21:49
 * @description: 线索二叉树
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();

        Node root = new Node(1, "宋江");
        Node node3 = new Node(3, "吴用");
        Node node6 = new Node(6, "卢俊义");
        Node node8 = new Node(8, "林冲");
        Node node10 = new Node(10, "关胜");
        Node node14 = new Node(14, "关胜a");

        root.setLeft(node3);
        root.setRight(node6);
        node3.setLeft(node8);
        node3.setRight(node10);
        node6.setLeft(node14);
        threadedBinaryTree.setRoot(root);

        //线索化
        threadedBinaryTree.teacherThreadedNodes();
        //遍历线索化二叉树
        threadedBinaryTree.teacherThreadList();
    }
}

/**
 * @author: YSL
 * @date: 2020/4/19 22:04
 * @description: 直接复制过来的二叉树类
 */
class ThreadedBinaryTree {
    private Node root;
    private Node pre = null;   //指向前驱节点

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    /**
     * @return: void
     * @author: YSL
     * @date: 2020/4/19 23:33
     * @description: 方法重载，用于封装同名带参方法
     */
    public void teacherThreadedNodes() {
        this.teacherThreadedNodes(root);
    }

    /**
     * @param node: 当前需要线索化的节点
     * @return: void
     * @author: YSL
     * @date: 2020/4/19 22:06
     * @description: 对二叉树进行中序线索化的方法
     * Tips:后序小提示，找到当前节点的父节点，把当前节点变成父节点的右节点即可
     */
    public void teacherThreadedNodes(Node node) {
        if (node == null) {
            return;
        }
        //左子树线索化
        teacherThreadedNodes(node.getLeft());
        //当前节点线索化[有难度]
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        /*
         * 难点就在当前结点的后继结点是父节点的，
         * 而父节点无法直接通过当前节点获得
         * 所以只能返回上层递归把它作为上层结点的前驱节点或者左节点
         */
        pre = node;
        //右子树线索化
        teacherThreadedNodes(node.getRight());
    }

    /**
     * @return: void
     * @author: YSL
     * @date: 2020/4/20 11:12
     * @description: 遍历线索化二叉树的方法
     */
    public void teacherThreadList() {
        Node node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
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

    /**
     * @param index: 待查找的索引
     * @return: Node
     * @author: YSL
     * @date: 2020/4/19 16:32
     * @description: 前序查找
     */
    public Node teacherPreOrderSearch(int index) {
        if (root != null) {
            return root.teacherPreOrderSearch(index);
        }
        return null;
    }

    /**
     * @param index: 带查找的索引
     * @return: Node
     * @author: YSL
     * @date: 2020/4/19 16:34
     * @description: 中序查找
     */
    public Node teacherInfixOrderSearch(int index) {
        if (root != null) {
            return root.teacherInfixOrderSearch(index);
        }
        return null;
    }

    /**
     * @param index: 带查找的索引
     * @return: Node
     * @author: YSL
     * @date: 2020/4/19 16:35
     * @description: 后序查找
     */
    public Node teacherPostOrderSearch(int index) {
        if (root != null) {
            return root.teacherPostOrderSearch(index);
        }
        return null;
    }

    /**
     * @param index: 待删除的索引
     * @return: void
     * @author: YSL
     * @date: 2020/4/19 17:15
     * @description: 删除节点
     */
    public void teacherDeleteNode(int index) {
        if (root == null) {
            return;
        }
        if (root.getIndex() == index) {
            root = null;
            return;
        }
        root.teacherDeleteNode(index);
    }
}
/**
 * @author: YSL
 * @date: 2020/4/19 21:59
 * @description: 直接把Node复制过来用
 */
class Node {
    private int index;
    private String name;
    private Node left;  //默认为null
    private Node right; //默认为null
    //说明
    //1. 如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
    //2. 如果rightType == 0 表示指向是右子树, 如果 1表示指向后继结点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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
     * @return: Node
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
     * @param index: 待查找的索引
     * @return: Node
     * @author: YSL
     * @date: 2020/4/19 16:17
     * @description: 中序查找
     */
    public Node teacherInfixOrderSearch(int index) {
        Node result = null;
        if (this.left != null) {
            result = this.left.teacherInfixOrderSearch(index);
        }
        if (result == null && this.index == index) {
            return this;
        }
        if (result == null && this.right != null) {
            result = this.right.teacherInfixOrderSearch(index);
        }
        return result;
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

    /**
     * @param index: 带查找的索引
     * @return: Node
     * @author: YSL
     * @date: 2020/4/19 16:22
     * @description: 后序查找
     */
    public Node teacherPostOrderSearch(int index) {
        Node result = null;
        if (this.left != null) {
            result = this.left.teacherInfixOrderSearch(index);
        }
        if (result == null && this.right != null) {
            result = this.right.teacherInfixOrderSearch(index);
        }
        if (result == null && this.index == index) {
            return this;
        }
        return result;
    }

    /**
     * @param index: 待查找的索引
     * @return: void
     * @author: YSL
     * @date: 2020/4/19 17:07
     * @description: 删除节点
     */
    public void teacherDeleteNode(int index) {
        if (this.left != null && this.left.index == index) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.index == index) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.teacherDeleteNode(index);
        }
        if (this.right != null) {
            this.right.teacherDeleteNode(index);
        }
    }
}