package intro;

import java.util.Scanner;

public class Intro {

	public static void main(String[] args) {
//		System.out.println("Hello World");
//		System.out.println("Hello World");
//		int val = 60;
//		System.out.println(val);
//		System.out.println("val");
//
//		if (val < 50) {
//			System.out.println("Geekster");
//		} else if (val < 70) {
//			System.out.println("Geekster2");
//		} else {
//			System.out.println("Geekster3");
//		}
//
		Scanner scn = new Scanner(System.in);
//		int val1 = scn.nextInt();
//		int val2 = scn.nextInt();
//		int val3 = scn.nextInt();
//
//		if (val1 > val2) {
//			if (val1 > val3) {
//				System.out.println(val1);
//			} else {
//				System.out.println(val3);
//			}
//		} else {
//			if (val2 > val3) {
//				System.out.println(val2);
//			} else {
//				System.out.println(val3);
//			}
//		}
//		
//		char ch = 'a';
//		String str = "abcd";
//		boolean flag = true;
//		double db = 3.14;

//		int c = 42;
//		double f = ((9*c*1.0)/5)+32;
//		System.out.println(f);

//		float ft = 3.14f;

//		for(int i=0;i<5;i++) {
//			System.out.println("Geekster");
//		}

//		int sum = 0;
//		for(int i=1;i<=5;i++) {
//			sum = sum+i;
//		}
//		
//		System.out.println(sum);
//		
//		int n = scn.nextInt();
//		
//		int max = Integer.MIN_VALUE;
//		
//		for(int i=0;i<n;i++) {
//			int val = scn.nextInt();
//			if(val>max) {
//				max = val;
//			}
//		}
//		
//		System.out.println(max);

//		boolean isPrime = true;
//		int n = 16;
//		for (int i = 2; i < n; i++) {
//			if (n % i == 0) {
//				isPrime = false;
//				break;
//			}
//		}
//
//		if (isPrime == true) {
//			System.out.println("Prime");
//		} else {
//			System.out.println("Not Prime");
//		}

//		boolean isPrime = true;
//		int n = 16;
//		for (int i = 2; i <= n/2; i++) {
//			if (n % i == 0) {
//				isPrime = false;
//				break;
//			}
//		}
//
//		if (isPrime == true) {
//			System.out.println("Prime");
//		} else {
//			System.out.println("Not Prime");
//		}

//		boolean isPrime = true;
//		int n = 16;
//		for (int i = 2; i * i <= n; i++) {
//			if (n % i == 0) {
//				isPrime = false;
//				break;
//			}
//		}
//
//		if (isPrime == true) {
//			System.out.println("Prime");
//		} else {
//			System.out.println("Not Prime");
//		}

//		func(5);
//		func(10);

//		System.out.println(reverseDigits(12340));		
	}

	

	public static void func(int val) {
		System.out.println(val);
	}

	public static int reverseDigits(int num) {
		int rev = 0;
		while (num > 0) {
			int rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}

		return rev;
	}

}
