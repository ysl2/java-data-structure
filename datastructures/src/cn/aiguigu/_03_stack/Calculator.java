package cn.aiguigu._03_stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "7-6-1-8";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char[] chs = expression.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            //如果是数字，入栈
            if (!ArrayStack2.isOper(chs[i])) {
                String keepNumber = "";
                keepNumber += chs[i];
                int j = i;
                while (j + 1 < chs.length && !ArrayStack2.isOper(chs[j + 1])) {
                    keepNumber += chs[j + 1];
                    i++;
                    j++;
                }
                numStack.push(Integer.parseInt(keepNumber));
                continue;
            }
            //如果是操作符，但是操作符栈空
            if (operStack.isEmpty()) {
                operStack.push(chs[i]);
                continue;
            }
            //如果是操作符，但是操作符栈不空
            //需要比较优先级
            if (ArrayStack2.priority(chs[i]) > ArrayStack2.priority(operStack.peek())) {
                operStack.push(chs[i]);
                continue;
            }
            num2 = numStack.pop();
            num1 = numStack.pop();
            oper = operStack.pop();
            res = ArrayStack2.cal(num1, num2, oper);
            numStack.push(res);
            operStack.push(chs[i]);
        }
        while (!operStack.isEmpty()) {
            num2 = numStack.pop();
            num1 = numStack.pop();
            oper = operStack.pop();
            res = ArrayStack2.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println(res);
    }
}

class ArrayStack2 {
    private int maxSize;    //栈的大小
    private int[] stack;    //数组模拟栈
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        return value;
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

    //返回运算符的优先级，优先级是由程序员来确定，优先级使用数字来表示
    //数字越大，优先级就越高
    public static int priority(int oper) {
        switch (oper) {
            case '*':
            case '/':
                return 1;
            case '+':
            case '-':
                return 0;
            default:
                return -1;
        }
    }

    //判断是否是一个运算符
    public static boolean isOper(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    public static int cal(int num1, int num2, int oper) {
        switch (oper) {
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
        }
        throw new RuntimeException("cal():没能计算出答案");
    }
}