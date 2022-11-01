package day9;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Day9 {

	static int lineLength;
	static List<Integer[]> list;

	public static void main(String[] args) throws FileNotFoundException {
		Path inputPath = Path.of("src/day9/input");
		Scanner scanner = new Scanner(inputPath.toFile());

		// Parsing input file
		list = new LinkedList<>();
		while (scanner.hasNext()) {
			String line = scanner.nextLine();

			Integer[] values = new Integer[line.length()];
			int i = 0;
			for (String val : line.split("")) {
				values[i++] = Integer.parseInt(val);
			}

			list.add(values);
		}
		lineLength = list.get(0).length;

		part1();
	}

	public static void part1() {
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < lineLength; j++) {
				// Standard case
				if (i != 0 && i != list.size() - 1 && j != 0 && j != lineLength - 1
						&& list.get(i)[j] < list.get(i)[j + 1] && list.get(i)[j] < list.get(i)[j - 1]
						&& list.get(i)[j] < list.get(i - 1)[j] && list.get(i)[j] < list.get(i + 1)[j]) {
					sum += list.get(i)[j] + 1;
				}
				// First line
				if (i == 0 && j != 0 && j != lineLength - 1 && list.get(i)[j] < list.get(i)[j + 1]
						&& list.get(i)[j] < list.get(i)[j - 1] && list.get(i)[j] < list.get(i + 1)[j]) {
					sum += list.get(i)[j] + 1;
				}
				// Last line
				if (i == list.size() - 1 && j != 0 && j != lineLength - 1 && list.get(i)[j] < list.get(i)[j + 1]
						&& list.get(i)[j] < list.get(i)[j - 1] && list.get(i)[j] < list.get(i - 1)[j]) {
					sum += list.get(i)[j] + 1;
				}
				// Left side
				if (i != 0 && i != list.size() - 1 && j == 0 && list.get(i)[j] < list.get(i)[j + 1]
						&& list.get(i)[j] < list.get(i - 1)[j] && list.get(i)[j] < list.get(i + 1)[j]) {
					sum += list.get(i)[j] + 1;
				}
				// Right side
				if (i != 0 && i != list.size() - 1 && j == lineLength - 1 && list.get(i)[j] < list.get(i)[j - 1]
						&& list.get(i)[j] < list.get(i - 1)[j] && list.get(i)[j] < list.get(i + 1)[j]) {
					sum += list.get(i)[j] + 1;
				}
				// Top left edge
				if (i == 0 && j == 0 && list.get(0)[0] < list.get(0)[1] && list.get(0)[0] < list.get(1)[0]) {
					sum += list.get(0)[0] + 1;
				}
				// Top right edge
				if (i == 0 && j == lineLength - 1 && list.get(0)[lineLength - 1] < list.get(0)[lineLength - 2]
						&& list.get(0)[lineLength - 1] < list.get(1)[lineLength - 1]) {
					sum += list.get(0)[lineLength - 1] + 1;
				}
				// Bottom left edge
				int lastIndex = list.size() - 1;
				if (i == lastIndex && j == 0 && list.get(lastIndex)[0] < list.get(lastIndex)[1]
						&& list.get(lastIndex)[0] < list.get(lastIndex - 1)[0]) {
					sum += list.get(lastIndex)[0] + 1;
				}
				// Bottom right edge
				if (i == lastIndex && j == lineLength - 1
						&& list.get(lastIndex)[lineLength - 1] < list.get(lastIndex)[lineLength - 2]
						&& list.get(lastIndex)[lineLength - 1] < list.get(lastIndex - 1)[lineLength - 1]) {
					sum += list.get(lastIndex)[lineLength - 1] + 1;
				}
			}
		}
		System.out.println(sum);
	}
}
