package research;

import research.working.Conditional;
import research.working.Node;
import research.working.Operator;
import research.working.Point;
import research.working.Tree;

public class Alg {
	public static void main(String[] args) {
		Tree tree = new Tree(2, 1);
		tree.addPoint(new Node("out0", Operator.ADD, "in0", "in1"));
		Conditional c = new Conditional("in0", false);
		c.subTree.addPoint(new Node("out0", Operator.SET, "in0", "in1"));
		tree.addPoint(c);

		double[] test = { 3d, 2d };

		Double[] out = tree.execute(test);
		for (Double o : out) {
			System.out.println(o);
		}
	}
}
