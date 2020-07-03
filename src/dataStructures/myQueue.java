package dataStructures;

import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:用链表实现队列
 * User:wanghuimin
 * Date:2020-04-16
 * Time:15:54
 * 一万年太久，只争朝夕，加油
 */
//队列用顺序表和链表实现
// 先用链表实现
class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class myQueue {

        public Node head=new Node(-1);
        public Node tail=head;

    public myQueue() {
    }

    //链表尾部增加元素（队尾），链表头部删除元素（对头）
        public void offer(int val){
            Node node=new Node(val);
            //如果队列为空
            if(head.next==null){
                head.next=node;
                tail=node;
                return;
            }
            //如果队列不为空
            tail.next=node;
            tail=node;
        }
        //出队列（在链表头部进行元素删除）
        public Integer poll(){
            if(head.next==null){
                return null;
            }
            Node del=head.next;
            head=head.next;
            return del.val;
        }
        //取队首元素（队首元素再链表头部）
        public Integer peek(){
            if(head.next==null){
                return null;
            }
            return head.next.val;
        }

        public static void main(String[] args) {
            myQueue myQueue1=new myQueue();
            myQueue1.offer(1);
            myQueue1.offer(2);
            myQueue1.offer(3);
            myQueue1.offer(6);

            System.out.println(myQueue1.peek());

        }

    }
