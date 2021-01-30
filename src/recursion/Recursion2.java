package recursion;

public class Recursion2 {

	public static void main(String[] args) {
//		printBoardPaths(0, 10, "");
//		System.out.println(count);
//		System.out.println(numberBoardPaths(0, 10));
//		printMazePaths(0, 0, 2, 2, "");
//		System.out.println(numberMazePaths(0, 0, 2, 2));
//		boolean[][] board = new boolean[4][4];
//		printNQueens(board, 0, "");
//		printLexico(1, 1000);
		int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		System.out.println(solveSudoku(board));
	}

	static int count = 0;

//	reactive method
	public static void printBoardPaths(int curr, int end, String ans) {
		if (curr == end) {
			count++;
			System.out.println(ans);
			return;
		}
		if (curr > end) {
			return;
		}
		for (int i = 1; i <= 6; i++) {
			printBoardPaths(curr + i, end, ans + i);
		}
	}

//	Proactive
	public static void printBoardPathsPro(int curr, int end, String ans) {
		if (curr == end) {
			System.out.println(ans);
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if (curr + i <= end) {
				printBoardPathsPro(curr + i, end, ans + i);
			}
		}
	}

	public static int numberBoardPaths(int curr, int end) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		int count = 0;
		for (int i = 1; i <= 6; i++) {
			count += numberBoardPaths(curr + i, end);
		}

		return count;
	}

	public static void printMazePaths(int cr, int cc, int er, int ec, String psf) {
		if (cr == er && cc == ec) {
			System.out.println(psf);
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}
		

		printMazePaths(cr + 1, cc, er, ec, psf + "V");
		printMazePaths(cr, cc + 1, er, ec, psf + "H");
		printMazePaths(cr + 1, cc + 1, er, ec, psf + "D");
	}

	public static int numberMazePaths(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}
		return numberMazePaths(cr + 1, cc, er, ec) + numberMazePaths(cr, cc + 1, er, ec)
				+ numberMazePaths(cr + 1, cc + 1, er, ec);
	}

	public static void printNQueens(boolean[][] board, int row, String asf) {
		if (row == board.length) {
			System.out.println(asf);
			return;
		}

		for (int col = 0; col < board[0].length; col++) {
			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				printNQueens(board, row + 1, asf + "[" + row + "-" + col + "]");
				board[row][col] = false;
			}
		}
	}

	private static boolean isItSafe(boolean[][] board, int row, int col) {
//		for column
		for (int i = 0; i < row; i++) {
			if (board[i][col] == true) {
				return false;
			}
		}
//		diagonal 1
		int r = row - 1;
		int c = col - 1;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c--;
		}

//		diagonal 2
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board.length) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c++;
		}

		return true;
	}

	public static void printLexico(int num, int max) {
		if (num <= max) {
			System.out.println(num);
		}
		for (int i = 0; i <= 9; i++) {
			if (num * 10 + i <= max) {
				printLexico(num * 10 + i, max);
			}
		}

		if (num < 9) {
			printLexico(num + 1, max);
		}
	}

	public static boolean solveSudoku(int[][] board) {
		int row = -1;
		int col = -1;
		boolean isFilled = true;
		outer: for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;
					isFilled = false;
					break outer;
				}
			}
		}

		if (isFilled) {
//			print the board here
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					System.out.print(board[i][j] + "\t");
				}
				System.out.println();
			}
			return true;
		}

		for (int k = 1; k <= 9; k++) {
			if (isSafeSudoku(k, row, col, board)) {
				board[row][col] = k;
				if (solveSudoku(board) == true) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}

		return false;
	}

	private static boolean isSafeSudoku(int k, int row, int col, int[][] board) {
		for (int i = 0; i <= row; i++) {
			if (board[i][col] == k) {
				return false;
			}
		}

		for (int j = 0; j <= col; j++) {
			if (board[row][j] == k) {
				return false;
			}
		}

		int sqrt = (int) Math.sqrt(board.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;
		for (int i = boxRowStart; i < boxRowStart + sqrt; i++) {
			for (int j = boxColStart; j < boxColStart + sqrt; j++) {
				if (board[i][j] == k) {
					return false;
				}
			}
		}

		return true;
	}

}
