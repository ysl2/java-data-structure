package cn.aiguigu._03_stack;

import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String nifixExpression = "1+(2+3)*4-5";
        String s = convertNifixToPostfix(nifixExpression);
        System.out.println(s);
        int result = caculatePostfixExpression(s);
        System.out.println(result);
    }

    //用于将中缀表达式转换成后缀表达式
    public static String convertNifixToPostfix(String nifixExpression) {
        char[] chs = nifixExpression.toCharArray();
        Stack<Character> s1 = new Stack<Character>();
        Stack<String> s2 = new Stack<String>();
        for (int i = 0; i < chs.length; i++) {
            //如果是数字，检查直到后面不存在数字，然后压入s2栈
            if (chs[i] >= '0' && chs[i] <= '9') {
                String temp = "" + chs[i];
                int j = i + 1;
                while (j < chs.length && chs[j] >= '0' && chs[j] <= '9') {
                    temp += chs[j];
                    i = j;
                    j++;
                }
                s2.push(temp);
                continue;
            }
            //如果是左括号，直接压入s1
            if (chs[i] == '(') {
                s1.push(chs[i]);
                continue;
            }
            //如果是右括号，依次弹出s1的元素并压入s2，直到遇到右括号，将这一对括号丢弃
            if (chs[i] == ')') {
                while (s1.peek() != '(') {
                    s2.push(s1.pop() + "");
                }
                s1.pop();
                continue;
            }
            //如果是运算符
            while (true) {
                //如果s1为空或者s1的栈顶是左括号，直接压入栈
                //如果比较优先级比栈顶的优先级高，也压栈
                if (s1.empty() || s1.peek() == '(' || priority(chs[i]) > priority(s1.peek())) {
                    s1.push(chs[i]);
                    break;
                }
                //否则，将s1栈顶的运算符出栈压入到s2，再次转到上一个if进行比较
                s2.push(s1.pop() + "");
            }
        }
        //把s1中剩下的所有元素依次弹出压入s2
        while (!s1.empty()) {
            s2.push(s1.pop() + "");
        }
        String result = "";
        //倒序输出s2
        while (!s2.empty()) {
            result = s2.pop() + " " + result;
        }
        return result;
    }

    //用于计算后缀表达式的结果
    public static int caculatePostfixExpression(String postfixExpression) {
        String[] strs = postfixExpression.split(" ");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < strs.length; i++) {
            //匹配到数字，进栈
            if (strs[i].matches("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])")) {
                stack.push(strs[i]);
                continue;
            }
            //匹配到符号，弹出两个数，计算
            int num2 = Integer.parseInt(stack.pop());
            int num1 = Integer.parseInt(stack.pop());
            String res = PolandNotation.cal(num1, num2, strs[i].charAt(0)) + "";
            stack.push(res);
        }
        return Integer.parseInt(stack.peek());
    }

    //计算数字
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
}
