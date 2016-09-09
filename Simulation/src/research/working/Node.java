package research.working;

public class Node extends Point {
	public int operator;
	public String val1, val2;
	public String var;


	public Node( String var, int o, String v1, String v2) {
		this.operator = o;
		this.val1 = v1;
		this.val2 = v2;
		this.var = var;
	}
	@Override
	public void compute(Tree tree) {
		Value vl1 = tree.getValue(val1);
		Value vl2 = tree.getValue(val2);
		tree.setVariable(var, Operator.doOperation(operator, vl1, vl2));
	}
}
