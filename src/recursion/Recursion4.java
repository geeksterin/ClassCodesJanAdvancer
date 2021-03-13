public class Recursion4 {

	public static void main(String[] args) {
//		int[] arr = { 10, 7, 9, 11, 5, 90, 1 };
//		quickSort(arr, 0, arr.length - 1);
//		for (int val : arr) {
//			System.out.print(val + " ");
//		StringBuilder sb = new StringBuilder("abc");
//		sb.append('d');
//		sb.charAt(0);
//		sb.toString();
		// binaryStrings("1??0?101",new StringBuilder(), 0);
		toh(3,'A','B','C');
//		}
	}

	public static void toh(int n, char src, char dest, char help){
		if(n==0){
			return;
		}
		toh(n-1,src,help,dest);
		System.out.println("Move "+n+"th disk from "+src+" to "+dest);
		toh(n-1,help,dest,src);
	}



	public static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = l + (r - l) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			mergeTwoSortedArrays(arr, l, mid, r);
		}
	}

	private static void mergeTwoSortedArrays(int[] arr, int l, int m, int r) {
		int size1 = m - l + 1;
		int size2 = r - m;

		int arr1[] = new int[size1];
		int arr2[] = new int[size2];
		for (int i = 0; i < size1; i++) {
			arr1[i] = arr[l + i];
		}

		for (int i = 0; i < size2; i++) {
			arr2[i] = arr[m + i + 1];
		}

		int i = 0, j = 0;
		int k = l;
		while (i < size1 && j < size2) {
			if (arr1[i] < arr2[j]) {
				arr[k] = arr1[i];
				i++;
			} else {
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}

		while (i < size1) {
			arr[k] = arr1[i];
			i++;
			k++;
		}

		while (j < size2) {
			arr[k] = arr2[j];
			j++;
			k++;
		}
	}

	public static void quickSort(int[] arr, int lo, int hi) {
		if (lo < hi) {
			int pi = partition(arr, lo, hi);
			quickSort(arr, lo, pi - 1);
			quickSort(arr, pi + 1, hi);
		}
	}

	public static int partition(int[] arr, int lo, int hi) {
		int pivot = arr[hi];
		int i = lo - 1;
		for (int j = lo; j < hi; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}

		swap(arr, i + 1, hi);
		return i + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void binaryStrings(String ques, StringBuilder ans, int vidx) {
		if (vidx == ques.length()) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(vidx);
		if (ch != '?') {
			ans.append(ch);
			binaryStrings(ques, ans, vidx + 1);
			ans.deleteCharAt(ans.length() - 1);
		} else {
			ans.append("0");
			binaryStrings(ques, ans, vidx + 1);
			ans.deleteCharAt(ans.length() - 1);
			ans.append("1");
			binaryStrings(ques, ans, vidx + 1);
			ans.deleteCharAt(ans.length() - 1);
		}
	}

}
