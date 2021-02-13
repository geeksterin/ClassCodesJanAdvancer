package stack;

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
        //TODO:
        return null;
    }

}
