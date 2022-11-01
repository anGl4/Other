package day3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {
		System.out.println("Type in binary numbers! (Type OVER if finished)");

		Scanner scanner = new Scanner(System.in);
		List<String> binaryNumbers = new LinkedList<>();

		// Fill the list
		while (scanner.hasNext()) {
			String next = scanner.nextLine();

			if (next.equalsIgnoreCase("OVER"))
				break;

			binaryNumbers.add(next);
		}

		System.out.println("Life support rating of submarine equals to "
				+ getOxygenRating(binaryNumbers) * getCO2Rating(binaryNumbers));

	}

	public static int getDecimalNumber(String binary) {
		int decimal = 0;

		String[] binaryDigits = binary.split("");

		int multiplicator = 1;
		for (int i = binaryDigits.length - 1; i >= 0; i--) {
			decimal += multiplicator * Integer.parseInt(binaryDigits[i]);
			multiplicator *= 2;
		}

		return decimal;
	}

	public static int getOxygenRating(List<String> list) {
		int oxygenRating = 0, position = 0;

		List<String> binaryNumbers = new LinkedList<>();
		binaryNumbers.addAll(list);

		boolean found = false;

		while (!found) {
			int countZero = 0, countOne = 0;
			for (String num : binaryNumbers) {
				if (num.charAt(position) == '0')
					countZero++;
				else
					countOne++;
			}

			for (String num : list) {
				if (!binaryNumbers.contains(num))
					continue;
				if (countOne >= countZero) {
					if (num.charAt(position) == '0') {
						binaryNumbers.remove(num);
					}
				} else {
					if (num.charAt(position) == '1') {
						binaryNumbers.remove(num);
					}
				}
			}

			position++;

			if (binaryNumbers.size() == 1) {
				oxygenRating = getDecimalNumber(binaryNumbers.get(0));
				found = true;
			}
		}

		return oxygenRating;
	}

	public static int getCO2Rating(List<String> list) {
		int CO2Rating = 0, position = 0;

		List<String> binaryNumbers = new LinkedList<>();
		binaryNumbers.addAll(list);

		boolean found = false;

		while (!found) {
			int countZero = 0, countOne = 0;
			for (String num : binaryNumbers) {
				if (num.charAt(position) == '0')
					countZero++;
				else
					countOne++;
			}

			for (String num : list) {
				if (!binaryNumbers.contains(num))
					continue;
				if (countZero > countOne) {
					if (num.charAt(position) == '0') {
						binaryNumbers.remove(num);
					}
				} else {
					if (num.charAt(position) == '1') {
						binaryNumbers.remove(num);
					}
				}
			}

			position++;

			if (binaryNumbers.size() == 1) {
				CO2Rating = getDecimalNumber(binaryNumbers.get(0));
				found = true;
			}
		}

		return CO2Rating;
	}

}
