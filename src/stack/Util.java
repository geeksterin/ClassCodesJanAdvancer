package stack;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {

	public static boolean isBalancedParenthesis(String parenthesis) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < parenthesis.length(); i++) {

			if (parenthesis.charAt(i) == '{') {
				stack.push(parenthesis.charAt(i));
			} else {
				if (stack.isEmpty()) {
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
		for (int i = 0; i < strings.length; i++) {

			if (strings[i].equals("..")) {
				stack.pop();
			} else if (strings[i].equals("")) {
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

	// 1, 2, 13, 4, 6, 16, 0
	//
	public static void nextGreaterElement(List<Integer> list) {
		Stack<Integer> stack = new Stack<>();
		for (int a : list) {
			while (!stack.isEmpty() && stack.peek() < a) {
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

	public static int[] stockSpan(int[] arr) {
		int[] span = new int[arr.length];

		Stack<Integer> st = new Stack<>();
		st.push(0);
		span[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[i] > arr[st.peek()]) {
				st.pop();
			}

			if (st.size() == 0) {
				span[i] = i + 1;
			} else {
				span[i] = i - st.peek();
			}

			st.push(i);
		}

		return span;
	}

	public static int largestAreaHistogram(int[] arr) {
		int[] lb = new int[arr.length];
		int[] rb = new int[arr.length];

//		calculating lb and rb 

		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		lb[0] = -1;
		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[i] < arr[st.peek()]) {
				st.pop();
			}

			if (st.size() != 0) {
				lb[i] = st.peek();
			} else {
				lb[i] = -1;
			}
			st.push(i);
			;
		}

		st = new Stack<Integer>();
		st.push(arr.length - 1);
		rb[arr.length - 1] = arr.length;
		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[i] < arr[st.peek()]) {
				st.pop();
			}

			if (st.size() != 0) {
				rb[i] = st.peek();
			} else {
				rb[i] = arr.length;
			}
			st.push(i);
		}

		int maxArea = 0;
		for (int i = 0; i < arr.length; i++) {
			int area = arr[i] * (rb[i] - lb[i] - 1);

			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
	}

	public static int infixEvaluation(String exp) {
		Stack<Integer> opnds = new Stack<Integer>();
		Stack<Character> oprts = new Stack<Character>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch == '(') {
				oprts.push(ch);
			} else if (Character.isDigit(ch)) {
				opnds.push(ch - '0');
			} else if (ch == ')') {
				while (oprts.peek() != '(') {
					char optor = oprts.pop();
					int v2 = opnds.pop();
					int v1 = opnds.pop();
					int opv = operation(v1, v2, optor);
					opnds.push(opv);
				}
				oprts.pop();
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (oprts.size() > 0 && oprts.peek() != '(' && precedence(ch) <= precedence(oprts.peek())) {
					char optor = oprts.pop();
					int v2 = opnds.pop();
					int v1 = opnds.pop();
					int opv = operation(v1, v2, optor);
					opnds.push(opv);
				}

				oprts.push(ch);
			}

		}

		while (oprts.size() > 0) {
			char optor = oprts.pop();
			int v2 = opnds.pop();
			int v1 = opnds.pop();
			int opv = operation(v1, v2, optor);
			opnds.push(opv);
		}
		return opnds.peek();
	}

	public static int precedence(char opt) {
		if (opt == '+' || opt == '-') {
			return 1;
		} else {
			return 2;
		}
	}

	public static int operation(int v1, int v2, char opt) {
		if (opt == '+') {
			return v1 + v2;
		} else if (opt == '-') {
			return v1 - v2;
		} else if (opt == '*') {
			return v1 * v2;
		} else {
			return v1 / v2;
		}
	}

    public static List<Integer> removeAdjacentDuplicates(List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        //iterate
        for(int a : list) {

            if(!stack.isEmpty() && stack.peek() == a) {
                stack.pop();
            } else {
                stack.push(a);
            }
        }
        ArrayList result = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        Collections.reverse(result);
        return result;
    }

    public static void sortUtil(Stack<Integer> stack) {

        if(stack.isEmpty())
            return;

        int temp = stack.pop();
        sortUtil(stack);
        sortInserted(stack, temp);
    }

    public static void sortInserted(Stack<Integer> stack, int element) {

        if(stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        sortInserted(stack, element);
        stack.push(temp);
    }

    public static String infixToPostfix(String infix) {

		StringBuffer result = new StringBuffer();
		Stack<Character> stack = new Stack<>();

		for(int i=0;i<infix.length();i++) {

			Character c = infix.charAt(i); //B

			if(Character.isLetterOrDigit(c)) {
				result.append(c);
			}
			else if(c == '(') {
				stack.push(c);
			}
			else if(c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}
				stack.pop();
			}
			else {
				while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
					result.append(stack.pop());
				}
				stack.push(c);
			}

		}
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		return result.toString();
	}

	public static int prec(Character c) {
		switch (c) {
			case '^':
				return 3;
			case '/':
			case '*':
			case '%':
				return 2;
			case '-':
			case '+':
				return 1;
			default:
				return -1;

		}
	}

	public static Stack<Interval> mergeIntervals(List<Interval> list) {

		Stack<Interval> result = new Stack<>();
		Collections.sort(list);
		for(Interval it : list) {
			if(result.isEmpty()) { result.push(it); }
			else if(result.peek().end < it.start) { result.push(it); }
			else if (result.peek().end < it.end){ result.peek().end = it.end; }
		}
		return result;
	}

}
// (5,7) (7,8)
// --------
//      --------


class Interval implements Comparable<Interval> {
	int start;
	int end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Interval o) {
		return this.start - o.start;
	}

	@Override
	public String toString() {
		return (this.start + " " +this.end);
	}
}

//(5,7) , (6,8)


// 5, 3, 6
//liet = 3,5,6
//list2 = 6,5,3


// negative - first lesser than second
// positve - first greater than second

//5,2,1,3,20,15

//15,20,3,1,2,5

//
//AB*
//+