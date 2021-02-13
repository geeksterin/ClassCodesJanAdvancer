package stack;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static boolean isBalancedParenthesis(String parenthesis) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<parenthesis.length();i++) {

            if(parenthesis.charAt(i) == '{') {
                stack.push(parenthesis.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public static String resolvedDirectoryStructure(String structure) {
        String[] strings = structure.split("/");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<strings.length;i++) {

            if(strings[i].equals("..")) {
                stack.pop();
            } else if(strings[i].equals("")){
                continue;
            } else {
                stack.push(strings[i]);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        String str = "abc";
        str = str + "zxy";
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop()).append("/");
        }
        return stringBuffer.reverse().toString();
    }

    //1, 2, 13, 4, 6, 16, 0
    //
    public static void nextGreaterElement(List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        for(int a : list) {
            while(!stack.isEmpty() && stack.peek() < a) {
                int temp = stack.pop();
                System.out.println(temp + "------->" + a);
            }
            stack.push(a);
        }
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            System.out.println(temp + "------->" + -1);
        }

    }

}