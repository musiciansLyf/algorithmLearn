package list;

import entity.SingleListNode;

import javax.xml.transform.Source;
import javax.xml.transform.Templates;

//单链表实现
public class SingleLinkedList {
    //先初始化一个头结点，用于辅助定位，头结点可根据实际需求确定是否需要
    private SingleListNode head = new SingleListNode(-1);

    public SingleListNode getHead() {
        return head;
    }

    //添加节点到最后
    //1.先遍历链表，找到最后一个节点
    //2.将该节点的next指针指向新节点
    public void add(SingleListNode node){
        //因为头结点不能动，需要一个辅助指针，遍历链表
        SingleListNode temp = head;
        //遍历链表找到最后一个节点
        while (true){
            //最后一个节点的next指针为空
            if (temp.next == null){
                break;
            }
            //temp指针持续后移
            temp = temp.next;
        }
        //找到最后一一个节点，为其next指针指向新节点
        temp.next = node;
    }

    //按顺序添加节点到
    //1.先遍历链表，找到新节点的位置，仍需要辅助指针遍历
    //2.newNode.next = temp.next;
    //3.temp.next = newNode
    public void addSeq(SingleListNode node){
        //因为头结点不能动，需要一个辅助指针，遍历链表
        SingleListNode temp = head;
        //遍历链表找到插入位置
        while (true){
            //遍历到到最后一个节点都没有找到位置，则插入在最后一个节点后
            if (temp.next == null){
                break;
            }
            //这里按照从小到大插入，当temp.next大于新节点时，即找到插入位置
            if(temp.next.val > node.val){
                break;
                //始终得根据一个目标值进行比较
            }else if (temp.next.val == node.val){
                System.out.println("插入的值已存在");
                return;
            }
            //temp指针持续后移
            temp = temp.next;
        }
        //找到插入位置，调整next指针
        node.next = temp.next;
        temp.next = node;
    }

    //删除节点，根据val进行删除，修改类似，且修改不能修改val值，因为该值用来调整顺序，否则就是插入
    public void delete(SingleListNode node){
        //先判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //辅助指针，用于遍历找到删除的节点，不能为head.next，因为需要调整该节点的前一next指针，而该链表为单向的
        SingleListNode temp = head;
        //判断是否找到所需删除节点的标识符
        boolean flag = false;
        while (true){
            //遍历到最后一个节点
            if (temp.next == null){
                break;
            }
            //值相等，找到位置
            if (temp.next.val == node.val){
                flag = true;
                break;
            }
            //辅助指针后移
            temp = temp.next;
        }
        //根据标识符flag判断是否找到位置
        if (flag){
            //跳过所需删除的节点
            temp.next = temp.next.next;
        }else{
            System.out.println("未找到所需删除的节点");
        }
    }

    //获取单链表有效节点数，不包含头结点
    /*
     * @Param 单链表的头结点
     * @Return 有效节点数
     **/
    public int size(SingleListNode head){
        //判断是否为空
        if (head.next == null){
            return 0;
        }
        //辅助指针
        SingleListNode temp = head.next;
        //有效节点个数
        int count = 0;
        //当下一个节点不等于空，先进行++，所以最后一个节点不需要进入循环体
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    //查找单链表倒数第n个节点
    /* 1.先获取单链表的邮箱节点数
     * 2.从链表遍历到第(size-index),就是所需节点
     * @Param [head, index],head为单链表的头结点，index为倒数第index个
     * @Return entity.SingleListNode
     **/
    public SingleListNode getDesc(SingleListNode head, int index){
        //获取有效节点数
        int size = size(head);
        //判断index是否大于有效节点数
        if (index > size || index <= 0){
            System.out.println("所求位置超出有效个数");
            return null;
        }
        //辅助指针
        SingleListNode temp = head.next;
        //遍历到倒数index位置
        for (int i = 0; i < (size-index); i++) {
            //辅助指针后移
            temp = temp.next;
        }
        return temp;
    }

    //遍历链表
    public void list(){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //同样需要一个辅助指针指向遍历的节点
        SingleListNode temp = head.next;
        //有效节点数
        int size = size(head);
        System.out.println("有效节点数为" + size);
        while (true) {
            //判断当前节点是否为最后一个节点
            if (temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //指针后移
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        //测试
        SingleLinkedList list = new SingleLinkedList();
        SingleListNode node1 = new SingleListNode(1);
        SingleListNode node2 = new SingleListNode(2);
        SingleListNode node3 = new SingleListNode(3);
        SingleListNode node4 = new SingleListNode(1);

        //添加至链表
        list.addSeq(node1);
        list.addSeq(node4);
        list.addSeq(node3);
        list.addSeq(node2);
        //遍历链表
        list.list();
/*        //删除节点
        SingleListNode node5 = new SingleListNode(1);
        list.delete(node5);
        System.out.println("删除后遍历：");
        list.list();*/
        //获取倒数第2个节点
        SingleListNode head = list.getHead();
        SingleListNode desc = list.getDesc(head,4);
        System.out.println("倒数第二个节点为：" +  desc);

    }
}
