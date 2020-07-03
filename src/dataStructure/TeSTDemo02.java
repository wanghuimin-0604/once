package dataStructure;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-04-09
 * Time:21:41
 * 一万年太久，只争朝夕，加油
 */
public class TeSTDemo02 {
    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        l.addFirst(2);
        l.addFirst(2);
        l.addFirst(3);
        l.addFirst(2);
        l.addLast(2);
        l.addLast(6);
        l.addLast(2);
        l.addIndex(1,8);
        l.display();
        System.out.println();
        //System.out.println(l.contains(1));
        // l.remove(2);
        l.removeAllKey(2);
        l.display();
        System.out.println();
        System.out.println(l.size());
    }
}
