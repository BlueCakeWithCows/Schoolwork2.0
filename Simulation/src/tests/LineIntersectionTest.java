package tests;

import java.util.Random;

import geometry.GeometryUtilities;
import geometry.Line;

public class LineIntersectionTest {

	public static void main(String[] args) {
		generateTestSuite();
		// Test("Identical Line Inverse", new Line(0, 0, 500, 500), new
		// Line(500, 500, 0, 0));
		// Test("Identical Line", new Line(500, 500, 500, 500), new Line(500,
		// 500, 0, 0));
		// Test("Perpendicular Line", new Line(0, 500, 0, 0), new Line(-200,
		// 400, 200, 200));
		// Test("Perpendicular Line", new Line(0, 500, 0, 0), new Line(-200,
		// 400, 200, 200));
		// }
	}

	public static void Test(String desc, Line one, Line two) {
		System.out.println("[" + desc + "] " + "(" + one.start + one.end + ")" + "(" + two.start + two.end + "): "
				+ one.intersects(two));
	}

	public static void generateTestSuite() {
		Random r = new Random(555);
		for (int i = 0; i < 500; i++) {
			double scale = r.nextDouble() * 100;
			double x = scale * r.nextDouble();
			double y = scale * r.nextDouble();
			double x2 = scale * r.nextDouble();
			double y2 = scale * r.nextDouble();
			double xB = scale * r.nextDouble();
			double yB = scale * r.nextDouble();
			double x2B = scale * r.nextDouble();
			double y2B = scale * r.nextDouble();
			boolean intersects = GeometryUtilities.intersects(x, y, x2, y2, xB, yB, x2B, y2B);
			String out = x + "," + y + "," + x2 + "," + y2 + "," + xB + "," + yB + "," + x2B + "," + y2B + ":"
					+ intersects;
			System.out.println(out);
		}
	}
}
