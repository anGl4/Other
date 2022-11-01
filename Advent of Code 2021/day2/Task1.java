package day2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {

		System.out.println("Type in the commands! Enter OVER if finished!");

		List<String> commands = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);

		int forward = 0;
		int depth = 0;

		while (scanner.hasNext()) {
			String line = scanner.nextLine();

			if (line.equalsIgnoreCase("over"))
				break;

			int parsedValue = Integer.parseInt(line.substring(line.indexOf(' ') + 1));

			if (line.contains("forward "))
				forward += parsedValue;

			if (line.contains("down "))
				depth += parsedValue;

			if (line.contains("up "))
				depth -= parsedValue;

		}

		System.out.println("\nWe get " + depth * forward + " by multiplying final horizontal position by final depth");

	}

}
