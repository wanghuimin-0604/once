package dataStructure;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-04-17
 * Time:19:35
 * 一万年太久，只争朝夕，加油
 */
public class StackQueueInterview {
    public boolean isValid(String s){
        if (s.isEmpty()){
            return true;
        }
        //1.创建一个栈
        Stack<Character> stack = new Stack<>();
        //2.遍历字符串 取出字符看是左括号还是右括号
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            //如果是左括号，直接入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            //如果是右括号，去栈顶元素和当前元素看是否匹配
            if (stack.empty()){
                return  false;
            }
            Character top = stack.pop();
            if (top == '(' && c == ')'){
                continue;
            }
            if (top == '[' && c == ']'){
                continue;
            }  if (top == '{' && c == '}'){
                continue;
            }
            return false;
        }
        //3.最后遍历完字符串之后看栈是否为空
        if (stack.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        StackQueueInterview a=new StackQueueInterview();
        String s="{}";
        System.out.println(a.isValid(s));
    }

}
