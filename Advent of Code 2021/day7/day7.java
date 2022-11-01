package day7;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class day7 {

	static int maxPosition = 0;

	public static void main(String[] args) throws FileNotFoundException {
		Path inputPath = Path.of("src\\day7\\input");
		Scanner scanner = new Scanner(inputPath.toFile());

		// Parsing and filling list, finding minimum and maximum positions
		String[] inputPositions = scanner.nextLine().split(",");
		List<Integer> positions = new LinkedList<>();
		for (String input : inputPositions) {
			int nextPosition = Integer.parseInt(input);
			positions.add(nextPosition);

			if (nextPosition > maxPosition)
				maxPosition = nextPosition;
		}

		part1(positions);
		// part2(positions);

	}

	public static void part1(List<Integer> positions) {
		int size = positions.size(), minFuelUsed = Integer.MAX_VALUE;

		for (int i = 0; i < maxPosition; i++) {
			int fuelUsed = 0;
			for (int j = 0; j < size; j++) {
				fuelUsed += Math.abs(positions.get(j) - i);
			}
			if (fuelUsed < minFuelUsed) {
				minFuelUsed = fuelUsed;
			}
		}

		System.out.println("To get to the optimal position, " + minFuelUsed + " fuel is used.");
	}

	public static void part2(List<Integer> positions) {
		int size = positions.size(), minFuelUsed = Integer.MAX_VALUE;

		int fuelUsed;
		for (int i = 0; i < maxPosition; i++) {
			fuelUsed = 0;
			for (int j = 0; j < size; j++) {
				int distance = Math.abs(positions.get(j) - i);
				for (int k = 1; k <= distance; k++) {
					fuelUsed += k;
				}
			}
			if (fuelUsed < minFuelUsed) {
				minFuelUsed = fuelUsed;
			}
		}

		System.out.println("To get to the optimal position, " + minFuelUsed + " fuel is used.");
	}

}
