package intro;


public class Patterns {

	public static void main(String[] args) {
//		printPattern6(4);
		char ch = 'A';
		System.out.println((int)ch);
	}

	public static void printPattern1(int n) {
		int row = 1;
		int cst = 1; // just a var to run my loop
		int nst = 1; // var to represent number of stars in first line
		while (row <= n) {
			cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			System.out.println();
			nst++;
			row++;
		}

	}

	public static void printPattern2(int n) {
		int row = 1;
		int cst = 1; // just a var to run my loop
		int nst = 1; // var to represent number of stars in first line
		while (row <= n) {
			cst = 1;
			while (cst <= nst) {
				System.out.print(cst);
				cst++;
			}

			System.out.println();
			nst++;
			row++;
		}

	}

	public static void printPattern3(int n) {
		int row = 1;
		int cst = 1; // just a var to run my loop
		int nst = 1; // var to represent number of stars in first line
		int count = 1;
		while (row <= n) {
			cst = 1;
			while (cst <= nst) {
				System.out.print(count + "\t");
				count++;
				cst++;
			}

			System.out.println();
			nst++;
			row++;
		}

	}

	public static void printPattern4(int n) {
		int row = 1;
		int nst = 1;
		int nsp = n - 1;

		while (row <= n) {
			int csp = 1;
			int cst = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			nsp--;
			nst++;

			System.out.println();
			row++;
		}

	}

	public static void printPattern5(int n) {
		int row = 1;
		int nst = 1;
		int nsp = n - 1;

		while (row <= n) {
			int csp = 1;
			int cst = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			nsp--;
			nst += 2;

			System.out.println();
			row++;
		}

	}

	public static void printPattern6(int n) {
		int row = 1;
		int nst = 1;
		int nsp = n - 1;

		while (row <= (2 * n - 1)) {
			int csp = 1;
			int cst = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			if (row < n) {
				nsp--;
				nst += 2;
			} else {
				nsp++;
				nst -= 2;
			}
			System.out.println();
			row++;
		}

	}

}
