package research;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneticProgramming {
	public List<Suite> suites;
	public static GeneticProgramming main;

	public static void main(String[] args) {
		main = new GeneticProgramming();
	}

	public GeneticProgramming() {
		suites = new ArrayList<Suite>();
		loadFile();
	}

	public void loadFile() {
		File file = new File("GeneticTestSuite/LineCollision.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				suites.add(new Suite(line));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public class Suite {
		double aX1;
		double aY1;
		double aX2;
		double aY2;
		double bX1;
		double bY1;
		double bX2;
		double bY2;
		boolean result;

		public Suite(String line) {
			String[] splitCOlon = line.split(":");
			result = Boolean.valueOf(splitCOlon[1]);
			String[] s = splitCOlon[0].split(",");
			aX1 = p(s[0]);
			aY1 = p(s[1]);
			aX2 = p(s[2]);
			aY2 = p(s[3]);
			bX1 = p(s[4]);
			bY1 = p(s[5]);
			bX2 = p(s[6]);
			bY2 = p(s[7]);
		}

		private double p(String s) {
			return Double.valueOf(s);
		}

	}

}
