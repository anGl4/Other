package day1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {
		System.out.println("Type in the measurements! (Hit enter two times when over)");

		List<Integer> depthMeasurements = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			int depth;

			try {
				depth = Integer.parseInt(line);
				depthMeasurements.add(depth);
			} catch (Exception e) {
				break;
			}
		}

		int counter = 0;

		for (int i = 0; i < depthMeasurements.size() - 3; i++) {
			int firstSum = depthMeasurements.get(i) + depthMeasurements.get(i + 1) + depthMeasurements.get(i + 2);
			int secondSum = depthMeasurements.get(i + 1) + depthMeasurements.get(i + 2) + depthMeasurements.get(i + 3);

			if (firstSum < secondSum)
				counter++;
		}

		System.out.println(counter + " sums are larger than the previous sum.");
	}
}
