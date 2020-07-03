package dataStructure;

/**
 * Created with IntelliJ IDEA.
 * Description:设计链表（单链表）
 * User:wanghuimin
 * Date:2020-04-15
 * Time:15:42
 */
/**
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3。
 */
//定义节点信息,不带傀儡节点的单向链表
class Nodes {
    public int val;
    public Nodes next;//地址引用

    public Nodes(int val) {
        this.val = val;
        this.next=null;
    }
}

    public class MyLinkedList {
        //定义头节点和尾部节点
        public Nodes head = null;
        public Nodes tail = null;

        //构造方法知识进行初始化
        public MyLinkedList() {
            this.head = head;
            this.tail = this.head;
        }

        //实现方法（头插）
        public void addAtHead(int val) {
            //先生成一个节点
            Nodes node = new Nodes(val);
            //第一次插入
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            //链表中已经存在元素
            node.next = head;
            head = node;

        }
        //尾插
        public void addAtTail(int val) {
            Nodes node=new Nodes(val);
            //说明链表没有元素
            if(tail==null){
                tail.next=node;
                tail=node;
                return;
            }
            tail.next=node;
            tail=node;
        }
        //输出链表
        public void display(){
            Nodes cur=this.head;
            while(cur!=null){
                System.out.print(cur.val+" ");
                cur=cur.next;
            }
        }

        //获取index位置的元素，没有就是-1
        public int get(int index) {
            //先判断位置是否合法
            if(index<0){
                return -1;
            }
            Nodes cur=this.head;
            int count=0;
            int ret=-1;
            while(cur!=null){
                if(count!=index){
                    cur=cur.next;
                    count++;
                }else{
                    ret= cur.val;
                    break;
                }
            }
            return ret;

        }
        public void deleteAtIndex(int index) {
            //要知道被删除元素的前驱节点
            Nodes prev=this.head;
            int num=1;
            while(prev!=null){
                if(num!=index){
                    prev=prev.next;
                    num++;
                }else{
                    break;
                }
            }
            //prev所指的位置就是要删除的位置的前驱节点
            if(index<0){
                return;
            }
            if(index==0){
                head=head.next;
                return;
            }
            Nodes cur=this.head;
            int count=0;
            while(cur!=null){
                if(count!=index){
                    cur=cur.next;
                    count++;
                }else{
                    prev.next=cur.next;
                    break;
                }
            }
        }
        //向index位置插入元素
        /*
        addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
        如果 index 等于链表的长度，则该节点将附加到链表的末尾。
        如果 index 大于链表长度，则不会插入节点。
        如果index小于0，则在头部插入节点。

         */
        public void addAtIndex(int index, int val) {
            Nodes node = new Nodes(val);
            Nodes cur = this.head;
            int size = 0;
            //得到链表的长度
            while (cur != null) {
                size++;
                cur = cur.next;
            }
            cur = this.head;
            if (index > size) {
                return;
            }
            if(index==0){
                node.next=head;
                head=node;
                return;
            }
            if (index == size) {
                tail.next = node;
                tail = node;
                return;
            }
            //得到要插入位置index的前驱节点
            Nodes prev = this.head;
            int num = 1;
            while (prev != null) {
                if (num != index) {
                    prev = prev.next;
                    num++;
                } else {
                    break;
                }
            }
            node.next = prev.next;
            prev.next = node;
        }
        public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtTail(5);
        myLinkedList.addAtTail(6);
        myLinkedList.display();
        System.out.println(" ");
        System.out.println(myLinkedList.get(1));
        System.out.println(" ");
        myLinkedList.deleteAtIndex(7);
        myLinkedList.display();
        System.out.println("");
        myLinkedList.addAtIndex(0,999);
        myLinkedList.display();

        }

    }
