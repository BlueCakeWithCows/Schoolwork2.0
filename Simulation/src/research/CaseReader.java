package research;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import research.working.TestCase;

public class CaseReader {
	private File file;

	public CaseReader(File f) {
		this.file = f;
	}

	private Double[] getDouble(String[] sss) {
		Double[] dubs = new Double[sss.length];
		for (int i = 0; i < sss.length; i++) {
			if (sss[i].equalsIgnoreCase("null"))
				dubs[i] = null;
			else
				dubs[i] = Double.valueOf(sss[i]);
		}
		return dubs;
	}

	private double[] getdouble(String[] sss) {
		double[] dubs = new double[sss.length];
		for (int i = 0; i < sss.length; i++) {
			dubs[i] = Double.valueOf(sss[i]);
		}
		return dubs;
	}

	public List<TestCase> getTestCases() throws IOException {

		List<TestCase> cases = new ArrayList<TestCase>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				TestCase cas = new TestCase();
				String[] splitColon = line.split(":");
				cas.out = getDouble(splitColon[1].split(","));
				cas.input = getdouble(splitColon[0].split(","));
				cases.add(cas);
			}
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
			}
		}
		return cases;
	}
}
