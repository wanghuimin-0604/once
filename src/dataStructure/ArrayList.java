package dataStructure;

/**
 * Created with IntelliJ IDEA.
 * Description:顺序表
 * User:wanghuimin
 * Date:2020-04-09
 * Time:13:24
 * 一万年太久，只争朝夕，加油
 */
class ArrayList {
    int[] elem;//数组
    int usedSize;//记录存放了多少个元素

    //构造方法进行初始化
    public ArrayList(){
        this.elem=new int[10];
        this.usedSize=0;
    }
    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
    }
    //判断顺序表是否满了
    public boolean isFull(){
        if(this.usedSize==this.elem.length){
            return true;
            }
        return false;
        }
        //判断顺序表是否为空
    public boolean isEmpty(){
        if(this.usedSize==0) {
            return true;
        }
        return false;
        }
    // 在 pos 位置新增元素
    public void add(int pos,int data) {
        //如果顺序表为空，就直接加
        if (isFull()) {
            System.out.println("顺序表已经满了");
            return;
        }
        //检查插入位置pos的合法性
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("插入位置不合法");
            return;
        }
        //如果可以插入,先把该位置及后面的元素后移
        for(int i=this.usedSize-1;i>pos;i--) {
            this.elem[i + 1] = this.elem[i];
        }
        //把元素插入,usedSize+1
        this.elem[pos]=data;
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        if(isEmpty()){
            System.out.println("线性表为空");
        }
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return true;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        if(isEmpty()){
            System.out.println("线性表为空");
        }
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return i;
            }
        }
        //如果没有找到那个元素，就返回-1
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(isEmpty()){
            System.out.println("线性表为空");
        }
        if(pos<0||pos>this.usedSize){
            System.out.println("位置不合法");
        }
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(isEmpty()){
            System.out.println("线性表为空");
            return;
        }
        if(pos<0||pos>this.usedSize){
            System.out.println("位置不合法");
            return;
        }
        this.elem[pos]=value;
    }
    //删除第一次出现的关键字key
    public void remove(int key) {
        if (isEmpty()) {
            System.out.println("顺序表是空的");
            return;
        }
        //找到这个元素的位置
        int pos = search(key);
        //pos!=-1说明找到这个元素的位置
        if (pos != -1) {
            for (int i = pos; i < this.usedSize - 1; i++) {
                //将i位置的元素以及后面的元素向前移动
                this.elem[i] = this.elem[i + 1];
            }
        }
        //顺序表长度-1
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        int count=0;
        for(int i=0;i<this.usedSize;i++){
            count++;
        }
        return count;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize=0;
    }
}
