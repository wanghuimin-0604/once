package DataStructer;
/*
带头节点的双向链表的实现
 */
class LinkedNode{//节点信息
    public int data;
    public LinkedNode prev;
    public LinkedNode next;
    public LinkedNode(){
    }
    public LinkedNode(int data){
        this.data=data;
        this.next=null;
    }
}

public class DoublelinkedListLeadingHead {

        public LinkedNode head;//头
        public LinkedNode last;//尾巴

        public DoublelinkedListLeadingHead() {
            this.head=new LinkedNode();
            this.last=this.head;
        }
    //头插法
    public void addFirst(int data){
            //先生成一个要插入的节点
            LinkedNode node=new LinkedNode(data);
            //第一次插入
        if(this.head.next==null){
            this.head.next=node;
            node.prev=this.head;
            this.last=node;
            return;
        }
        //链表中已经有元素
        node.next=this.head.next;
        this.head.next.prev=node;
        this.head.next=node;
        node.prev=this.head;
    }
    //尾插法
    public void addLast(int data){
            //先生成一个要插入的节点
        LinkedNode node=new LinkedNode(data);
        //第一次插入
        if(this.head.next==null) {
            this.head.next = node;
            node.prev = this.head;
            this.last = node;
            return;
        }
        this.last.next=node;
        node.prev=this.last;
        this.last=node;
    }
    //找到index位置的节点
    public LinkedNode findNode(int index){
            LinkedNode cur=this.head.next;
            int count=0;
            while(count<index){
                cur=cur.next;
                count++;
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
            //判断插入位置是否合法
        if(index<0||index>size()){
            System.out.println("插入位置不合法");
        }
            //找到index位置的那个节点
        LinkedNode cur=findNode(index);
        //生成要插入的node节点
        LinkedNode node=new LinkedNode(data);
        node.next=cur;
        cur.prev.next=node;
        node.prev=cur.prev;
        cur.prev=node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
            LinkedNode cur=this.head.next;
            while(cur!=null){
                if(cur.data==key){
                    return true;
                }
                cur=cur.next;
            }
            return false;

    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
            if(this.head==null){
                System.out.println("链表为空");
            }
            LinkedNode cur=this.head.next;
            while(cur!=null){
               if(cur.data==key){
                   if(cur==this.head.next){
                       this.head.next=cur.next;
                       cur.next.prev=this.head;
                   }else if(cur==this.last){
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
            if(this.head==null){
                System.out.println("链表为空");
            }
            LinkedNode cur=this.head.next;
            while(cur!=null){
                if(cur.data==key){
                    if(cur==this.head.next){
                        this.head.next=cur.next;
                        cur.next.prev=this.head;
                    }else if(cur==this.last){
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
            LinkedNode cur=this.head.next;
            int count=0;
            while(cur!=null){
                count++;
                cur=cur.next;
            }
            return count;
    }
    public void display(){
            LinkedNode cur=this.head.next;
            while(cur!=null){
                System.out.print(cur.data+" ");
                cur=cur.next;
            }

    }
    public void clear(){
            this.head.next=null;
            this.last=null;
    }
}
