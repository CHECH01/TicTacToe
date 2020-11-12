package tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static Scanner input;
	ArrayList<String> myArray = new ArrayList<String>();
	public static void main(String[] args) {
		input = new Scanner(System.in);
		Main tictactoe = new Main();
		tictactoe.initializeArray();
		Board myBoard = new Board();
		myBoard.generateEmptyBoard();
		myBoard.printBoard();
		tictactoe.play(myBoard);
	}
	public void play(Board myBoard) {	
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
			isWinner = myBoard.isWinner();
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