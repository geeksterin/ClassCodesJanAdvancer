package recursion;

import java.util.ArrayList;

public class Reursion {

	public static void main(String[] args) {
//		System.out.println(powerBtr(2, 10));
		int[] arr = { 50, 13, 29, 50, 89, 12, 50 };
//		printReverseArray(arr, 0);
//		System.out.println(lastIndex(arr, 0, 50));
//		int[] temp = allIndices(arr, 0, 50, 0);
//		for (int t : temp) {
//			System.out.println(t);
//		}

//		System.out.println(getPerm("abc"));
		Math.exp(55);
	}

	public static void printDecreasing(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		printDecreasing(n - 1);

	}

	public static void printIncreasing(int n) {
		if (n == 0) {
			return;
		}
		printIncreasing(n - 1);
		System.out.println(n);

	}

	public static void printIncreasingDecreasing(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 != 0) {
			System.out.println("hi " + n);
		}
//		pre area above
		printIncreasingDecreasing(n - 1);
//		post area below
		if (n % 2 == 0) {
			System.out.println("bye " + n);
		}
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		int fnm1 = factorial(n - 1);
		int fn = fnm1 * n;
		return fn;
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int fbnm1 = fib(n - 1);
		int fbnm2 = fib(n - 2);
		int fibn = fbnm1 + fbnm2;
		return fibn;
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int xpnm1 = power(x, n - 1);
		return x * xpnm1;
	}

	public static int powerBtr(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int xpnby2 = powerBtr(x, n / 2);
		if (n % 2 == 0) {
			return xpnby2 * xpnby2;
		} else {
			return xpnby2 * xpnby2 * x;
		}
	}

	public static void printArray(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		System.out.println(arr[vidx]);
		printArray(arr, vidx + 1);
	}

	public static void printReverseArray(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		printReverseArray(arr, vidx + 1);
		System.out.println(arr[vidx]);
	}

	public static int max(int[] arr, int vidx) {
		if (vidx == arr.length - 1) {
			return arr[vidx];
		}
		int maxmAfterMe = max(arr, vidx + 1);
		if (maxmAfterMe > arr[vidx]) {
			return maxmAfterMe;
		} else {
			return arr[vidx];
		}
	}

	public static boolean find(int[] arr, int val, int vidx) {
		if (vidx == arr.length) {
			return false;
		}
		boolean fnm1 = find(arr, val, vidx + 1);
		if (fnm1 == true) {
			return true;
		} else {
			if (arr[vidx] == val) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static boolean find2(int[] arr, int val, int vidx) {
		if (vidx == arr.length) {
			return false;
		}
		if (arr[vidx] == val) {
			return true;
		}
		boolean fnm1 = find(arr, val, vidx + 1);
		return fnm1;
	}

	public static int firstIndex(int[] arr, int vidx, int val) {
		if (vidx == arr.length) {
			return -1;
		}
		if (arr[vidx] == val) {
			return vidx;
		} else {
			return firstIndex(arr, vidx + 1, val);
		}
	}

	public static int lastIndex(int[] arr, int vidx, int val) {
		if (vidx == arr.length) {
			return -1;
		}

		int foundIdx = lastIndex(arr, vidx + 1, val);
		if (foundIdx == -1) {
			if (arr[vidx] == val) {
				return vidx;
			} else {
				return -1;
			}
		} else {
			return foundIdx;
		}

	}

	public static int[] allIndices(int[] arr, int vidx, int data, int fsf) {
		if (vidx == arr.length) {
			return new int[fsf];
		}

		if (arr[vidx] == data) {
			int[] aia = allIndices(arr, vidx + 1, data, fsf + 1);
			aia[fsf] = vidx;
			return aia;
		} else {
			int[] aia = allIndices(arr, vidx + 1, data, fsf);
			return aia;
		}
	}

	public static ArrayList<String> getSS(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> rr = getSS(ros);
		ArrayList<String> mr = new ArrayList<String>();
		for (String rs : rr) {
			mr.add(rs);
			mr.add(ch + rs);
		}

		return mr;
	}

	public static ArrayList<String> getPerm(String s) {

		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);

		ArrayList<String> rr = getPerm(ros);
		ArrayList<String> mr = new ArrayList<String>();
		for (String rs : rr) {
			for (int i = 0; i <= rs.length(); i++) {
				String ms = rs.substring(0, i) + ch + rs.substring(i);
				mr.add(ms);
			}
		}

		return mr;
	}

}
