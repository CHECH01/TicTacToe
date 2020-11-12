package tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
	
	private Scanner input = new Scanner(System.in);
	private Board myBoard = new Board();
	ArrayList<String> myArray = new ArrayList<String>();
	
	public TicTacToe() {
		initializeArray();
	}
	
	public void printBoard(String[][] guiBoard) {
		for (int i = 0; i <= 8; i++) {
			for (int j = 0; j <= 16; j++)
				System.out.print(guiBoard[i][j]);
			System.out.println("");
		}
	}
	
	public boolean isWinner(String [][] board) {
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
	
	public void play() {
		printBoard(myBoard.getGuiBoard());
		String mark = "";
		int aux = 1;
		boolean isWinner = false;
		do {
			if(aux % 2 == 0) {
				mark = "O";
				System.out.print("Player O move: ");
			}else {
				mark = "X";
				System.out.print("Player X move: ");
			}
			myBoard.mark(checkMark(),mark);
			printBoard(myBoard.getGuiBoard());
			isWinner = isWinner(myBoard.getBoard());
			aux++;
		}while(isWinner == false && aux < 10);
		
		if(aux == 10 && isWinner == false)
			System.out.print("DRAW!");
		else
			System.out.print(mark+" WINNER!!!");	
	}
	
	public String checkMark() {
		String pos = "";
		boolean aux = false;
		
		pos = input.nextLine();
		do {
			for(int i = 0 ; i < myArray.size();i++)
				if(pos.contentEquals(myArray.get(i))) {
					aux = true;
					myArray.remove(myArray.indexOf(pos));
					break;
				}
			if(aux == false) {
				System.out.print("Wrong move, try again: ");
				pos = input.nextLine();
			}
				
		}while(aux == false);
		
		return pos;
	}
	
	public void initializeArray() {
		myArray.add("A");
		myArray.add("B");
		myArray.add("C");
		myArray.add("D");
		myArray.add("E");
		myArray.add("F");
		myArray.add("G");
		myArray.add("H");
		myArray.add("I");
	}
}