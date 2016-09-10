package tests;

import java.util.Random;

import geometry.GeometryUtilities;
import geometry.Line;

public class LineIntersectionTest {

	public static void main(String[] args) {
		generateTestSuite();

	}

	public static void Test(String desc, Line one, Line two) {
		System.out.println("[" + desc + "] " + "(" + one.start + one.end + ")" + "(" + two.start + two.end + "): "
				+ one.intersects(two));
	}

	public static void generateTestSuite() {
		Random rand = new Random(2222);
		for (int i = 0; i < 100; i++) {
			StringBuilder sb = new StringBuilder();
			double[] arg1 = new double[3];
			for (int i2 = 0; i2 < arg1.length; i2++) {
				arg1[i2] = rand.nextDouble() * 30;
				sb.append("," + arg1[i2]);

			}
			sb.deleteCharAt(0);
			double out = arg1[0] + arg1[1] * arg1[2];
			sb.append(":");
			sb.append(out);
			System.out.println(sb.toString());
		}
	}
}
