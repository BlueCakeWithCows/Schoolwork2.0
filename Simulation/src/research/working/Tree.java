package research.working;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Tree {

	private static final int inp = 0;
	private ArrayList<Point> points;
	private HashMap<String, Double> variables;
	private HashMap<String, Double> values;
	private HashMap<String, Double> constants;
	int outputSize;
	int inputSize;
	public Double[] outputs;

	public Tree(int inp, int out) {
		this();
		outputSize = out;
		this.inputSize = inp;
		variables = new HashMap<String, Double>();
		values = new HashMap<String, Double>();
		constants = new HashMap<String, Double>();
	}

	public Tree() {
		points = new ArrayList<Point>();
	}

	public Double[] execute(double[] inputs) {
		values.clear();
		variables.clear();
		outputs = new Double[outputSize];
		
		for (int i = 0; i < inputs.length; i++)
			values.put(formatInput(i), inputs[i]);;
		
		for (int i = 0; i < outputs.length; i++)
			variables.put(formatOut(i), outputs[i]);

		values.putAll(constants);
		simulate(this);
		for (int i = 0; i < outputs.length; i++)
			outputs[i] = variables.get(formatOut(i));

		return outputs;
	}

	private String formatOut(int i) {
		return "out" + i;
	}

	public void simulate(Tree tree) {
		for (Point p : points) {
			p.compute(tree);
		}
	}

	public Set<String> getDefaultNames(){
		Set<String> list = new TreeSet<String>();
		list.addAll(constants.keySet());
		for (int i = 0; i < inp; i++)
			list.add(formatInput(i));
		return list;
	}
	
	public Set<String> getDefaultVariables(){
		Set<String> list = new TreeSet<String>();
		for (int i = 0; i < outputSize; i++)
			list.add(formatOut(i));
		return list;
	}
	
	public void addPoint(Point point) {
		this.addPoint(point, points.size());
	}

	public int getPointSize() {
		return points.size();
	}

	public void addPoint(Point point, int index) {
		points.add(index, point);
		if (point instanceof Conditional) {
			if (index + 1 != points.size()) {
				Point p = points.get(index + 1);
				points.remove(index + 1);
				((Conditional) point).subTree.addPoint(p);
			}
		}
	}

	public void setVariable(String var, Double doOperation) {
		variables.put(var, doOperation);
	}

	public Value getValue(String val2) {
		if (values.containsKey(val2))
			return new Value(values.get(val2));
		else
			return new Value(variables.get(val2));
	}

	public String formatInput(int i) {
		return "in" + i;
	}

	public ArrayList getPoints() {
		return this.points;
	}
}
