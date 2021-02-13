package stack;

import arrays.Array;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Util.isBalancedParenthesis("{{}}}{}"));
        System.out.println(Util.resolvedDirectoryStructure("/a/b/../c"));
        Util.nextGreaterElement(Arrays.asList(1,2,13,4,6,16,0));
    }
}

//1,2,13,4,6,16,0
//stack - 16 ,0
//1 ---> 2
//2 ----> 13
//4 ---> 6
//6 ---> 16
//13 ---> 16
//16 ---> -1
//0 ----> -1

//o(n)