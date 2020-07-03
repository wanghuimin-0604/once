package DataStructer;

public class TestDemo {
    public static void main(String[] args) {
        DoubleLinkedList d = new DoubleLinkedList();
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        d.addLast(2);
        d.addLast(5);
        d.addLast(6);
        d.addIndex(1,10);
        d.display();

        System.out.println(d.contains(1));
        d.remove(6);
        d.display();
        System.out.println("#############");
        d.removeAllKey(2);
        d.display();
    }
}
