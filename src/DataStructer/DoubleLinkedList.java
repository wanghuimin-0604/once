package DataStructer;
/*
无头双向非循环链表
 */
class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class DoubleLinkedList {
    public ListNode head;
    public ListNode last;//尾巴

    public DoubleLinkedList() {
        this.head=head;
        this.last=last;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node=new ListNode(data);
        if(this.head == null){
            this.head=node;
            this.last=node;
            return;
    }
            node.next=this.head;
            this.head.prev=node;
            this.head=node;
        }

    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        //1、链表中没有节点
        if(this.head==null){
            this.head=node;
            this.last=node;
            return;
        }
        //2、有节点
            this.last.next=node;
            node.prev=this.last;
            this.last=node;
        }
        public ListNode getIndex(int index){
        ListNode cur=this.head;
        while(index>0){
            cur=cur.next;
            index--;
        }
        return cur;
        }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==size()){
            addLast(data);
            return;
        }
        if(index<0||index>size()){
            System.out.println("插入位置不合法");
            return;
        }
        //1、先定义一个cur，走index位置
        ListNode cur=getIndex(index);
        ListNode node=new ListNode(data);
        //2、插入到index位置，改变4个值
        node.next=cur;
        node.prev=cur.prev;
        cur.prev=node;
        node.prev.next=node;
        }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
        }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.val==key){
                //当前cur是不是头节点
                if(cur==this.head){
                    this.head=this.head.next;
                    this.head.prev=null;
                }else if(cur==this.last) {
                    this.last=cur.prev;
                    cur.prev.next=null;
                }else{
                    cur.prev.next=cur.next;
                    cur.next.prev=cur.prev;
                }
                return;
            }else{
                cur=cur.next;
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.val==key){
                //当前cur是不是头节点
                if(cur==this.head){
                    this.head=this.head.next;
                    this.head.prev=null;
                }else if(cur==this.last) {
                    this.last=cur.prev;
                    cur.prev.next=null;
                }else{
                    cur.prev.next=cur.next;
                    cur.next.prev=cur.prev;
                }
            }
                cur=cur.next;
        }
        }
    //得到单链表的长度
    public int size(){
        ListNode cur=this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
      return count;
        }
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur=cur.next;
        }
    }
    public void clear(){
        this.head=null;
        this.last=null;

        }
}