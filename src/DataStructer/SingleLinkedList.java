package DataStructer;
//链表实现：由节点构成，节点又由两个域组成：节点域和指针域，指针域保存的是下一个节点的地址
//不带头节点的单向不循环链表

/*
类型：Node
属性：数据域  int data
     指针域   Node  next
 */
class Node {
    int data;
    Node next;
    //构造方法
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class SingleLinkedList {
    public Node head;

    public SingleLinkedList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        //先生成一个节点
        Node node = new Node(data);
        //将节点插入到head之前
        //1、如果链表为空，那么这个节点就是头节点
        if (this.head == null) {
            this.head = node;
            return;
        }
        //2、已经有节点,那么就把这个node节点放在head之前，并把它指定为head
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        //先生成一个结点
        Node node = new Node(data);
        //1、链表为空
        if (this.head == null) {
            this.head = node;
            return;
        }
        //2、不为空，把这个节点插入到最后一个节点的后面
        Node cur = this.head;
        //找最后一个节点
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //找到要插入位置的前驱节点
    public Node findIndex(int index) {
        Node cur = this.head;
        int count = 0;
        while (count < index - 1) {
            count++;
        }
        return cur;
    }

    //任意位置插入一个数字,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        //先生成一个节点
        Node node = new Node(data);
        //要插入的话必须找到这个插入位置节点的前驱节点
        Node prev = findIndex(index);
        //判断插入位置是否合法
        if (index < 0 || index > size()) {
            System.out.println("插入位置不合法");
        }
        //1、如果插入位置在头节点之前，即0号位置
        if (index == 0) {
            addFirst(data);
            return;
        }
        //2、如果插入位置在最后一个结点之后
        if (index == size()) {
            addLast(data);
            return;
        }
        node.next = prev.next;
        prev.next = node;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        //如果删除的是头节点
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //找到要删除的这个节点的前驱节点
        Node prev = findPrev(key);
        if (prev == null) {
            return;
        }
        Node del = prev.next;
        prev.next = del.next;
    }

    public Node findPrev(int key) {
        Node prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        //如果删除的是头节点
        if (this.head.data == key) {
            this.head = this.head.next;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

    }

    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 1;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    public void clear() {
        this.head = null;//没有引用的时候就会被jvm回收掉

    }

    //找倒数第k个节点
    public Node FindKthToTail(int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        //1、让fast先走k-1步
        for (int i = 1; i < k; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                System.out.println("没有该节点");
            }
        }
        //2、让两个引用 一起走  直到 fast.next == null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
        // slow 所指的位置就是倒数第K个节点
    }

    public void display2(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //反转单链表
    public Node reverseList() {
        Node prev = null;
        Node cur = this.head;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                //反转之后新的头节点
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    //返回链表的中间节点
    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

    //链表分割
    public Node partition(int x) {
        Node bs = null;
        Node be = null;//永远指向尾巴的地方
         Node as = null;
        Node ae = null;
        Node cur = this.head;
        while (cur != null) {
            if (cur.data < x) {
                if (bs == null) {
                    //第一个线段的第一次插入
                    bs = cur;
                    be = bs;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                if (as == null) {
                    //第一个线段的第一次插入
                    as = cur;
                    ae = as;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //第一个段没有数据
        if (bs == null) {
            //只能返回第二个段
            return as;
        }
        //代码走到这里 说明bs !=null  那么把两个段拼接起来
        be.next = as;
        //只要第二个段 不为空
        if (as != null) {
            ae.next = null;
        }
        return bs;
    }

    //合并两个有序链表
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node newhead = new Node(-1);
        Node tmp = newhead;
        Node headA = l1;
        Node headB = l2;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                tmp.next = headA;
                tmp = tmp.next;
                headA = headA.next;
            } else {
                tmp.next = headB;
                tmp = tmp.next;
                headB = headB.next;

            }
        }
        if (headA != null) {
            tmp.next = headA;
        }
        if (headB != null) {
            tmp.next = headB;
        }
        return newhead.next;
    }

    /*删除重复节点
    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
     */
    public Node deleteDuplication() {
        //先生成一个虚拟节点，用来链入非重复的节点
        Node node = new Node(-1);
        Node tmp = node;//保存虚拟节点的地址
        //定义一个cur遍历这个单链表
        Node cur = this.head;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.data == cur.next.data && cur.next != null) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        //尾巴节点也重复
        tmp.next = null;
        //返回虚拟节点后的节点
        return node.next;//返回链表头指针
    }


    //判断链表是不是回文链表
    public boolean chkPalindrome() {
        //1、找中间节点
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、局部反转
        Node cur = slow.next;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //slow-->单链表的最后一个节点
        while (slow != this.head) {
            if (slow.data != this.head.data) {
                return false;
            }
            //偶数情况的判断
            if (this.head.next == slow) {
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }
    /*判断链表是否有环
    什么叫做有环？
    两个节点可以相遇
     */

    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return false;
        }
        return true;
    }

    //创建一个有环的链表
    public void createLoop() {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        //cur.next == null
        cur.next = this.head.next;
    }

    /**
     * 相遇点
     *
     * @return
     */
    public Node meet() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        return fast;
    }

    /**
     * 入口点
     */
    public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = this.head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    //找两个链表的公共节点
    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        Node PL = headA;//长
        Node PS = headB;//短
        while (PL != null) {
            lenA++;
            PL = PL.next;
        }
        while (PS != null) {
            lenB++;
            PS = PS.next;
        }
        PL = headA;
        PS = headB;
        int len = lenA - lenB;
        if (len < 0) {
            PL = headB;
            PS = headA;
            len = lenB - lenA;
        }
        //PL指向长的，PS指向短的
        //PL走了差值步
        while (len > 0) {
            PL = PL.next;
            len--;
        }
        while (PL != null && PS != null && PL != PS) {
            PL = PL.next;
            PS = PS.next;
        }
        if (PL != null && PS != null && PL == PS) {
            return PL;
        }
        return null;
    }

    public static void main(String[] args) {
        SingleLinkedList s1 = new SingleLinkedList();
        SingleLinkedList s2 = new SingleLinkedList();
        s1.addLast(1);
        s1.addLast(3);
        s1.addLast(5);
        s2.addLast(2);
        s2.addLast(4);
        s2.addLast(6);
        Node ret=getIntersectionNode(s1.head,s2.head);
        System.out.println(ret.data);



    }
}