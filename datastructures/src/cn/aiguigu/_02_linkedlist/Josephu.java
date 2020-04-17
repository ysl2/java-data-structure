package cn.aiguigu._02_linkedlist;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1, 2);
    }
}

//创建一个环形的单向链表
class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first = null;
    private int nums = 0;

    public void addBoy(int nums) {
        this.nums = nums;
        if (nums < 1) {
            System.out.println("小孩数量不能小于1");
            return;
        }
        Boy curBoy = first;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历环形链表
    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.println(curBoy);
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //根据用户的输入计算小孩出圈的顺序

    /**
     * a
     *
     * @param startNo  表示从第几个小孩开始数
     * @param countNum 表示数几下
     */
    public void countBoy(int startNo, int countNum) {
        if (nums == 1) {
            System.out.println("链表中只有一个小孩");
            return;
        }
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        Boy helper = first;
        //先确定first的位置
        if (startNo == 1) {
            while (true) {
                if (helper.getNext() == first) {
                    break;
                }
                helper = helper.getNext();
            }
        } else {
            for (int i = 0; i < startNo - 1; i++) {
                helper = first;
                first = first.getNext();
            }
        }
        System.out.println("first: " + first);
        System.out.println("helper: " + helper);
        System.out.println("出圈队列：");
        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first);
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println(first);
        first.setNext(null);
    }
}

//基本节点类
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
