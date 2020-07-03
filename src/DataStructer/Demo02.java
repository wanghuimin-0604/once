package DataStructer;

public class Demo02 {
    public static void main(String[] args) {
        DoublelinkedListLeadingHead l=new DoublelinkedListLeadingHead();
        l.addFirst(5);
        l.addFirst(6);
        l.addFirst(7);
        l.addFirst(8);
        l.addLast(4);
        l.addLast(3);
        l.addLast(2);
        l.addLast(1);
        l.addLast(50);
        l.addLast(6);
        l.addFirst(6);
        l.addIndex(2,10);//8 7 10 6 5 4 3 2 1
        l.display();
        System.out.println(" ");
        System.out.println("############");
        System.out.println(l.contains(6));
        l.remove(5);
        l.remove(8);
        l.remove(1);
        l.display();
        System.out.println("   ");
        l.removeAllKey(6);
        l.display();


    }
}
