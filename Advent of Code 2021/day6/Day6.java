package day6;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day6 {
	static int DAYS_TRACKED = 256;

	public static void main(String[] args) throws FileNotFoundException {
		Path inputPath = Path.of("src\\day6\\input");
		Scanner scanner = new Scanner(inputPath.toFile());

		// File has only one line
		String[] inputNumbers = scanner.nextLine().split(",");

		// Parsing numbers and filling map
		Map<Integer, Long> fishInfoMap = new HashMap<>();

		for (int i = 0; i <= 8; i++) {
			fishInfoMap.put(i, (long) 0);
		}
		for (String input : inputNumbers) {
			int num = Integer.parseInt(input);
			fishInfoMap.put(num, fishInfoMap.get(num) + 1);
		}

		int daysCounter = 0;
		while (daysCounter < DAYS_TRACKED) {

			long noOfFishToAdd = fishInfoMap.get(0);

			for (int i = 0; i < 8; i++) {
				fishInfoMap.replace(i, fishInfoMap.get(i + 1));
			}
			fishInfoMap.replace(6, fishInfoMap.get(6) + noOfFishToAdd);
			fishInfoMap.replace(8, noOfFishToAdd);

			daysCounter++;
		}

		long sum = 0;
		for (long val : fishInfoMap.values()) {
			sum += val;
		}

		System.out.println("After " + DAYS_TRACKED + " days, there are " + sum + " lanternfish.");
	}

}
