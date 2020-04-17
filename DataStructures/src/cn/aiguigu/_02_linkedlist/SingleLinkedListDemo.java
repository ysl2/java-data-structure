package cn.aiguigu._02_linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero3);

        singleLinkedList.list();
//        SingleLinkedList.reverseList(singleLinkedList.getHead());
        System.out.println();
//        singleLinkedList.list();
        SingleLinkedList.reversePrint(singleLinkedList.getHead());
//        System.out.println(SingleLinkedList.getLength(singleLinkedList.getHead()));
//
//        HeroNode newHeroNode = new HeroNode(2, "小卢", "麒麟");
//        singleLinkedList.update(newHeroNode);
//        System.out.println();
//        singleLinkedList.list();
//
//        singleLinkedList.del(1);
//        System.out.println();
//        singleLinkedList.list();
//
//        singleLinkedList.del(4);
//        System.out.println();
//        singleLinkedList.list();
//
//        System.out.println();
//        HeroNode result = SingleLinkedList.findLastIndexNode(singleLinkedList.getHead(), 1);
//        System.out.println(result);
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //按照索引顺序添加节点到单向链表
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;   //标识要添加的编号是否已经存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                //编号已经存在，因此改变标记，不让继续添加
                flag = true;
                break;
            }
            temp = temp.next;   //后移
        }
        if (flag) {
            System.out.printf("编号%d已经存在，不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //遍历链表
    public void list() {
        if (head.next == null) {
            System.out.println("空链表");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 获取单链表的节点的个数（如果是带头节点的链表，不统计头节点）
     *
     * @param head 链表的头节点
     * @return 有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head == null) { //空链表
            return 0;
        }
        int sum = 0;
        HeroNode temp = head.next;  //注意不要统计头节点
        while (temp != null) {
            sum++;
            temp = temp.next;
        }
        return sum;
    }

    //查找单链表中的倒数第k个节点
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (index <= 0 || head.next == null) {
            return null;
        }
        int sum = SingleLinkedList.getLength(head);
        if (index > sum) {
            return null;
        }
        HeroNode temp = head.next;  //不包含头节点
        for (int i = 0; i < (sum - index); i++) {
            temp = temp.next;
        }
        return temp;
    }

    //倒序打印，利用栈结构
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        HeroNode cur = head.next;
        Stack<HeroNode> stack = new Stack<HeroNode>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    //将单链表进行翻转
    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return; //如果是空链表或者只有一个元素，不需要进行操作
        }
        HeroNode cur = head.next;  //定义辅助指针用于帮助遍历原来的链表
        HeroNode next = null; //指向当前节点cur的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while (cur != null) {
            next = cur.next;    //先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;    //将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur连接到新的链表上
            cur = next; //让cur后移
        }
        //将head.next指向reverseHead.next，实现单链表的翻转
        head.next = reverseHead.next;
    }

    //根据编号修改节点信息（编号不能修改，其他的可以改）
    public void update(HeroNode newheroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;   //表示是否找到了该节点
        while (true) {
            if (temp == null) {
                break;  //此时到了链表的最后
            }
            if (temp.no == newheroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newheroNode.name;
            temp.nickname = newheroNode.nickname;
        } else {
            System.out.printf("没有找到以%d为编号的节点\n", newheroNode.no);
        }
    }

    //根据编号删除节点
    public void del(int no) {
        if (head.next == null) {
            System.out.println("空链表，不能删除元素");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("链表中没有包含以%d为编号的节点\n", no);
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
