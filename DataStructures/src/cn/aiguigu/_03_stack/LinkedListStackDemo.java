package cn.aiguigu._03_stack;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        Node node1 = new Node(5);
        stack.push(node1);
        stack.list();
        System.out.println(stack.pop());
        stack.list();
    }
}

class LinkedListStack {
    private Node head;

    public LinkedListStack() {
        head = new Node(-1);
    }

    public boolean isEmpty() {
        return this.head.getNext() == null;
    }

    public void push(Node node) {
        node.setNext(this.head.getNext());
        this.head.setNext(node);
    }

    public Node pop() {
        if (isEmpty()) {
            throw new RuntimeException("空栈，无法pop");
        }
        Node result = this.head.getNext();
        this.head.setNext(this.head.getNext().getNext());
        return result;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("空栈");
        }
        Node temp = this.head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

class Node {
    private int index;
    private Node next;

    public Node(int index) {
        this.index = index;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "index=" + index +
                '}';
    }
}
