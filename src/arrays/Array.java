package arrays;

public class Array {

	public static void main(String[] args) {
//		int k = 2;
//		int[] arr = { 10,20,30,40,50 };
//		paintersPartition(arr, k);

//		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
//		for (int j = 0; j < arr[0].length; j++) {
//			for(int i=0;i<arr.length;i++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}

//		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
//		printWave(arr);

		int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };
		printSpiral(arr);
	}

	private static void printSpiral(int[][] arr) {
		int startRow = 0;
		int endRow = arr.length - 1;
		int startCol = 0;
		int endCol = arr[0].length - 1;
		while (startRow <= endRow && startCol <= endCol) {
			for (int i = startCol; i <= endCol; i++) {
				System.out.println(arr[startRow][i]);
			}
			startRow++;
			for (int i = startRow; i <= endRow; i++) {
				System.out.println(arr[i][endCol]);
			}
			endCol--;

			for (int i = endCol; i >= startCol; i--) {
				System.out.println(arr[endRow][i]);
			}
			endRow--;

			for (int i = endRow; i >= startRow; i--) {
				System.out.println(arr[i][startCol]);
			}
			startCol++;
		}
	}

	public static void printWave(int[][] arr) {
		boolean flag = false;
		for (int j = 0; j < arr[0].length; j++) {
			if (flag == false) {
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i][j] + " ");
				}
			} else {
				for (int i = arr.length - 1; i >= 0; i--) {
					System.out.print(arr[i][j] + " ");
				}
			}
			flag = !flag;
			System.out.println();
		}
	}

	private static void paintersPartition(int[] arr, int k) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int val : arr) {
			sum += val;
			max = Math.max(val, max);
		}

		int lo = max; // n painters
		int hi = sum; // 1 painter
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			int paintersReqd = paintersCalc(arr, mid);
			if (paintersReqd <= k) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		System.out.println(lo);
	}

	private static int paintersCalc(int[] arr, int time) {
		int painterCount = 1;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > time) {
				sum = arr[i];
				painterCount++;
			}
		}
		return painterCount;
	}

}
