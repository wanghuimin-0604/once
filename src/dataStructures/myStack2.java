package dataStructures;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-04-16
 * Time:15:34
 * 一万年太久，只争朝夕，加油
 */
//栈用链表实现，链表头进行插入和删除元素
public class myStack2 {
    //先定义一个节点类信息
    static class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node head=new Node(-1);

    //入栈
    public void push(int val){
        Node node=new Node(val);
        node.next=head.next;
        head.next=node;

    }
    //出栈
    public Integer pop(){
        //说明栈中没有元素
        if(head.next==null){
            return null;
        }
        //有元素
        Node del=head.next;
        head.next=del.next;
        return del.val;
    }
    //取栈顶元素
    public Integer peek(){
        //说明栈中没有元素
        if(head.next==null){
            return null;
        }
        //有元素
        return head.next.val;
    }

    public static void main(String[] args) {
        myStack2 myStack=new myStack2();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());


        Integer cur=null;
        while((cur=myStack.pop())!=null){
            System.out.println(cur);
        }
    }

}
