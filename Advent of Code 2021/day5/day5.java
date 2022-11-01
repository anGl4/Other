package day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class day5 {

	static List<String> inputLines;
	static Map<Point, Integer> pointCounterMap;

	public static void main(String[] args) throws IOException {
		Path inputPath = Path.of("src\\day5\\input");
		inputLines = Files.readAllLines(inputPath);
		pointCounterMap = new HashMap<>();

		for (String line : inputLines) {
			// Parsing lines
			int x1 = Integer.parseInt(line.substring(0, line.indexOf(',')));
			int y1 = Integer.parseInt(line.substring(line.indexOf(',') + 1, line.indexOf(' ')));
			int x2 = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1, line.lastIndexOf(',')));
			int y2 = Integer.parseInt(line.substring(line.lastIndexOf(',') + 1));

			// checking vertical lines
			if (x1 == x2) {
				if (y1 <= y2) {
					for (int i = y1; i <= y2; i++) {
						addPointToMap(x1, i);
					}
				} else if (y2 < y1) {
					for (int i = y2; i <= y1; i++) {
						addPointToMap(x1, i);
					}
				}
			}

			// checking horizontal lines
			else if (y1 == y2) {
				if (x1 <= x2) {
					for (int i = x1; i <= x2; i++) {
						addPointToMap(i, y1);
					}
				} else if (x2 < x1) {
					for (int i = x2; i <= x1; i++) {
						addPointToMap(i, y1);
					}
				}
			} else {
				// Part2: checking diagonal lines (lines 55-81)

				int slope = (y2 - y1) / (x2 - x1);
				if (slope != 1 && slope != -1) {
					continue;
				}

				if (x1 < x2 && y1 < y2) {
					int j = 0;
					for (int i = x1; i <= x2; i++) {
						addPointToMap(i, y1 + j++);
					}
				} else if (x1 > x2 && y1 > y2) {
					int j = 0;
					for (int i = x1; i >= x2; i--) {
						addPointToMap(i, y1 - j++);
					}
				} else if (x1 > x2 && y1 < y2) {
					int j = 0;
					for (int i = x1; i >= x2; i--) {
						addPointToMap(i, (y1 + j++));
					}
				} else if (x1 < x2 && y1 > y2) {
					int j = 0;
					for (int i = x1; i <= x2; i++) {
						addPointToMap(i, y1 - j++);
					}
				}
			}
		}

		// Counting points where at least two lines overlap
		int counter = 0;
		for (Point p : pointCounterMap.keySet()) {
			if (pointCounterMap.get(p) >= 2) {
				++counter;
			}
		}
		System.out.println("At " + counter + " points at least two lines overlap.");

	}

	public static void addPointToMap(int x, int y) {
		Point point = new Point(x, y);
		if (!pointCounterMap.containsKey(point)) {
			pointCounterMap.put(point, 0);
		}
		pointCounterMap.replace(point, pointCounterMap.get(point) + 1);
		// System.out.println("Added " + point.getX() + "," + point.getY() + ", count: "
		// + pointCounterMap.get(point));
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}

}
