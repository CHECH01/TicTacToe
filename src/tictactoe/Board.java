package tictactoe;

import java.util.ArrayList;

public class Board {
	
	private static final int BOARD_SIZE = 10;
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
		/*
		System.out.println("J: " +j);
		guiBoard[2][3] 	= positions.get(0);
		guiBoard[2][9] 	= positions.get(1);
		guiBoard[2][15] = positions.get(2);
		guiBoard[5][3] 	= positions.get(3);
		guiBoard[5][9] 	= positions.get(4);
		guiBoard[5][15] = positions.get(5);
		guiBoard[8][3] 	= positions.get(6);
		guiBoard[8][9] 	= positions.get(7);
		guiBoard[8][15] = positions.get(8);*/
	}
	public void initializeArrayPositions() {
		for(int i = 1; i <= BOARD_SIZE*BOARD_SIZE; i++)
			positions.add(" ");
		/*
	//-----------3x3-------------
		positions.add("A");//0
		positions.add("B");//1
		positions.add("C");//2
		positions.add("D");//3
		positions.add("E");//4
		positions.add("F");//5
		positions.add("G");//6
		positions.add("H");//7
		positions.add("I");//8*/
/*	
	//-----------4x4-------------
		positions.add("J");//9
		positions.add("K");//10
		positions.add("L");//11
		positions.add("M");//12
		positions.add("N");//13
		positions.add("Ö");//14
		positions.add("P");//15*/
/*	//-----------5x5-------------
		positions.add("Q");//16
		positions.add("R");//17
		positions.add("S");//18
		positions.add("T");//19
		positions.add("U");//20
		positions.add("V");//21
		positions.add("W");//22
		positions.add("Y");//23
		positions.add("Z");//24*/
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
	public void helper() {
		//					0123456789012345678
		System.out.println("___________________");//0
		System.out.println("|     |     |     |");//1
		System.out.println("|  A  |  B  |  C  |");//2
		System.out.println("|_____|_____|_____|");//3
		System.out.println("|     |     |     |");//4
		System.out.println("|  D  |  E  |  F  |");//5
		System.out.println("|_____|_____|_____|");//6
		System.out.println("|     |     |     |");//7
		System.out.println("|  G  |  H  |  I  |");//8
		System.out.println("|_____|_____|_____|");//9
		

					//		01234567890123456789012345		
		System.out.println("    1     2     3     4   ");//0
		System.out.println(" _________________________");//1
		System.out.println(" |     |     |     |     |");//2
		System.out.println("1|  -  |  -  |  -  |  -  |");//3
		System.out.println(" |_____|_____|_____|_____|");//4
		System.out.println(" |     |     |     |     |");//5
		System.out.println("2|  -  |  -  |  -  |  -  |");//6
		System.out.println(" |_____|_____|_____|_____|");//7
		System.out.println(" |     |     |     |     |");//8
		System.out.println("3|  -  |  -  |  -  |  -  |");//9
		System.out.println(" |_____|_____|_____|_____|");//10
		System.out.println(" |     |     |     |     |");//11
		System.out.println("4|  -  |  -  |  -  |  -  |");//12
		System.out.println(" |_____|_____|_____|_____|");//13
	}
	
}