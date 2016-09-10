package tests;

import java.util.Random;

import geometry.GeometryUtilities;
import geometry.Line;

public class AdditionTest {

	public static void main(String[] args) {
		double in0 = 30, in1 = 10, in2 = 5;
		double out = in0 + in1 * in2;
		double out0 = 0;
		double var1167517463 = 0;
		double var1077122222;
		if (var1167517463 < in2)
			var1077122222 = 1;
		else
			var1077122222 = -1;

		var1077122222 = in1 - in0;
		double var79854252 = in0 * in2;
		if (var79854252 > 0) {
			if (out0 < in0)
				out0 = 1;
			else
				out0 = -1;
		}
		out0 = var79854252 / var1077122222;
		if (var1077122222 < 0)
			var79854252 = in2 * out0;

		if (var1077122222 > var1167517463)
			var1167517463 = 1;
		else
			var1167517463 = -1;

		out0 = var79854252 - in1;

		if (in0 == in0)
			var1077122222 = 1;
		else
			var1077122222 = -1;

		if (var1167517463 < in0)
			var1167517463 = 1;
		else
			var1167517463 = -1;

		var1167517463 = in1 * out0;
		var1077122222 = var1167517463 / var1077122222;

		if (in1 < in0)
			var1077122222 = 1;
		else
			var1077122222 = -1;

		out0 = var1167517463 - in1;
		var1077122222 = out0 * out0;
		out0 = var1077122222 * var1167517463;
		System.out.println(out0);
		System.out.println(out);
	}

}
