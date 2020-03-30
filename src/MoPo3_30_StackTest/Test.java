package MoPo3_30_StackTest;

import java.util.Stack;

public class Test {
    public static boolean isValid (String s){//括号匹配问题;
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for (char value : c) {
            if (value == '(') {//把左括号对应的右括号压到stack中;
                stack.push(')');
            }else if (value == '{'){
                stack.push('}');
            }else if (value == '['){
                stack.push(']');
            } else if(stack.empty()|| value != stack.pop()){
                return false;
            }
        }
        return stack.empty();
    }
    public static void main(String[] args) {
        String s = "{{}}";
        System.out.println(isValid(s));
    }
}
