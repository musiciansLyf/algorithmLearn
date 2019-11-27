package queue;

import java.util.*;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName liyufeng
 * @Description 环形数组模拟队列
 * @Author Administrator
 * @Date 2019/6/2 14:26
 * @Version 1.0
 **/
/*
 * 对之前一般数组模拟队列进行调整：
 * 1.front：由原来指向头元素的前一个元素，变为指向头元素，初始值为0
 * 2.rear：有原来指向最后一个元素，变为指向最后一个元素的后一个位置，约定空一个位置，用于约定判断是否满，初值为0
 * 3.已满：根据实际场景模拟，满只能有一种情况，环形数组里，rear和front相邻：(rear+1)%maxSize = front
 * 4.空：每次取一个元素，front指针后移一个位置，即rear == front
 * 5.有效元素数：最多有maxSize-1-1个，实际场景模拟的：(rear+maxSize-front) % maxSize //例如rear=1，front=0时 为一个  有效数肯定不大于maxSize，所以用取模法
 **/
public class CircleQueueDemo {

    public static void main(String[] args) {
        ConcurrentHashMap c;

        //测试
        CircleQueue circleQueue = new CircleQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s（show）：显示队列");
            System.out.println("h（head）：显示头元素");
            System.out.println("a（add）：添加元素");
            System.out.println("g（get）：取出元素");
            System.out.println("e（exit）：退出");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    circleQueue.listQueue();
                    break;
                case 'h':
                    circleQueue.showFront();
                    break;
                case 'a':
                    System.out.print("输入一个数字：");
                    int value = scanner.nextInt();
                    circleQueue.addQueue(value);
                    break;
                case 'g':
                    int res = circleQueue.getQueue();
                    if (res != 0) {
                        System.out.println("取出的数字是：" + res);
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }
}

class CircleQueue {
    //队列最大容量，用于初始化数组
    private int maxSize;
    //尾指针，添加元素时使用，指向最后一个元素的后一个位置，约定空一个位置，用于约定判断是否满，初值为0
    private int rear;
    //头指针，取元素时使用，变为指向头元素，初始值为0
    private int front;
    private int[] array;

    //构造一个初始队列
    public CircleQueue(int ms) {
        maxSize = ms;
        array = new int[maxSize];
        //队列为空时，为0
        rear = 0;
        front = 0;
    }

    //判断是否存满,根据实际场景模拟，满只能有一种情况，环形数组里，rear和front相邻：(rear+1)%maxSize = front
    public boolean isFull() {
        return (rear + 1) % maxSize ==front;
    }

    //判断是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加一个元素
    public void addQueue(int data) {
        //先判断是否存满
        if (isFull() == true) {
            //throw new RuntimeException("队列已满，不能再添加数据");
            //为了测试使用，这里为打印输出信息
            System.out.println("队列已满，不能再添加数据");
            return;
        }
        //rear本身执行嘴最后一个元素的后一个位置，这里先将数据加入
        array[rear] = data;
        //考虑数组边界因素，这里必须进行取模
        rear = (rear+1) % maxSize;
    }

    //取一个元素
    public int getQueue() {
        //判断是否为空
        if (isEmpty() == true) {
            //throw new RuntimeException("队列为空，不能取元素");
            //为了测试使用，这里为打印输出信息
            System.out.println("队列为空，不能取元素");
            return 0;
        }
        //front本身指向头元素，这里先将数据取出用临时变量保存，因为需要进行front后移
        int temp = array[front];
        //front后移，同样需要取模
        front = (front+1) % maxSize;
        return temp;
    }

    //显示所有数据
    public void listQueue() {
        //判断是否为空
        if (isEmpty() == true) {
            throw new RuntimeException("队列为空");
        }
        //直接遍历会遍历之前取出的数据，这里应该，从front开始，遍历所有有效数据
        for (int i = front; i < front + size(); i++) {
            //这里需要对i，即下标选择进行取模
            System.out.println("array[" + (i % maxSize) + "]:" + array[i % maxSize]);
        }
    }

    //求有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //显示头元素
    public void showFront() {
        //判断是否为空
        if (isEmpty() == true) {
            throw new RuntimeException("队列为空");
        }
        System.out.println("头元素为：" + array[front]);
    }
}
