package tictactoe;

import java.util.ArrayList;

public class Board {
	
	private static final int BOARD_SIZE = 5;
	private static final int ROWS = BOARD_SIZE*3;
	private static final int COLUMNS = BOARD_SIZE*6;
	
	private String[][] guiBoard = new String[ROWS+1][COLUMNS+1];
	private String[][] board 	= new String[BOARD_SIZE][BOARD_SIZE];
	ArrayList<String> positions = new ArrayList<String>();
	
	public Board() {
		initializeArrayPositions();
		generateEmptyBoard();
		generateEmptyGUIBoard();
		
	}
	public void generateEmptyBoard() {
		int aux = 0;
		for(int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = positions.get(aux);
				aux++;
			}
		}
	}
	public void mark(String pos, String mark) {
		for (int i = 0; i <= ROWS; i++)
			for (int j = 0; j <= COLUMNS; j++)
				if (guiBoard[i][j].contentEquals(pos))
					guiBoard[i][j] = mark;
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++)
				if (board[i][j].contentEquals(pos))
					board[i][j] = mark;
	}
	public void removeArrayPosition(String pos) {
		positions.remove(positions.indexOf(pos));
	}
	public void generateEmptyGUIBoard() {
		for (int i = 0; i <= ROWS; i++)
			for (int j = 0; j <= COLUMNS; j++) {
				if (i!=0 && j % 6 == 0 )
					guiBoard[i][j] = "|";
				else if (i % 3 == 0)
					guiBoard[i][j] = "_";
				else
					guiBoard[i][j] = " ";
			}
		
		int j = 2, k = 3;
		for(int i = 0 ; i < positions.size(); i++) {
			if(i != 0 && i % BOARD_SIZE == 0) {
				k = 3;
				j += 3;
			}
			guiBoard[j][k] = positions.get(i);
			
			k += 6;
		}
	}
	public void initializeArrayPositions() {
		for(int i = 1; i <= BOARD_SIZE*BOARD_SIZE; i++)
			positions.add(String.valueOf(i));
		//String prueba = "ABCDEFGHIJKLMN�PQRSTUVWYZ0123456789abcdefghijklmn�pqrstuvwyz*-%$";
		//for (int i = 0;i < BOARD_SIZE*BOARD_SIZE; i++)
			//positions.add(String.valueOf(prueba.charAt(i)));
	}
	public void printBoard() {
		for (int i = 0; i <= ROWS; i++) {
			for (int j = 0; j <= COLUMNS; j++)
				System.out.print(guiBoard[i][j]);
			System.out.println("");
		}
	}
	public String[][] getBoard() {
		return board;
	}

	public String[][] getGuiBoard() {
		return guiBoard;
	}
	
	public ArrayList<String> getPositions() {
		
		return positions;
		
	}
}