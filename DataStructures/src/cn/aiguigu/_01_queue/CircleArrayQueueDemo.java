package cn.aiguigu._01_queue;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个环形队列
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);
        circleArrayQueue.addQueue(1);
        circleArrayQueue.addQueue(2);
        circleArrayQueue.addQueue(3);
        int queue = circleArrayQueue.getQueue();
        circleArrayQueue.addQueue(4);
        circleArrayQueue.addQueue(5);
        int queue2 = circleArrayQueue.getQueue();
        circleArrayQueue.addQueue(6);
        circleArrayQueue.showQueue();
        //进行到上面的时候，队列已经满了。所以再加两个测试满的情况
        circleArrayQueue.addQueue(6);
        circleArrayQueue.addQueue(6);
    }
}

class CircleArrayQueue {
    private int maxSize;
    private int front;  //指向队列的第一个元素，默认0
    private int rear;   //指向队列的最后一个元素的后一个位置.默认0
    private int[] arr;

    //构造器
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;    //将rear后移，必须考虑取模
    }

    //获取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无数据");
        }
        int element = arr[front];
        front = (front + 1) % maxSize;
        return element;
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        for (int i = front; i < front + queueSize(); i++) {
            System.out.printf("arr[%d]=%d\t", i % maxSize, arr[i % maxSize]);
        }
        System.out.println();
    }

    //显示队列的头数据，注意不取出
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return arr[front];
    }

    //求出当前队列有效数据的个数
    public int queueSize() {
        return (rear - front + maxSize) % maxSize;
    }
}
