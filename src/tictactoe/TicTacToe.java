package tictactoe;

import java.util.Scanner;

public class TicTacToe {
	
	private Scanner input = new Scanner(System.in);
	private Board myBoard = new Board();
	
	
	
	public boolean isWinner(String [][] board) {
		boolean isWinner = false;
		first:
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				
				if ( j == 0 && isWinner == false)// horizontal
					isWinner = check(i,j,board,0,1);
				
				if (i == 0 && isWinner == false) // vertical
					isWinner = check(i,j,board,1,0);
				
				if (i == 0 && j == 0 && isWinner == false) // diagonal 1
					isWinner = check(i,j,board,1,1);
				
				if (i == 0 && j == board.length-1 && isWinner == false) // diagonal 2
					isWinner = check(i,j,board,1,-1);
				
				if(isWinner == true)
					break first;

			}
		}
		return isWinner;
	}
	public boolean check(int i, int j, String board[][],int aux1,int aux2) {
		boolean aux = true;
		int aux3=aux1;
		int aux4=aux2;
		int cont = 1;
		do {
			if(board[i][j].contentEquals(board[i+aux3][j+aux4])) {
				cont++;
				aux3+=aux1;
				aux4+=aux2;
			}
			else
				aux =  false;
		}while ( aux == true && cont<board.length);
		if(cont == board.length)
			return true;
		else 
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
		}while(isWinner == false && aux <= myBoard.getBoard().length*myBoard.getBoard().length);
		
		if(aux == (myBoard.getBoard().length*myBoard.getBoard().length+1) && isWinner == false)
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