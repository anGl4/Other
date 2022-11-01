package day8;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

public class Day8 {
	static Scanner scanner;

	public static void main(String[] args) throws FileNotFoundException {
		Path inputPath = Path.of("src/day8/input");
		scanner = new Scanner(inputPath.toFile());

		part1();

	}

	public static void part1() {
		int counter = 0;
		while (scanner.hasNext()) {
			String[] twoParts = scanner.nextLine().split(" \\| ");
			for (String segment : twoParts[1].split(" ")) {
				if (segment.length() == 2 || segment.length() == 4 || segment.length() == 3 || segment.length() == 7) {
					counter++;
				}
			}

		}

		System.out.println("Digits 1, 4, 7, or 8 appear " + counter + " times.");
	}

}
