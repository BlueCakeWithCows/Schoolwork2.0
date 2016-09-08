package tests;

import geometry.Line;

public class LineIntersectionTest {

	public static void main(String[] args) {

		Test("Identical Line Inverse", new Line(0, 0, 500, 500), new Line(500, 500, 0, 0));
		Test("Identical Line", new Line(500, 500, 500, 500), new Line(500, 500, 0, 0));
		Test("Perpendicular Line", new Line(0, 500, 0, 0), new Line(-200, 400, 200, 200));
		Test("Perpendicular Line", new Line(0, 500, 0, 0), new Line(-200, 400, 200, 200));
	}

	public static void Test(String desc, Line one, Line two) {
		System.out.println("[" + desc + "] " + "(" + one.start + one.end + ")" + "(" + two.start + two.end + "): "
				+ one.intersects(two));
	}
}
