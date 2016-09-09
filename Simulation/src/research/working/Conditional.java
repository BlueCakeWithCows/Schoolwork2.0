package research.working;

public class Conditional extends Point {
	public String variable;
	public boolean NOT;
	public Tree subTree;


	public Conditional(String variable, boolean NOT) {
		this.variable = variable;
		this.NOT = NOT;
		subTree = new Tree();
	}

	private boolean test(Value value) {
		boolean b = value.getBoolean();
		if (b != NOT)
			return true;
		return false;
	}

	@Override
	public void compute(Tree tree) {
		if (test(tree.getValue(variable)))
			run(tree);
	}

	private void run(Tree tree) {
		subTree.simulate(tree);
	}

	@Override
	public String toString() {
		String ret = "IF " + variable + "IS " + !NOT + " THEN";
		String[] split = subTree.toString().split(System.lineSeparator());
		for (String stuff : split) {
			ret += System.lineSeparator() + "\t" + stuff;
		}
		return ret;
	}
}
