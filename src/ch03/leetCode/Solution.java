package ch03.leetCode;

import java.util.Stack;

//有效的括号
public class Solution {

    public static boolean isValid(String str){

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){

            char c = str.charAt(i);

            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                // 如果栈为空,说明没有匹配,直接返回false
                if(stack.isEmpty())
                    return false;

                // 取出栈顶的元素
                char top = stack.pop();

                if(c == ')' && top != '(')
                    return false;
                if(c == '}' && top != '{')
                    return false;
                if(c == ']' && top != '[')
                    return false;
            }
        }
        // 判断栈是否为空
        return stack.isEmpty();
    }
}

