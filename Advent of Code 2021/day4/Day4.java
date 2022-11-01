package day4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Day4 {

	static boolean[][][] bingoNumbers;
	static int[][][] array;
	static String[] guesses;
	static int numberOfGrids;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Imput guesses!");
		guesses = scanner.nextLine().split(",");

		List<String> list = new LinkedList<>();

		while (scanner.hasNext()) {
			String line = scanner.nextLine();

			if (line.equals(""))
				continue;
			else if (line.equalsIgnoreCase("OVER"))
				break;

			list.add(line);
		}

		// forming and filling an array with grid numbers
		numberOfGrids = list.size() / 5;
		array = new int[numberOfGrids][5][5];
		bingoNumbers = new boolean[numberOfGrids][5][5];

		// Parsing grids
		int counter = 0;
		for (int i = 0; i < numberOfGrids; i++) {
			for (int j = 0; j < 5; j++) {
				String[] numbers = list.get(counter).split("\\s+");

				int k = 0;
				for (String num : numbers) {
					if (!num.equals("")) {
						array[i][j][k] = Integer.parseInt(num);
						k++;
					}
				}

				counter++;
			}
		}

		// part1();
		part2();

	}

	public static void part1() {
		for (String bingo : guesses) {
			int guess = Integer.parseInt(bingo);
			for (int i = 0; i < numberOfGrids; i++) {
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						if (array[i][j][k] == guess) {
							bingoNumbers[i][j][k] = true;
							if (checkIfBingo(i)) {
								System.out.println("Final score is " + getFinalScore(i, guess));
								System.exit(0);

							}
						}
					}
				}

			}

		}
	}

	public static void part2() {
		int numberOfBingos = 0;
		boolean[] alreadyAppearedGrid = new boolean[numberOfGrids];

		for (String bingo : guesses) {
			int guess = Integer.parseInt(bingo);
			for (int i = 0; i < numberOfGrids; i++) {
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						if (array[i][j][k] == guess) {
							bingoNumbers[i][j][k] = true;
							if (checkIfBingo(i) && !alreadyAppearedGrid[i]) {
								alreadyAppearedGrid[i] = true;
								numberOfBingos++;
								if (numberOfBingos == numberOfGrids) {
									System.out.println("Final score is " + getFinalScore(i, guess));
								}
							}
						}
					}
				}

			}

		}
	}

	public static boolean checkIfBingo(int gridNumber) {
		// checking rows
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!bingoNumbers[gridNumber][i][j])
					break;
				if (j == 4)
					return true;
			}
		}

		// checking columns
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!bingoNumbers[gridNumber][j][i])
					break;
				if (j == 4)
					return true;
			}
		}

		return false;
	}

	public static int getFinalScore(int gridNumber, int multiplier) {
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!bingoNumbers[gridNumber][i][j]) {
					sum += array[gridNumber][i][j];
				}
			}
		}

		return sum * multiplier;
	}
}
