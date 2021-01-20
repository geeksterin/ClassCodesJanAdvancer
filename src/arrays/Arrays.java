package arrays;

import java.util.*;

public class Arrays {

	public static void main(String[] args) {
//		int[] arr = new int[5];
//		int[] arr2 = {1,2,3,4,5};
//		for(int i=0;i<arr2.length;i++) {
//			System.out.println(arr2[i]);
//		}

//		System.out.println(arr[10]);

//		for each loop
//		for(int val:arr) {
//			System.out.println(val);
//		}
//		
////		printing reverse
//		for(int i = arr.length-1;i>=0;i--) {
//			System.out.println(arr2[i]);
//		}

//		int[] arr = { 1, 3, 4, 5, 6, 7, 10 };
//		int target = 11;
////		targetPairSum(target, arr);
//		targetPairSumSorted(target, arr);

//		int[] arr = {7,1,5,3,6,4};
//		stocks1(arr);

//		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
//		trap(arr);

//		ArrayList<Integer> list = new ArrayList<>();
//		list.add(5);
//		list.add(6);
//		list.add(7);
//		System.out.println(list);
//		System.out.println(list.get(0));
//		System.out.println(list.size());
//		list.remove(0);
//		System.out.println(list);

//		ArrayList<Integer> list1 = new ArrayList<>();
//		list1.add(10);
//		list1.add(20);
//		list1.add(30);
//		list1.add(40);
//		list1.add(50);
//
//		ArrayList<Integer> list2 = new ArrayList<>();
//		list2.add(5);
//		list2.add(20);
//		list2.add(25);
//		list2.add(45);
//		list2.add(50);
//
//		System.out.println(mergeTwoSortedLists(list1, list2));
		
		int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		majorityElement(arr);
	}

	public static void stocks1(int[] arr) {
		int currMin = arr[0];
		int maxProfit = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > currMin) {
				int profit = arr[i] - currMin;
				maxProfit = Math.max(maxProfit, profit);
			}

			currMin = Math.min(currMin, arr[i]);
		}

		System.out.println(maxProfit);
	}

	private static void targetPairSumSorted(int target, int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		while (l < r) {
			int currSum = arr[l] + arr[r];
			if (currSum < target) {
				l++;
			} else if (currSum > target) {
				r--;
			} else {
				System.out.println(arr[l] + " " + arr[r]);
				l++;
				r--;
			}
		}
	}

	public static void targetPairSum(int val, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == val) {
					System.out.println(arr[i] + " " + arr[j]);
				}
			}
		}
	}

	public static void trap(int[] height) {
		int[] lmax = new int[height.length];
		int[] rmax = new int[height.length];

		lmax[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			lmax[i] = Math.max(lmax[i - 1], height[i]);
		}

		rmax[height.length - 1] = height[height.length - 1];

		for (int i = height.length - 2; i >= 0; i--) {
			rmax[i] = Math.max(rmax[i + 1], height[i]);
		}

		int ans = 0;

		for (int i = 0; i < height.length; i++) {
			int minWalls = Math.min(lmax[i], rmax[i]);

			if (minWalls > height[i]) {
				ans += minWalls - height[i];
			}
		}

		System.out.println(ans);
	}

	public static ArrayList<Integer> mergeTwoSortedLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		int ptr1 = 0;
		int ptr2 = 0;
		ArrayList<Integer> res = new ArrayList<>();
		while (ptr1 < list1.size() && ptr2 < list2.size()) {
			if (list1.get(ptr1) < list2.get(ptr2)) {
				res.add(list1.get(ptr1));
				ptr1++;
			} else {
				res.add(list2.get(ptr2));
				ptr2++;
			}
		}

		while (ptr1 < list1.size()) {
			res.add(list1.get(ptr1));
			ptr1++;
		}

		while (ptr2 < list2.size()) {
			res.add(list2.get(ptr2));
			ptr2++;
		}
		return res;
	}

	public static void majorityElement(int[] arr) {
		int majIdx = 0;
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[majIdx]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				majIdx = i;
				count = 1;
			}
		}
		
		System.out.println(arr[majIdx]);
	}

}
