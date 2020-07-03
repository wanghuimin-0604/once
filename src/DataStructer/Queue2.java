package DataStructer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-06-05
 * Time:20:55
 * 一万年太久，只争朝夕，加油
 */

    import java.util.Stack;

    public class Queue2 {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            //进的时候正常进
            stack1.push(node);

        }

        public int pop() {
            //出的时候我们就要借助两个栈来模拟先进先出
            if (stack1.isEmpty() && stack2.isEmpty()) {
                //如果栈1为空，那么说明栈中是没有元素
                System.out.println("error");
            }
            int ret=0;
            //如果栈2不为空，就从栈2里面出栈元素
            if (!stack2.isEmpty()) {
                ret = stack2.pop();
            } else {
                //如果栈1不为空，就借助两个来模拟
                //先把栈1中的n个元素出栈，然后放到栈2中
                while(!stack1.isEmpty()){
                    int s = stack1.peek();
                    stack2.push(s);
                    stack1.pop();
                }
                //然后再出栈
                ret = stack2.peek();
                stack2.pop();
            }
                return ret;

            }

        public static void main(String[] args) {
                Queue2 q=new Queue2();
                q.push(1);
                q.push(2);
                q.push(3);
                q.push(4);
            System.out.println(q.pop());
        }
    }
