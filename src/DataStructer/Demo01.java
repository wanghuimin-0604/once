package DataStructer;
//顺序表
//底层是一个数组，因此需要一个数组，有一个变量来标记已经用的数组大小
//能知道存放了多少个元素，数组不能跳着存储数据

/*类型：ArrayList
  属性：int[] elem    int usedSize
  方法：构造方法
 */
class ArrayList{
    int[] elem;
    int usedSize;
    public static final int Default_Size=4;
    public ArrayList() {
        this.elem=new int[Default_Size];
        this.usedSize = 0;
    }
    // 打印顺序表就是打印这个数组
    public void display() {
        for(int i=0;i<this.usedSize;i++){
            System.out.print(elem[i]+" ");
        }
    }
    public boolean isFull(){
        if(this.usedSize==this.elem.length){
            return true;
        }
        return false;
    }
    // 在 pos 位置新增元素:先判断这个顺序表满了没有。没有满的话再插入
    public void add(int pos, int data) {
        if(isFull()){
            System.out.println("当前线性表已满");
            return;
        }
        //判断插入位置是否合法
        if(pos<0||pos>usedSize){
            System.out.println("插入位置不合法");
            return;
        }
        //先将该位置以及之后的元素全部右移
        for(int i=usedSize-1;i>=pos;i--){
            this.elem[i+1]=this.elem[i];
        }
        //把这个要插入的数字放到顺序表的该位置,usedSize++
        this.elem[pos]=data;
        this.usedSize++;
    }


    public boolean isEmpty(){
        if(this.usedSize==0){
            return true;
        }
        return false;
    }
    // 判定是否包含某个元素：遍历这个顺序表，看有没有和这个要找的元素一样的数值
    public boolean contains(int toFind) {
        //先判断这个顺序表是不是为空
        if (isEmpty()) {
            System.out.println("该顺序表为空");
        }
        for(int i=0;i<this.elem.length;i++){
            if(this.elem[i]==toFind){
                return true;
            }
        }
        //不包含的话就返回false
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        //先判断顺序表是不是为空
        if(isEmpty()){
            System.out.println("顺序表为空");
        }
        for(int i=0;i<usedSize;i++){
            if(this.elem[i]==toFind){
                return i;
            }
        }
        //没找到该元素的话，返回-1，因为数组的下标不可能为负数
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        //先判断这个位置pos合法不合法
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("插入位置不合法");
        }
        if (isEmpty()) {
            System.out.println("线性表为空");
        }
        //返回pos位置的元素
        return this.elem[pos];
 }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        //先判断pos位置是否合法
        if(pos<0||pos>this.usedSize){
            System.out.println("插入位置不合法");
            return;
        }
        //将该位置的元素设为value
        this.elem[pos]=value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        //先找到这个关键字toRemove的位置
        int pos=search(toRemove);
        //然后将这个位置后面的元素都向前移动
        while(pos!=-1){
            for(int i=pos;i<this.usedSize-1;i++){
                this.elem[i]=this.elem[i+1];
            }
            this.usedSize--;
            break;
        }
    }
    // 获取顺序表长度
    public int size() {
        return this.elem.length;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize=0;
    }
}

public class Demo01 {
    public static void main(String[] args) {
        //普通成员方法要通过对象来进行调用，先创建对象
        ArrayList arrayList=new ArrayList();
        arrayList.add(0,1);
        arrayList.add(1,3);
        arrayList.add(2,5);
        arrayList.add(3,10);
       // arrayList.add(2,8);
        arrayList.display();
        System.out.println(" ");
        System.out.println("该线性表长度为"+arrayList.size());
        System.out.println(" ");
        arrayList.remove(3);
        arrayList.display();
        System.out.println(" ");
        System.out.println("删除元素之后线性表的长度为"+arrayList.size());
        arrayList.setPos(1,22);
        arrayList.display();
        System.out.println(" ");
        System.out.println(arrayList.getPos(2));

    }
}
