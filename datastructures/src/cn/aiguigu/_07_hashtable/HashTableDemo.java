package cn.aiguigu._07_hashtable;

import java.util.Scanner;

/**
 * @author: YSL
 * @date: 2020/4/18 12:11
 * @description: 自己写哈希表
 */
public class HashTableDemo {
    public static void main(String[] args) {
        ForkHashTable forkHashTable = new ForkHashTable(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("***************");
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");
            System.out.println("***************");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Employee employee = new Employee(id, name);
                    forkHashTable.teacherAdd(employee);
                    break;
                case "list":
                    forkHashTable.teacherList();
                    break;
                case "find":
                    System.out.println("输入待查找的id");
                    int id2 = scanner.nextInt();
                    forkHashTable.teacherfindEmployeeByID(id2);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

/**
 * @Author: YSL
 * @Date: 2020/4/18 12:38
 * @description: 创建哈希表，用于管理多条链表
 */
class ForkHashTable {
    private EmployeeLinkedList[] employeeLinkedListArray;
    private int size;   //表示共有多少条链表

    public ForkHashTable(int size) {
        this.size = size;
        employeeLinkedListArray = new EmployeeLinkedList[size];
        //分别初始化每一条链表
        for (int i = 0; i < size; i++) {
            employeeLinkedListArray[i] = new EmployeeLinkedList();
        }
    }

    /**
     * @param emp: 需要被添加的雇员
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/18 13:06
     * @description: 将雇员添加到哈希表中
     */
    public void teacherAdd(Employee emp) {
        //根据员工的id，得到该员工应当添加到哪条链表
        int employeeLinkedListIndex = hashFunction(emp.id);
        //将emp添加到对应的链表中
        employeeLinkedListArray[employeeLinkedListIndex].selfAdd(emp);
    }

    /**
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/18 13:16
     * @description: 遍历所有的链表（遍历哈希表）
     */
    public void teacherList() {
        for (int i = 0; i < size; i++) {
            employeeLinkedListArray[i].selfList(i);
        }
    }

    /**
     * @param id: 待查找的id值
     * @return: void
     * @author: YSL
     * @date: 2020/4/18 14:44
     * @description: 根据输入的id查找雇员
     */
    public void teacherfindEmployeeByID(int id) {
        //使用散列函数确定到哪条链表查找
        int employeeLinkedListIndex = hashFunction(id);
        Employee emp = employeeLinkedListArray[employeeLinkedListIndex].teacherFindByID(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到该雇员，id=%d，name=%s\n", employeeLinkedListIndex, id, emp.name);
            return;
        }
        System.out.println("在哈希表中没有找到该雇员");
    }

    /**
     * @param id: 某个雇员的id值
     * @return: int
     * @Author: YSL
     * @Date: 2020/4/18 13:08
     * @description: 编写散列函数，使用一个简单的取模法
     */
    public int hashFunction(int id) {
        return id % size;
    }
}

/**
 * @Author: YSL
 * @Date: 2020/4/18 12:11
 * @description: 雇员类
 */
class Employee {
    public int id;
    public String name;
    public Employee next;   //默认为空

    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * @return: java.lang.String
     * @Author: YSL
     * @Date: 2020/4/18 12:31
     * @description: 我自己重写的方法，用于打印元素
     */
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

/**
 * @Author: YSL
 * @Date: 2020/4/18 12:16
 * @description: 雇员链表类（不带头节点的链表）
 */
class EmployeeLinkedList {
    private Employee head;  //不是头节点，而是直接指向第一个Employee。默认为空
    private Employee tail;  //指向链表最后一个节点。默认为空

    /**
     * @param emp: 被添加的雇员。这里假定雇员id是自增长，即id的分配总是从小到大
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/18 12:18
     * @description: 自己写的。添加雇员到链表。由于id是自增长，因此直接将雇员加入到链表的最后
     */
    public void selfAdd(Employee emp) {
        if (head == null) {
            head = emp;
            tail = head;
            return;
        }
        tail.next = emp;
        tail = tail.next;
    }

    /**
     * @param emp: 被添加的雇员。这里假定雇员id是自增长，即id的分配总是从小到大
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/18 12:24
     * @description: 老师写的。添加雇员到链表。由于id是自增长，因此直接将雇员加入到链表的最后
     */
    public void teacherAdd(Employee emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Employee currentEmployee = head;
        while (true) {
            if (currentEmployee.next == null) {
                break;
            }
            currentEmployee = currentEmployee.next;
        }
        //退出时直接将emp加入到链表
        currentEmployee.next = emp;     //之前这里有bug，没加next，导致每次都会替换掉而不是追加
    }

    /**
     * @param index:
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/18 12:28
     * @description: 我在老师的基础上修改的遍历链表方法
     */
    public void selfList(int index) {
        System.out.print("索引" + index + ":  ");
        if (head == null) {
            System.out.println("空链表");
            return;
        }
        Employee currentEmployee = head;
        while (currentEmployee != null) {
            System.out.print(" -> " + currentEmployee);
            currentEmployee = currentEmployee.next;
        }
        System.out.println();
    }

    /**
     * @param index: 第几条链表
     * @return: void
     * @Author: YSL
     * @Date: 2020/4/18 14:19
     * @description: 老师的原版遍历方法
     */
    public void teacherList(int index) {
        if (head == null) {
            System.out.println("第" + (index + 1) + "条链表为空");
            return;
        }
        System.out.println("第" + (index + 1) + "条链表为");
        Employee currentEmployee = head;
        while (true) {
            System.out.printf("=> id=%d name=%s\t", currentEmployee.id, currentEmployee.name);
            if (currentEmployee.next == null) {
                break;
            }
            currentEmployee = currentEmployee.next;
        }
        System.out.println();
    }

    /**
     * @param: id
     * @return: cn.aiguigu._07_hashtable.Employee
     * @author: YSL
     * @date: 2020/4/18 14:20
     * @description: 根据id查找雇员
     */
    public Employee teacherFindByID(int id) {
        if (head == null) {
            System.out.println("空链表");
            return null;
        }
        Employee currentEmployee = head;
        while (true) {
            if (currentEmployee.id == id) {
                break;  //找到，直接退出
            }
            if (currentEmployee.next == null) {
                currentEmployee = null; //没有找到，置为null
                break;
            }
            currentEmployee = currentEmployee.next;
        }
        return currentEmployee;
    }
}