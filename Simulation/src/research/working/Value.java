package research.working;

public class Value {
	public String name;

	public double value;
	public boolean getBoolean() {
		if (value > 0)
			return true;
		return false;
	}

	public double getDouble() {
		return value;
	}
}
