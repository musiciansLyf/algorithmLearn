package list;

import entity.SingleListNode;

/**
 * @ClassName liyufeng
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/28 21:12
 * @Version 1.0
 **/
public class ReverseList {

    //就地反转，将第一个节点后的一个个节点依次反转
    public SingleListNode directly(SingleListNode head){
        //头结点为空，直接返回
        if(head==null){
        return head;
        }
        SingleListNode dummy=new SingleListNode(-1);
        //设置初始状态
        //头结点next执行第一个节点
        dummy.next=head;
        //pre指针执行第一个节点，并且一直指向第一个节点,即其位置不变，固定指向一个节点
        SingleListNode pre=head;
        //pCur为需要当前需要反转的节点，指向pre的next
        SingleListNode pCur=head.next;
        //当pre的next为空时，进第一个节点到最后时，反转结束
        while (pre.next==null){
            //修改各个结点的next指针
            pre.next=pCur.next;
            pCur.next=dummy.next;
            dummy.next=pCur;
            //pCur重新指向pre的next
            pCur=pre.next;
        }
        return dummy.next;
    }

    //新建一个单链表，使用头插法，在依次遍历原链表
    public SingleListNode headInsert(SingleListNode head){
        //头结点为空，直接返回
        if(head==null){
            return head;
        }
        //头结点
        SingleListNode dummy=new SingleListNode(-1);
        dummy.next=head;
        //pCur指向当前需要反转的节点
        SingleListNode pCur=head.next;
        while (pCur==null){
            //需要一个临时节点保存pCur的next，否则会丢失
            SingleListNode pTemp=pCur.next;
            pCur.next=dummy.next;
            dummy.next=pCur;
            pCur=pTemp;
        }
        return dummy.next;
    }
}
