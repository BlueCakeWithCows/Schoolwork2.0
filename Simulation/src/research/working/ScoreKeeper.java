package research.working;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScoreKeeper {

	public List<TestCase> cases;

	public ScoreKeeper(List<TestCase> cases) {
		this.cases = cases;
	}

	public List<Tree> score(List<Tree> children) {
		List<ScoredTree> sTree = new ArrayList<ScoredTree>();
		for (Tree tree : children) {
			sTree.add(new ScoredTree(tree));
		}
		for (TestCase c : cases) {

			double[] highest = new double[c.out.length], lowest = new double[c.out.length];
			for (ScoredTree tree : sTree) {
				Double[] results = tree.tree.execute(c.input);
				tree.tempScores = new double[c.out.length];

				for (int i = 0; i < c.out.length; i++) {
					tree.setNormalized(true);
					if (c.out[i] == null && results[i] == null) {
						tree.tempScores[i] = 1000;
					} else if (c.out[i] == null && results[i] != null) {
						tree.tempScores[i] = 0;
					} else if (results[i] == null) {
						tree.tempScores[i] = 0;
					} else if (Double.isInfinite(results[i])) {
						tree.tempScores[i] = 0;
					} else {
						tree.setNormalized(false);
						tree.tempScores[i] = Math.abs(c.out[i] - results[i]);
						if (tree.tempScores[i] > highest[i])
							highest[i] = tree.tempScores[i];
						if (tree.tempScores[i] < lowest[i]) {
							lowest[i] = tree.tempScores[i];
						}
						
					}
					
				}
			}
			for (ScoredTree tree : sTree) {
				if (!tree.normaled)
					for (int i = 0; i < c.out.length; i++) {
						if (lowest[i] + highest[i] == 0)
							tree.tempScores[i] = 0;
						else{
							double bottom = 1 - tree.tempScores[i]/(lowest[i]+highest[i])/1000;
							System.out.println(bottom);
							tree.tempScores[i] = bottom;
						}
						tree.runningScore += tree.tempScores[i] / tree.tempScores.length;
					}
			}
		}

		try {
			Collections.sort(sTree, new Comparator<ScoredTree>() {
				@Override
				public int compare(ScoredTree o2, ScoredTree o1) {
					return Double.compare(o1.runningScore, o2.runningScore);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Tree> newList = new ArrayList<Tree>();
		for (ScoredTree tweat : sTree) {
			tweat.tree.score = tweat.runningScore;
			newList.add(tweat.tree);
		}
		return newList;
	}

	private class ScoredTree {
		public ScoredTree(Tree tree) {
			this.tree = tree;
		}

		public boolean normaled;

		public void setNormalized(boolean b) {
			this.normaled = b;
		}

		Tree tree;
		double[] tempScores;
		double runningScore = 0;
	}
}
