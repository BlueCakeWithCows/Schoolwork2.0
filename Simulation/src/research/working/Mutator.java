package research.working;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Mutator {
	SecureRandom random;

	public Mutator(SecureRandom random) {
		this.random = random;
	}

	private Set<String> vars;
	private Set<String> values;

	public void mutateTree(Tree tree) {
		List<Point> points = tree.getPoints();
		vars = tree.getDefaultVariables();
		values = tree.getDefaultNames();
		List<Integer> toAdd = new ArrayList();
		int i = 0;
		for (Point p : points) {
			if (p instanceof Node) {
				Node n = (Node) p;
				if (m())
					n.var = getRandomVariable();
				if (m())
					n.val1 = getRandomValue();
				if (m())
					n.val2 = getRandomValue();
				if (m())
					n.operator = getRandomOperator();
				vars.add(n.var);
			}
			if (p instanceof Conditional) {
				Conditional n = (Conditional) p;
				if (m())
					n.variable = getRandomVariable();
				if (m())
					n.NOT = !n.NOT;
				mutateTree(n.subTree);
			}
			if (m())
				toAdd.add(i);
			i++;
		}
		
		

	}

	private int getRandomOperator() {
		// TODO Auto-generated method stub
		return 0;
	}

	private String getRandomVariable() {

	}

	private String getRandomValue() {
		if (values.containsKey(val2))
			return new Value(values.get(val2));
		else
			return new Value(variables.get(val2));
	}

	public boolean m() {
		return false;
	}
}
