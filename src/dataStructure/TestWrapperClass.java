package dataStructure;

/**
 * Created with IntelliJ IDEA.
 * Description:包装类，装箱拆箱
 * User:wanghuimin
 * Date:2020-04-11
 * Time:11:40
 * 一万年太久，只争朝夕，加油
 */
public class TestWrapperClass {
    public static void main(String[] args) {
        //装箱（内置类型->包装类）
        Integer i=Integer.valueOf(10);
        //拆箱（包装类->内置类型）
        int g=i.intValue();
        //自动装箱
        Integer i1=10;
        //自动拆箱
        int g1=i1;
        System.out.println(i1);
        System.out.println(g1);



    }
}
