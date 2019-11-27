package lock;

/**
 * @ClassName liyufeng
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/28 20:37
 * @Version 1.0
 **/
/*
 * 基于synchronize实现读写锁
 **/
public class ReadAndWriteLock {
    //使用volatile关键，保证可见性，以及避免重排序
    private volatile int read;
    private volatile int write;
    public ReadAndWriteLock(){
        //初始化时为0
        this.read=0;
        this.write=0;
    }

    public synchronized void readLock() throws InterruptedException {
        //当有其他线程占有写锁时，等待
        if (this.write>0){
            wait();
        }
        read++;
    }

    public synchronized void readUnLock(){
        read--;
        //释放资源，唤醒所有等待该对象资源的线程
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        //当有其他线程占有读锁或许写锁时，都进行等待
        if(this.read>0||this.write>0){
            wait();
        }
        write++;
    }

    public synchronized void writeUnLock(){
        write--;
        notifyAll();
    }
}
