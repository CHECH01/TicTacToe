package tictactoe;

public class Board {
	private String[][] board 	= { { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" } };
	private String[][] guiBoard = new String[9][17];

	public void printBoard() {
		for (int i = 0; i <= 8; i++) {
			for (int j = 0; j <= 16; j++)
				System.out.print(guiBoard[i][j]);
			System.out.println("");
		}
	}

	public boolean isWinner() {
		for (int i = 0; i <= 2; i++)
			for (int j = 0; j <= 2; j++) {
				if ((i == 0 && j == 0) || (i == 1 && j == 0) || (i == 2 && j == 0)) {// horizontal
					if (board[i][j].contentEquals(board[i][j + 1]) && board[i][j].contentEquals(board[i][j + 2]))
						return true;
				}
				if ((i == 0 && j == 0) || (i == 0 && j == 1) || (i == 0 && j == 2)) {// vertical
					if (board[i][j].contentEquals(board[i + 1][j]) && board[i][j].contentEquals(board[i + 2][j]))
						return true;
				}
				if ((i == 1 && j == 1)) {// diagonal
					if (board[i][j].contentEquals(board[i - 1][j - 1])
							&& board[i][j].contentEquals(board[i + 1][j + 1]))
						return true;
					else if (board[i][j].contentEquals(board[i - 1][j + 1])
							&& board[i][j].contentEquals(board[i + 1][j - 1]))
						return true;
				}

			}
		return false;
	}

	public void mark(String pos, String mark) {
		for (int i = 0; i <= 8; i++)
			for (int j = 0; j <= 16; j++)
				if (guiBoard[i][j].contentEquals(pos))
					guiBoard[i][j] = mark;
		for (int i = 0; i <= 2; i++)
			for (int j = 0; j <= 2; j++)
				if (board[i][j].contentEquals(pos))
					board[i][j] = mark;
	}

	public void generateEmptyBoard() {
		for (int i = 0; i <= 8; i++)
			for (int j = 0; j <= 16; j++) {
				if (j == 5 || j == 11)
					guiBoard[i][j] = "|";
				else if (i == 2 || i == 5)
					guiBoard[i][j] = "_";
				else
					guiBoard[i][j] = " ";
			}
		guiBoard[1][2] 	= "A";
		guiBoard[1][8] 	= "B";
		guiBoard[1][14] = "C";
		guiBoard[4][2] 	= "D";
		guiBoard[4][8] 	= "E";
		guiBoard[4][14] = "F";
		guiBoard[7][2] 	= "G";
		guiBoard[7][8] 	= "H";
		guiBoard[7][14] = "I";
	}
}