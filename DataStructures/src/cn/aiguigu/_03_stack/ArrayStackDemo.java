package cn.aiguigu._03_stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
    }
}

class ArrayStack {
    private int maxSize;    //栈的大小
    private int[] stack;    //数组模拟栈
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，无元素");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + "\t");
        }
    }
}