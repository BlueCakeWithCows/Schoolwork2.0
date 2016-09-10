package research;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import research.working.MutationHelper;
import research.working.Mutator;
import research.working.ScoreKeeper;
import research.working.TestCase;
import research.working.Tree;

public class Manager {
	private SecureRandom random;
	private Mutator mutator;
	private ScoreKeeper scorer;
	private List<Tree> children;
	private int inputSpace, outputSpace;
	public int population;

	public Manager(SecureRandom random, double mutationChance, List<TestCase> cases, int inSize, int outSize,
			int population,double topPercent) {
		this.random = random;
		this.mutator = new Mutator(random, mutationChance);
		this.scorer = new ScoreKeeper(cases);
		children = new ArrayList<Tree>();
		inputSpace = inSize;
		outputSpace = outSize;
		this.population = population;
		this.topPercent = topPercent;
	}

	public List<Tree> getBest(int number) {
		return children.subList(0, number);

	}

	public Tree getBest() {
		return children.get(0);

	}

	boolean scored = false;

	public void doGeneration() {
		if (!scored) {
			scored = true;
			scorePopulation();
		}
		shavePopulationToTopAndMutate();
		scorePopulation();
	}

	public void scorePopulation() {
		scored = true;
		children = scorer.score(children);
	}
	double topPercent;
	public void shavePopulationToTopAndMutate() {	
		int lastIndex = (int) (children.size() * topPercent);
		children = children.subList(0, lastIndex);
		int i = 0;
		while (children.size() < population) {
			i = i % lastIndex;
			children.add(mutator.mutateTree(children.get(i)));
		}
	}

	public void generatePopulation(int minPoints, int maxPoints) {
		children.clear();
		for (int i = 0; i < population; i++) {
			children.add(generateTree(random.nextInt(maxPoints) + minPoints));
		}
	}

	private Tree generateTree(int size) {
		Tree tree = new Tree(inputSpace, outputSpace);
		MutationHelper helper = new MutationHelper(random, tree);
		for (int i = 0; i < size; i++) {
			int r = random.nextInt(tree.getPointSize() + 1);
			tree.addPoint(helper.getNewPoint(), r);
		}
		return tree;
	}
}
