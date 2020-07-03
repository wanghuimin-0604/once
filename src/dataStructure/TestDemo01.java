package dataStructure;

/**
 * Created with IntelliJ IDEA.
 * Description:顺序表测试
 * User:wanghuimin
 * Date:2020-04-09
 * Time:20:32
 * 一万年太久，只争朝夕，加油
 */
public class TestDemo01 {
    public static void main(String[] args) {
        ArrayList a=new ArrayList();
        a.add(0,1);
        a.add(1,2);
        a.add(2,3);
        a.add(3,4);
        System.out.println(a.getPos(2));
        a.setPos(0,9);
        a.display();
        System.out.println();
        System.out.println("############");
        a.remove(2);
        a.display();
        System.out.println();
        System.out.println("############");
        System.out.println(a.size());

    }
}
