package recursion;

import java.util.ArrayList;
import java.util.HashSet;

public class Recursion3 {

	public static void main(String[] args) {
//		ArrayList<Integer> list1 = new ArrayList<Integer>();
//		list1.add(2);
//		list1.add(3);
//		list1.add(4);
////		System.out.println(list1);

//		ArrayList<Integer> list2 = new ArrayList<Integer>();
//		list2.add(5);
//		list2.add(6);
//		list2.add(7);
////		System.out.println(list2);
//
//		ArrayList<ArrayList<Integer>> bigList = new ArrayList<ArrayList<Integer>>();
//		bigList.add(list1);
//		bigList.add(list2);
//		System.out.println(bigList.get(0).get(2));
//		int[] arr = { 2, 1, 4, 5, 6 };
//		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
////		kPartition(arr, 0, list, 3);
//		int[] arr = { 4, 3, 2, 3, 5, 2, 1 };
//		int[] subsetSum = new int[4];
//		kPartitionSum(arr, 0, list, 4, subsetSum);
//		HashSet<String> hset = new HashSet<>();
//		hset.add("i");
//		hset.add("like");
//		hset.add("sam");
//		hset.add("sung");
//		hset.add("samsung");
//		hset.add("mobile");
//		hset.add("ice");
//		hset.add("and");
//		hset.add("cream");
//		hset.add("icecream");
//		hset.add("man");
//		hset.add("go");
//		hset.add("mango");
//		wordBreak("ilikeicecreamandmango", "", hset);
		ArrayList<String> list = new ArrayList<String>();
		balanceParenthiesis("()())()", "", 0, 0, 7, list);
		int max = 0;
		for (String str : list) {
			max = Math.max(str.length(), max);
		}
		for (String str : list) {
			if (str.length() == max) {
				System.out.println(str);
			}
		}
	}

	public static void kPartition(int[] arr, int vidx, ArrayList<ArrayList<Integer>> list, int k) {
		if (vidx == arr.length) {
			if (list.size() == k) {
				System.out.println(list);
			}
			return;
		}
		if (list.size() == 0) {
			list.add(new ArrayList<Integer>());
			list.get(0).add(arr[vidx]);
			kPartition(arr, vidx + 1, list, k);
			list.remove(0);
		} else {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).add(arr[vidx]);
				kPartition(arr, vidx + 1, list, k);
				list.get(i).remove(list.get(i).size() - 1);
			}

			if (list.size() < k) {
				list.add(new ArrayList<>());
				list.get(list.size() - 1).add(arr[vidx]);
				kPartition(arr, vidx + 1, list, k);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void kPartitionSum(int[] arr, int vidx, ArrayList<ArrayList<Integer>> list, int k, int[] subsetSum) {
		if (vidx == arr.length) {
			if (list.size() == k) {
				for (int i = 1; i < k; i++) {
					if (subsetSum[i] != subsetSum[i - 1]) {
						return;
					}
				}
				System.out.println(list);
			}
			return;
		}
		if (list.size() == 0) {
			list.add(new ArrayList<Integer>());
			list.get(0).add(arr[vidx]);
			subsetSum[0] += arr[vidx];
			kPartitionSum(arr, vidx + 1, list, k, subsetSum);
			list.remove(0);
			subsetSum[0] -= arr[vidx];
		} else {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).add(arr[vidx]);
				subsetSum[i] += arr[vidx];
				kPartitionSum(arr, vidx + 1, list, k, subsetSum);
				subsetSum[i] -= arr[vidx];
				list.get(i).remove(list.get(i).size() - 1);
			}

			if (list.size() < k) {
				list.add(new ArrayList<>());
				list.get(list.size() - 1).add(arr[vidx]);
				subsetSum[list.size() - 1] += arr[vidx];
				kPartitionSum(arr, vidx + 1, list, k, subsetSum);
				subsetSum[list.size() - 1] -= arr[vidx];
				list.remove(list.size() - 1);
			}
		}
	}

	public static void wordBreak(String ques, String ans, HashSet<String> dictionary) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i <= ques.length(); i++) {
			String cutString = ques.substring(0, i);
			if (dictionary.contains(cutString)) {
				String restques = ques.substring(i);
				wordBreak(restques, ans + " " + cutString, dictionary);
			}
		}
	}

	public static void balanceParenthiesis(String ques, String ans, int obkt, int cbkt, int n, ArrayList<String> list) {
		if (cbkt > obkt) {
			return;
		}
		if (obkt > (n / 2)) {
			return;
		}
		if (ques.length() == 0) {
			if (obkt == cbkt) {
//				System.out.println(ans);
				list.add(ans);
			}
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		if (ch == '(') {
			balanceParenthiesis(ros, ans + ch, obkt + 1, cbkt, n, list);
		} else {

			balanceParenthiesis(ros, ans + ch, obkt, cbkt + 1, n, list);
		}

		balanceParenthiesis(ros, ans, obkt, cbkt, n, list);
	}

}
