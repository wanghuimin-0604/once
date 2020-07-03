package dataStructure;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:List接口
 * User:wanghuimin
 * Date:2020-04-11
 * Time:11:47
 * 一万年太久，只争朝夕，加油
 */
public class TestList {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("python");
        list.add("java");
        list.add("C");
        list.add("C++");
        System.out.println(list);
        System.out.println("*****************");
        System.out.println(list.get(0));
        list.set(0,"Go");
        System.out.println(list);
        System.out.println("***************");
        System.out.println(list.subList(0, 2));
        //重新构造一个list(浅拷贝）
        List<String> arraylist=new ArrayList(list);
        //基于现有的list的引用进行强制类型转换（向下类型转换）
        ArrayList<String> arraylist1=(ArrayList<String>)list;
        System.out.println(list.isEmpty());
        System.out.println(list.size());
    }
}
