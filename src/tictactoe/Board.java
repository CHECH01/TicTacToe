package tictactoe;

public class Board {
	private String[][] board 	= { { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" } };
	private String[][] guiBoard = new String[9][17];
	
	public Board() {
		generateEmptyBoard();
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
	
	public String[][] getBoard() {
		return board;
	}

	public String[][] getGuiBoard() {
		return guiBoard;
	}
}