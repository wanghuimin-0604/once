package dataStructures;

/**
 * Created with IntelliJ IDEA.
 * Description:实现栈
 * User:wanghuimin
 * Date:2020-04-16
 * Time:15:05
 * 一万年太久，只争朝夕，加油
 */
//栈可以用顺序表和链表两种方式实现
//顺序表表尾进行插入删除操作
public class myStack {
    int[] array = new int[100];
    int size = 0;//记录栈中的元素个数

    //入栈
    public void push(int value) {
        //栈满了的话，就不能再插入元素了
        if (size == array.length) {
            return;
        }
        //如果已经有元素，那么肯定是从末尾进行插入
        array[size] = value;
        size++;
    }

    //出栈
    public Integer pop() {
        //如果栈为空的话
        if (size == 0) {
            return null;
        }
        //元素出栈
        int ret=array[size-1];
        size--;
        return ret;
    }
    //取栈顶元素
    public Integer peek(){
        //如果栈为空的话
        if (size == 0) {
            return null;
        }
        return array[size-1];

}

    public static void main(String[] args) {
        myStack myStack1=new myStack();
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);
        myStack1.push(4);

        //取栈顶元素
        System.out.println(myStack1.peek());

        //出栈
       /* while(myStack1.pop()!=null){
            Integer cur=myStack1.pop();
            if(cur==null){
                break;
            }
            System.out.println(cur);
        }*/
       Integer cur=null;
        while((cur=myStack1.pop())!=null){
            System.out.println(cur);
        }
    }
}
