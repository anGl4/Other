package day3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

	static int binaryNumLength = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Type in binary numbers! (Type OVER if finished)");

		List<String> binaryNumbers = new LinkedList<>();

		// Fill the list
		while (scanner.hasNext()) {
			String next = scanner.nextLine();

			if (next.equalsIgnoreCase("OVER"))
				break;

			binaryNumbers.add(next);
		}

		// Setting the length of binary numbers so it isn't hard coded
		binaryNumLength = binaryNumbers.get(0).length();

		String gammaRate = calculateGammaRate(binaryNumbers);
		String epsilonRate = getComplementBinaryNumber(gammaRate);
		int powerConsumption = getDecimalNumber(gammaRate) * getDecimalNumber(epsilonRate);

		System.out.println("Power consumption equals to " + powerConsumption);

	}

	public static String calculateGammaRate(List<String> list) {
		String gammaRate = "";

		for (int i = 0; i < binaryNumLength; i++) {
			int countZero = 0, countOne = 0;

			for (String binary : list) {
				if (binary.charAt(i) == '0')
					countZero++;
				else
					countOne++;
			}

			if (countZero < countOne)
				gammaRate += "1";
			else
				gammaRate += "0";
		}

		return gammaRate;
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

	public static String getComplementBinaryNumber(String binary) {
		String[] binaryDigits = binary.split("");
		String complement = "";

		for (int i = 0; i < binaryDigits.length; i++) {
			if (binaryDigits[i].equals("0"))
				complement += "1";
			else
				complement += "0";
		}

		return complement;
	}

}
