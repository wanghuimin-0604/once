package dataStructure;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-04-09
 * Time:21:31
 * 一万年太久，只争朝夕，加油
 */
//先定义一个节点（data域,next域）
class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data=data;
        this.next=null;
    }
}
public class LinkedList {
    //定义头节点
    public Node head;

    public LinkedList(Node head) {
        this.head = null;
    }

    public LinkedList() {
    }

    //成员方法
    //头插法
    public void addFirst(int data){
        //先生成一个节点
        Node node =new Node(data);
        //1、第一次插入
        if(this.head==null){
            this.head=node;
            return;
        }
        //2、已经有元素了
        node.next=this.head;
        this.head=node;
    }
    //尾插法
    public void addLast(int data){
        Node node=new Node(data);
        //1、如果没有元素
        if(this.head==null){
            this.head=node;
            return;
        }
        //2、有元素,找到最后一个元素，插到最后元素之后
        Node cur=this.head;
        //找到最后一个元素
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }
    public Node findIndex(int index) {
        Node cur = this.head;
        int count = 0;
        while (count<index-1) {
            count++;
            cur = cur.next;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
            Node node = new Node(data);
            //调用一个方法来找到index位置的那个元素
            Node prev = findIndex(index);
            if(index==0){
                addFirst(data);
                return;
            }
            if(index==size()){
                addLast(data);
                return;
            }
            node.next = prev.next;
            prev.next = node;
        }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    public Node findPrev(int key){
        Node cur=this.head;
        while(cur!=null){
            if(cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head.data==key){
            this.head=this.head.next;
            return;
        }
        if(this.head==null){
            return;
        }
        //要找到这个节点的前驱节点
        Node prev=findPrev(key);
        Node del=prev.next;
        prev.next=del.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        //如果删除的是头节点
        if(this.head.data==key){
            this.head=this.head.next;
        }
        Node prev=this.head;
        Node cur=this.head.next;
        while(cur!=null){
            if(cur.data==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }

    }
    //得到单链表的长度
    public int size(){
        Node cur=this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public void display(){
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
    public void clear(){
        this.head=null;

    }
}
