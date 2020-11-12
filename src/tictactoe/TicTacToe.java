package tictactoe;

import java.util.Scanner;

public class TicTacToe {
	
	private Scanner input = new Scanner(System.in);
	private Board myBoard = new Board();
	
	
	
	public boolean isWinner(String [][] board) {
		
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) {
				
				if ( j == 0) {// horizontal
					//if (board[i][j].contentEquals(board[i][j + 1]) && board[i][j].contentEquals(board[i][j + 2]) && board[i][j].contentEquals(board[i][j + 3]) && board[i][j].contentEquals(board[i][j + 4]))
						//return true;
					boolean aux = true;
					int aux2 = 1;
					do {
						if(board[i][j].contentEquals(board[i][j+aux2]))
							aux2++;
						else
							aux =  false;
					}while ( aux == true && aux2<=4);
					if(aux2 == 5)
						return true;
				}
				
				if (i == 0 ) {// vertical
					/*if (board[i][j].contentEquals(board[i + 1][j]) && board[i][j].contentEquals(board[i + 2][j])&& board[i][j].contentEquals(board[i + 3][j])&& board[i][j].contentEquals(board[i + 4][j]))
						return true;*/
					boolean aux = true;
					int aux2 = 1;
					do {
						if(board[i][j].contentEquals(board[i+aux2][j]))
							aux2++;
						else
							aux =  false;
					}while ( aux == true && aux2<=4);
					if(aux2 == 5)
						return true;
				}/*
				if ((i == 1 && j == 1)) {// diagonal
					if (board[i][j].contentEquals(board[i - 1][j - 1])
							&& board[i][j].contentEquals(board[i + 1][j + 1]))
						return true;
					else if (board[i][j].contentEquals(board[i - 1][j + 1])
							&& board[i][j].contentEquals(board[i + 1][j - 1]))
						return true;
				}*/

			}
		}
		
		return false;
	}
	
	public void play() {
		myBoard.printBoard();
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
			myBoard.printBoard();
			isWinner = isWinner(myBoard.getBoard());
			aux++;
		}while(isWinner == false && aux <= 25);
		
		if(aux == 26 && isWinner == false)
			System.out.print("DRAW!");
		else
			System.out.print(mark+" WINNER!!!");	
	}
	
	public String checkMark() {
		String pos = "";
		boolean aux = false;
		
		pos = input.nextLine();
		do {
			for(int i = 0 ; i < myBoard.getPositions().size();i++)
				if(pos.contentEquals(myBoard.getPositions().get(i))) {
					aux = true;
					myBoard.removeArrayPosition(pos);
					break;
				}
			if(aux == false) {
				System.out.print("Wrong move, try again: ");
				pos = input.nextLine();
			}
				
		}while(aux == false);
		
		return pos;
	}
}