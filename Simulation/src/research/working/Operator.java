package research.working;

public class Operator {
	public static final int OR = 0, ADD = 1, SUB = 2, MULTIPLY = 3, DIVIDE = 4, GREATER = 5, LESSER = 6, EQUAL = 7;

	public static double doOperation(int operator, Value val1, Value val2) {
		switch (operator) {
		case ADD:
			return val1.getDouble() + val2.getDouble();
		case SUB:
			return val1.getDouble() - val2.getDouble();
		case DIVIDE:
			return val1.getDouble() / val2.getDouble();
		case MULTIPLY:
			return val1.getDouble() * val2.getDouble();
		case GREATER:
			if (val1.getDouble() > val2.getDouble())
				return 1;
			return -1;
		case LESSER:
			if (val1.getDouble() < val2.getDouble())
				return 1;
			return -1;
		case EQUAL:
			if (val1.getDouble() == val2.getDouble())
				return 1;
			return -1;
		case OR:
			if (val1.getBoolean() || val2.getBoolean())
				return 1;
			return -1;
		}
		return 0;
	}

}
