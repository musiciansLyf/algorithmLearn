package queue;

/**
 * @ClassName liyufeng
 * @Description 数组模拟队列
 * @Author Administrator
 * @Date 2019/6/2 10:26
 * @Version 1.0
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        ArrayQueue arrayQueue = new ArrayQueue(3);
        //添加元素
        arrayQueue.addQueue(1);
        //显示第一个元素
        arrayQueue.showFront();
        //显示所有元素
        arrayQueue.listQueue();
        //取一个元素
        int temp = arrayQueue.getQueue();
        System.out.println("取出的元素为：" + temp);
        //再次取，此时为空，应该报错
        //arrayQueue.getQueue();
        //多次存，判断是否满，应该报错
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(1);//这里报错
        arrayQueue.addQueue(1);
    }
}


class ArrayQueue{
    //队列最大容量，用于初始化数组
    private int maxSize;
    //尾指针，添加元素时使用
    private int rear;
    //头指针，取元素时使用
    private int front;
    private int[] array;

    //构造一个初始队列
    public ArrayQueue(int ms){
        maxSize = ms;
        array = new int[maxSize];
        //队列为空时，为-1
        rear = -1;
        front = -1;
    }

    //判断是否存满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加一个元素
    public void addQueue(int data){
        //先判断是否存满
        if (isFull() == true){
            throw new RuntimeException("队列已满，不能再添加数据");
        }else {
            //尾指针后移
            rear++;
            array[rear]=data;
        }
    }

    //取一个元素
    public int getQueue(){
        //判断是否为空
        if (isEmpty() == true){
            throw new RuntimeException("队列为空，不能取元素");
        }
        //头指针后移
        front++;
        return array[front];
    }

    //显示所有数据
    public void listQueue(){
        //判断是否为空
        if (isEmpty() == true){
            throw new RuntimeException("队列为空");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i +"]:"+ array[i]);
        }
    }

    //显示头元素
    public void showFront(){
        //判断是否为空
        if (isEmpty() == true){
            throw new RuntimeException("队列为空");
        }
        System.out.println("头元素为：" + array[front+1]);
    }
}