package geometry;

public class GeometryUtilities {

	public static boolean getLineInteresection(Line lA, Line lB) {
		double s1_x, s1_y, s2_x, s2_y;
		s1_x = lA.end.x - lA.start.x;
		s1_y = lA.end.y - lA.start.y;
		s2_x = lB.end.x - lB.start.x;
		s2_y = lB.end.y - lB.start.y;

		double s, t;
		s = (-s1_y * (lA.start.x - lB.start.x) + s1_x * (lA.start.y - lB.start.y)) / (-s2_x * s1_y + s1_x * s2_y);
		t = (s2_x * (lA.start.y - lB.start.y) - s2_y * (lA.start.x - lB.start.x)) / (-s2_x * s1_y + s1_x * s2_y);

		if (s >= 0 && s <= 1 && t >= 0 && t <= 1) {
			return true;
		}
		return false;
	}

	public static Point getLineInteresectionPoint(Line lA, Line lB) {
		double s1_x, s1_y, s2_x, s2_y;
		s1_x = lA.end.x - lA.start.x;
		s1_y = lA.end.y - lA.start.y;
		s2_x = lB.end.x - lB.start.x;
		s2_y = lB.end.y - lB.start.y;

		double s, t;
		s = (-s1_y * (lA.start.x - lB.start.x) + s1_x * (lA.start.y - lB.start.y)) / (-s2_x * s1_y + s1_x * s2_y);
		t = (s2_x * (lA.start.y - lB.start.y) - s2_y * (lA.start.x - lB.start.x)) / (-s2_x * s1_y + s1_x * s2_y);

		if (s >= 0 && s <= 1 && t >= 0 && t <= 1) {
			// Collision detected
			double inX = lA.start.x + (t * s1_x);
			double inY = lA.start.y + (t * s1_y);
			Point iP = new Point(inX, inY);
			return iP;
		}

		return null; // No collision
	}

	public static boolean intersects(double aX1, double aY1, double aX2, double aY2, double bX1, double bY1, double bX2,
			double bY2) {
		double s1_x, s1_y, s2_x, s2_y;
		s1_x = aX2 - aX1;
		s1_y = aY2 - aY1;
		s2_x = bX2 - bX1;
		s2_y = bY2 - bY1;

		double s, t;
		s = (-s1_y * (aX1 - bX1) + s1_x * (aY1 - bY1)) / (-s2_x * s1_y + s1_x * s2_y);
		t = (s2_x * (aY1 - bY1) - s2_y * (aX1 - bX1)) / (-s2_x * s1_y + s1_x * s2_y);

		if (s >= 0 && s <= 1 && t >= 0 && t <= 1) {
			// Collision detected
			double inX = aX1 + (t * s1_x);
			double inY = aY1 + (t * s1_y);
			Point iP = new Point(inX, inY);
			return true;
		}
		return false; // No collision
	}
}
