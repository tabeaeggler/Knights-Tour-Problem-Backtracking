/**
 * Knight's tour backtracking
 */
public final class Springer {
	public static int[][] moves = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 },
			{ -1, -2 } };

	private static boolean solved(boolean[][] board) {
		return solved(board, 0, 0, 0);
	}

	private static boolean solved(boolean[][] board, int step, int row, int col) {
		if (step == (board.length * board.length) - 1) {
			return true;
		} else {
			boolean found = false;
			int direction = 0;
			while (direction < 8 && !found) {
				if (canMove(board, direction, row, col)) {
					row += moves[direction][0];
					col += moves[direction][1];
					board[row][col] = true;
					found = solved(board, step + 1, row, col);
					if (!found) {
						board[row][col] = false;
						row -= moves[direction][0];
						col -= moves[direction][1];
					}
				}
				direction++;
			}
			return found;
		}
	}

	private static boolean canMove(boolean[][] board, int direction, int row, int col) {
		row += moves[direction][0];
		col += moves[direction][1];
		if(row < 0 || row >= board.length || col < 0 || col >= board.length || board[row][col] == true ) return false;
		else return true;
		
	}

	public static void main(String[] args) {
		final int N = 7;
		boolean[][] board = new boolean[N][N];

		if (solved(board)) {
			BoardPrinter.print(board);
		} else {
			System.err.println("No solution found for N = " + N);
			BoardPrinter.print(board);
		}

	}

}
