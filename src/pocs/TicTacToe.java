package pocs;

import java.util.Scanner;

public class TicTacToe {
	static char[][] arr = new char[3][3];
	static char player;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		char ng ='N';
		do {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = ' ';

				}
			}
			System.out.println("Welcome to TicTacToe Game!");
			printBoard();

			System.out.println("Choose your character (X or O):");
			player = Character.toUpperCase(sc.nextLine().charAt(0));
			if(player != 'X' && player != 'O') {
			    System.out.println("Invalid character! Choose X or O.");
			    continue;
			}
			System.out.println("You choosed: " + player);
			if (player == 'X') {
				System.out.println("Opponent character is: O");

			}
			if (player == 'O') {
				System.out.println("Opponent character is: X");

			}

			while (true) {
				printBoard();

				System.out.println(player + " Your Turn!!");

				System.out.println("Enter for row from 0-2 numbers positions!!");
				int row = sc.nextInt();

				System.out.println("Enter for col from 0-2 numbers positions!!");
				int col = sc.nextInt();
				if (row < 0 || row > 2 || col < 0 || col > 2 || arr[row][col] != ' ') {
					System.out.println("You have chose a Invalid Position!");
					System.out.println("Please choose correctly again!");
					continue;
				}
				arr[row][col] = player;
				if (isWinner()) {
					printBoard();
					System.out.println("Congratulations " + player + " you Won the game!!");
					break;
				}
				if (isFull()) {
					System.out.println("It's a Draw Match!");
					System.out.println("Bad Luck No One Won");
					break;
				}

				printBoard();

				player = (player == 'X') ? 'O' : 'X';
			}

			sc.nextLine();
			
			System.out.println("Want to play a New Game!(Y/N)");
		    ng=sc.nextLine().charAt(0);
		    
			
		}while(Character.toUpperCase(ng)=='Y');
	}

	private static boolean isFull() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isWinner() {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == player && arr[i][1] == player && arr[i][2] == player) {
				return true;
			}

		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[0][i] == player && arr[1][i] == player && arr[2][i] == player) {
				return true;
			}

		}
		if (arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) {
			return true;
		}
		if (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player) {
			return true;
		}
		return false;
	}

	static void printBoard() {
		System.out.println("+-----------+");

		for (int i = 0; i < arr.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < arr[i].length; j++) {

				System.out.print(arr[i][j] + " | ");

			}
			System.out.println();
			System.out.println("+-----------+");

		}
	}

}
