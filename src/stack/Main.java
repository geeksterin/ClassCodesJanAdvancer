package stack;

import arrays.Array;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
//        System.out.println(Util.isBalancedParenthesis("{{}}}{}"));
//        System.out.println(Util.resolvedDirectoryStructure("/a/b/../c"));
//        Util.nextGreaterElement(Arrays.asList(1,2,13,4,6,16,0));
//		int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
//		for (int val : Util.stockSpan(arr)) {
//			System.out.print(val + " ");
//		}
//		int[] arr = {6,2,5,4,5,1,6};
//		int val = Util.largestAreaHistogram(arr);
//		System.out.println(val);

		System.out.println(Util.mergeIntervals(Arrays.asList(new Interval(4, 7), new Interval(2, 4) ,new Interval(8,9), new Interval(4 , 6))));
		int val = Util.infixEvaluation("2+(5-3*6/2)");
		System.out.println(Util.infixToPostfix("A-(B+C)"));
		System.out.println(val);
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