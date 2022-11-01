package day1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

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

		for (int i = 0; i < depthMeasurements.size() - 1; i++) {
			if (depthMeasurements.get(i) < depthMeasurements.get(i + 1))
				counter++;
		}

		System.out.println(counter + " measurements are larger than the previous measurement.");

	}
}
