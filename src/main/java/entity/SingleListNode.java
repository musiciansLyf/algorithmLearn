package entity;

/**
 * @ClassName liyufeng
 * @Description 单链表节点
 * @Author Administrator
 * @Date 2019/5/28 21:13
 * @Version 1.0
 **/
public class SingleListNode {
    public int val;
    public SingleListNode next;
    public SingleListNode(int v){
        this.val=v;
        next=null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public SingleListNode getNext() {
        return next;
    }

    public void setNext(SingleListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }
}
