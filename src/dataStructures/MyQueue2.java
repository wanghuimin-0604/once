package dataStructures;

import com.bit.quene.MyQuene2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-04-17
 * Time:20:07
 * 一万年太久，只争朝夕，加油
 */
//用顺序表实现队列 （循环队列）

    //定义一个head头和一个尾tail
public class MyQueue2 {
    public int[] array=new int[100];
    public int size;

    public int head=0;
    public int tail=0;

    //入队列（从顺序表尾端进行插入）
    public void offer(int val){
        //如果顺序表已经满了，那就不能再放进去了
        if(size==array.length){
            return;
        }
        //插入元素
        array[size]=val;
        tail++;
        //如果tail超出数组的话
        if(tail>=array.length){
            tail=tail%array.length;
        }
        size++;
    }
    //出队列
    public Integer poll(){
        //如果队列是空的话，就不能删除元素
        if(size==0){
            return null;
        }
        int ret=array[head];
        head++;
        size--;
        return ret;
    }

    //去队首元素
    public Integer peek(){
        if(size==0){
            return null;
        }
        return array[head];

    }

    public static void main(String[] args) {
        MyQueue2 myQueue2=new MyQueue2();
        myQueue2.offer(5);
        myQueue2.offer(6);
        myQueue2.offer(7);

        System.out.println(myQueue2.peek());
    }

}
