package research;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Scanner;

import research.working.Conditional;
import research.working.Mutator;
import research.working.Node;
import research.working.Operator;
import research.working.Point;
import research.working.Tree;

public class Alg {
	private SecureRandom random;
	private Manager manager;
	private String url = "Cases/Test";
	public static Alg main;

	public Alg() throws IOException {
		double prob = 1d/0d;
		CaseReader reader = new CaseReader(new File(url));
		random = new SecureRandom();
		random.setSeed(54555);
		manager = new Manager(random, .1d, reader.getTestCases(), 3, 1, 1000,.1);

	}

	public void start() {
		manager.generatePopulation(3, 10);
		manager.scorePopulation();
		Scanner scanner = new Scanner(System.in);
		int input;
		while (true) {
			System.out.println("Show Top?");
			input = Integer.valueOf(scanner.nextLine());
			List<Tree> trees = manager.getBest(input);
			for (Tree tree : trees) {
				System.out.println(tree + System.lineSeparator() + System.lineSeparator());
			}
			System.out.println("Do how many generations?");
			input = Integer.valueOf(scanner.nextLine());
			for (int i = 0; i < input; i++) {
				manager.doGeneration();
			}
			

		}
	}

	public static void main(String[] args) throws IOException {
		main = new Alg();
		main.start();

	}
}
