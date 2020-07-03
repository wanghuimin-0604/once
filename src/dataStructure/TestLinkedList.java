package dataStructure;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:LinkedList接口
 * User:wanghuimin
 * Date:2020-04-11
 * Time:17:37
 * 一万年太久，只争朝夕，加油
 */
public class TestLinkedList {
    public static void main(String[] args) {
        List<String> linkedList=new LinkedList<>();
        linkedList.add("我");
        linkedList.add("爱");
        linkedList.add("java");
        linkedList.add("编程");
        System.out.println(linkedList.size());
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList);
        System.out.println(linkedList.subList(0, 2));
        linkedList.add(4,"语言");
        linkedList.remove(0);
        System.out.println(linkedList.get(2));
        linkedList.set(1,"C");
        System.out.println(linkedList);
    }
}
