package day2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {
		System.out.println("Type in the commands! Enter OVER if finished!");

		List<String> commands = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);

		int horizontal = 0, aim = 0, depth = 0;

		while (scanner.hasNext()) {
			String line = scanner.nextLine();

			if (line.equalsIgnoreCase("over"))
				break;

			int parsedValue = Integer.parseInt(line.substring(line.indexOf(' ') + 1));

			if (line.contains("forward ")) {
				horizontal += parsedValue;
				depth += aim * parsedValue;
			}

			if (line.contains("down "))
				aim += parsedValue;

			if (line.contains("up "))
				aim -= parsedValue;
		}

		System.out
				.println("\nWe get " + depth * horizontal + " by multiplying final horizontal position by final depth");
	}
}
