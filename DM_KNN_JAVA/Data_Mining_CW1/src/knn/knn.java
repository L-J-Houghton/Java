package knn;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class knn {
	public static void main(String[] args) throws IOException {

		// reading training data
		String[][] trainingData = new String[11000][17]; // 17th column for
															// primary key
		BufferedReader in = new BufferedReader(new FileReader(
				"adult.train.5fold.csv"));
		int currentRow = 0;
		String line;
		boolean missFirstLine = true;

		while ((line = in.readLine()) != null) {
			if (missFirstLine) {
				missFirstLine = false;
			} else {
				String[] words = line.split(",");
				for (int curentColumn = 0; curentColumn < words.length; curentColumn++) {
					trainingData[currentRow][curentColumn] = words[curentColumn];
				}
				currentRow++;
			}
		}
		in.close();

		// columns need to be converted to numerical value
		// weighting values
		for (int z = 0; z < 17; z++) {
			int mainFactor = 10;
			if (z == 3) {
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						if (!types.contains(trainingData[x][z])) {
							types.add(trainingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						trainingData[x][z] = Double.toString((factor * types
								.indexOf(trainingData[x][z])));
					}
				}
			} else if (z == 1) { // workclass
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						if (!types.contains(trainingData[x][z])) {
							types.add(trainingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						trainingData[x][z] = Double.toString((factor * types
								.indexOf(trainingData[x][z])));
					}
				}
			} else if (z == 8) { // race
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						if (!types.contains(trainingData[x][z])) {
							types.add(trainingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						trainingData[x][z] = Double.toString((factor * types
								.indexOf(trainingData[x][z])));
					}
				}
			} else if (z == 9) { // sex
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						if (!types.contains(trainingData[x][z])) {
							types.add(trainingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						trainingData[x][z] = Double.toString((factor * types
								.indexOf(trainingData[x][z])));
					}
				}
			} else if (z == 7) { // relationship
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						if (!types.contains(trainingData[x][z])) {
							types.add(trainingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						trainingData[x][z] = Double.toString((factor * types
								.indexOf(trainingData[x][z])));
					}
				}
			} else if (z == 13) { // country of origin
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						if (!types.contains(trainingData[x][z])) {
							types.add(trainingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						trainingData[x][z] = Double.toString((factor * types
								.indexOf(trainingData[x][z])));
					}
				}
			} else if (z == 5) { // civil status
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						if (!types.contains(trainingData[x][z])) {
							types.add(trainingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						trainingData[x][z] = Double.toString((factor * types
								.indexOf(trainingData[x][z])));
					}
				}
			} else if (z == 6) { // job
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						if (!types.contains(trainingData[x][z])) {
							types.add(trainingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						trainingData[x][z] = Double.toString((factor * types
								.indexOf(trainingData[x][z])));
					}
				}
			} else if (z == 0) { // age
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						double converted = Double.valueOf(trainingData[x][z]);
						double result = converted * 1;
						trainingData[x][z] = String.valueOf(result);
					}
				}
			} else if (z == 2) { // fnlwgt
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						double converted = Double.valueOf(trainingData[x][z]);
						double result = converted * 1;
						trainingData[x][z] = String.valueOf(result);
					}
				}
			} else if (z == 4) { // education (years)
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						double converted = Double.valueOf(trainingData[x][z]);
						double result = converted * 1;
						trainingData[x][z] = String.valueOf(result);
					}
				}
			} else if (z == 10) { // capital gained
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						double converted = Double.valueOf(trainingData[x][z]);
						double result = converted * 300;
						trainingData[x][z] = String.valueOf(result);
					}
				}
			} else if (z == 11) { // capital lost
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						double converted = Double.valueOf(trainingData[x][z]);
						double result = converted * 600;
						trainingData[x][z] = String.valueOf(result);
					}
				}
			} else if (z == 12) { // hours
				for (int x = 0; x < 11000; x++) {
					if (!(trainingData[x][z].equals("?"))) {
						double converted = Double.valueOf(trainingData[x][z]);
						double result = converted * 300;
						trainingData[x][z] = String.valueOf(result);
					}
				}
			} else if (z == 14) { // 50k factor is not missing any data
				for (int x = 0; x < 11000; x++) {
					if ((trainingData[x][z].equals(">50K"))) {
						trainingData[x][z] = "1";
					} else {
						trainingData[x][z] = "0";
					}
				}
			} else if (z == 16) { // saving primary key
				for (int x = 0; x < 11000; x++) {
					trainingData[x][z] = String.valueOf(x);
				}
			}
		}

		// fix "?" values, replace them with average value for each column /
		// last three
		// columns are not included
		for (int z = 0; z < 14; z++) {
			double total = 0;
			double average;
			double goodRecords = 11000;
			for (int x = 0; x < 11000; x++) {
				if (!(trainingData[x][z].equals("?"))) {
					total += Double.valueOf(trainingData[x][z]);
				} else {
					goodRecords--;
				}
			}
			average = total / goodRecords;
			for (int x = 0; x < 11000; x++) {
				if ((trainingData[x][z].equals("?"))) {
					trainingData[x][z] = String.valueOf(average);
				}
			}
		}

		// split all values into 5 folds with double values
		double[][] fold1 = new double[2200][17];
		double[][] fold2 = new double[2200][17];
		double[][] fold3 = new double[2200][17];
		double[][] fold4 = new double[2200][17];
		double[][] fold5 = new double[2200][17];
		int fold1Column = 0;
		int fold2Column = 0;
		int fold3Column = 0;
		int fold4Column = 0;
		int fold5Column = 0;
		for (int x = 0; x < 11000; x++) {
			if (trainingData[x][15].equals("1")) {
				for (int z = 0; z < 17; z++) {
					fold1[fold1Column][z] = Double.valueOf(trainingData[x][z]);
				}
				fold1Column++;
			}
			if (trainingData[x][15].equals("2")) {
				for (int z = 0; z < 17; z++) {
					fold2[fold2Column][z] = Double.valueOf(trainingData[x][z]);
				}
				fold2Column++;
			}
			if (trainingData[x][15].equals("3")) {
				for (int z = 0; z < 17; z++) {
					fold3[fold3Column][z] = Double.valueOf(trainingData[x][z]);
				}
				fold3Column++;
			}
			if (trainingData[x][15].equals("4")) {
				for (int z = 0; z < 17; z++) {
					fold4[fold4Column][z] = Double.valueOf(trainingData[x][z]);
				}
				fold4Column++;
			}
			if (trainingData[x][15].equals("5")) {
				for (int z = 0; z < 17; z++) {
					fold5[fold5Column][z] = Double.valueOf(trainingData[x][z]);
				}
				fold5Column++;
			}
		}

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CROSS VALIDATION
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		double[] finalAccuracyResults = new double[20]; // saving medium
		// accuracy for 5 folds
		// and knn 1-39
		for (int v = 0; v < finalAccuracyResults.length; v++) {
			finalAccuracyResults[v] = 0;
		}

		// at this point the data is ready for training / cross validation

		for (int f = 0; f < 5; f++) { // fold loop

			// one fold
			double[][] trainData = new double[8800][17];
			double[][] testData = new double[2200][17];

			// loading train data
			for (int z = 0; z < 17; z++) {
				for (int x = 0; x < 2200; x++) {
					if (f == 0) {
						trainData[x][z] = fold1[x][z];
					}
					if (f == 1) {
						trainData[x][z] = fold2[x][z];
					}
					if (f == 2) {
						trainData[x][z] = fold3[x][z];
					}
					if (f == 3) {
						trainData[x][z] = fold4[x][z];
					}
					if (f == 4) {
						trainData[x][z] = fold5[x][z];
					}
				}
			}
			for (int z = 0; z < 17; z++) {
				for (int x = 0; x < 2200; x++) {
					if (f == 0) {
						trainData[x + 2200][z] = fold2[x][z];
					}
					if (f == 1) {
						trainData[x + 2200][z] = fold3[x][z];
					}
					if (f == 2) {
						trainData[x + 2200][z] = fold4[x][z];
					}
					if (f == 3) {
						trainData[x + 2200][z] = fold5[x][z];
					}
					if (f == 4) {
						trainData[x + 2200][z] = fold1[x][z];
					}
				}
			}
			for (int z = 0; z < 17; z++) {
				for (int x = 0; x < 2200; x++) {
					if (f == 0) {
						trainData[x + 4400][z] = fold3[x][z];
					}
					if (f == 1) {
						trainData[x + 4400][z] = fold4[x][z];
					}
					if (f == 2) {
						trainData[x + 4400][z] = fold5[x][z];
					}
					if (f == 3) {
						trainData[x + 4400][z] = fold1[x][z];
					}
					if (f == 4) {
						trainData[x + 4400][z] = fold2[x][z];
					}
				}
			}
			for (int z = 0; z < 17; z++) {
				for (int x = 0; x < 2200; x++) {
					if (f == 0) {
						trainData[x + 6600][z] = fold4[x][z];
					}
					if (f == 1) {
						trainData[x + 6600][z] = fold5[x][z];
					}
					if (f == 2) {
						trainData[x + 6600][z] = fold1[x][z];
					}
					if (f == 3) {
						trainData[x + 6600][z] = fold2[x][z];
					}
					if (f == 4) {
						trainData[x + 6600][z] = fold3[x][z];
					}
				}
			}
			// loading test data
			for (int z = 0; z < 17; z++) {
				for (int x = 0; x < 2200; x++) {
					if (f == 0) {
						testData[x][z] = fold5[x][z];
					}
					if (f == 1) {
						testData[x][z] = fold1[x][z];
					}
					if (f == 2) {
						testData[x][z] = fold2[x][z];
					}
					if (f == 3) {
						testData[x][z] = fold3[x][z];
					}
					if (f == 4) {
						testData[x][z] = fold4[x][z];
					}
				}
			}

			// loop through test data and train data, count distance, sort from
			// smallest to
			// biggest.

			double[][] testDataResults = new double[2200][40]; // 2200 data
																// points and 40
																// results of
																// NN, 0 or 1

			int numberTest = 2200; // 2200 max / control

			for (int z = 0; z < numberTest; z++) { // testing data loop // max
													// 2200
				System.out.println("current fold=" + (f + 1)
						+ " current data index=" + z);

				double[][] distances = new double[8800][2]; // 0 - 50K factor 1
															// - distance
				for (int x = 0; x < 8800; x++) { // training data loop
					distances[x][0] = trainData[x][14];
					distances[x][1] = knn
							.euclidean(testData[z][0], trainData[x][0],
									testData[z][1], trainData[x][1],
									testData[z][2], trainData[x][2],
									testData[z][3], trainData[x][3],
									testData[z][4], trainData[x][4],
									testData[z][5], trainData[x][5],
									testData[z][6], trainData[x][6],
									testData[z][7], trainData[x][7],
									testData[z][8], trainData[x][8],
									testData[z][9], trainData[x][9],
									testData[z][10], trainData[x][10],
									testData[z][11], trainData[x][11],
									testData[z][12], trainData[x][12],
									testData[z][13], trainData[x][13]);
				}

				ArrayList<Integer> shortestDist = new ArrayList<Integer>();// array
																			// for
																			// saving
																			// shortest
																			// distance
																			// indexes
				for (int k = 0; k < 40; k++) { // setting some distance index to
												// be
												// replaced
					shortestDist.add(0);
				}

				for (int g = 0; g < 8800; g++) {
					for (int a = 0; a < 40; a++) {
						if (distances[g][1] < distances[shortestDist.get(a)][1]) {
							shortestDist.remove(39); // remove last item
							shortestDist.add(a, g); // insert index of a smaller
													// one
							break;
						}
					}
				}

				// saving nearest 40 results to z testing data
				for (int r = 0; r < 40; r++) {
					testDataResults[z][r] = distances[shortestDist.get(r)][0];
				}

			} // end of testing data loop

			for (int kFactor = 1; kFactor < 41; kFactor += 2) {
				// displaying accuracies for 1-39 knn
				ArrayList<Double> results = new ArrayList<Double>();
				for (int h = 0; h < numberTest; h++) {
					int positive = 0;
					int negative = 0;
					for (int d = 0; d < kFactor; d++) {
						if (testDataResults[h][d] == 1.0) {
							positive++;
						} else {
							negative++;
						}
					}
					if (positive > negative) {
						results.add(1.0);
					} else {
						results.add(0.0);
					}
				}
				double hits = 0.0;
				for (int g = 0; g < numberTest; g++) {
					if (results.get(g) == testData[g][14]) {
						hits++;
					}
				}

				double currentAccuracy = hits / numberTest;

				finalAccuracyResults[kFactor / 2] += currentAccuracy;

				System.out.println("Fold " + (f + 1) + " accuracy for "
						+ kFactor + "NN is equal " + currentAccuracy);
			}

		} // end of fold loop

		// counting average accuracy over 5 folds for all knn 1-39
		System.out.println("<><><><><><><><><><><><><><><><><><>");
		for (int v = 0; v < finalAccuracyResults.length; v++) {
			finalAccuracyResults[v] = finalAccuracyResults[v] / 5.0;
			System.out.println("Final average accuracy over 5 folds for knn="
					+ (v * 2 + 1) + " equals " + finalAccuracyResults[v]);
		}
		System.out.println("<><><><><><><><><><><><><><><><><><>");

		// looking for best accuracy over 5 folds
		int bestAccuracyIndex = 0;

		for (int v = 0; v < finalAccuracyResults.length; v++) {
			if (finalAccuracyResults[v] > finalAccuracyResults[bestAccuracyIndex]) {
				bestAccuracyIndex = v;
			}
		}

		int bestKnn = ((bestAccuracyIndex * 2) + 1); // best knn that will be
														// used later for
														// testing data

		System.out
				.println("Best average accuracy parameters over 5 folds - knn:"
						+ ((bestAccuracyIndex * 2) + 1) + ", accuracy:"
						+ finalAccuracyResults[bestAccuracyIndex]);

		// save results to a file
		PrintWriter writer = new PrintWriter("grid.results.txt", "UTF-8");
		writer.println("KNN | ACCURACY");
		for (int v = 0; v < finalAccuracyResults.length; v++) {
			if (v < 5) {
				writer.println((v * 2 + 1) + "   | " + finalAccuracyResults[v]);
			} else {
				writer.println((v * 2 + 1) + "  | " + finalAccuracyResults[v]);
			}
		}
		writer.close();

		// importing testing dataset and preparing data

		// reading training data
		String[][] testingData = new String[16281][16]; // 16th column for
														// primary key
		in = new BufferedReader(new FileReader("adult.test.csv"));
		currentRow = 0;
		line = "";
		missFirstLine = true;

		int dataRows = 16281; // limiting rows to read
		while ((line = in.readLine()) != null) {
			if (missFirstLine) {
				missFirstLine = false;
			} else {
				String[] words = line.split(",");
				for (int curentColumn = 0; curentColumn < words.length; curentColumn++) {
					testingData[currentRow][curentColumn] = words[curentColumn];
				}
				currentRow++;
				dataRows--;
				if (dataRows == 0) {
					break;
				}
			}
		}

		in.close();

		// columns need to be converted to numerical value
		// weighting values
		for (int z = 0; z < 16; z++) {
			int mainFactor = 100;
			if (z == 3) {
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						if (!types.contains(testingData[x][z])) {
							types.add(testingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						testingData[x][z] = Double.toString((factor * types
								.indexOf(testingData[x][z])));
					}
				}
			} else if (z == 1) { // workclass
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						if (!types.contains(testingData[x][z])) {
							types.add(testingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						testingData[x][z] = Double.toString((factor * types
								.indexOf(testingData[x][z])));
					}
				}
			} else if (z == 8) { // race
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						if (!types.contains(testingData[x][z])) {
							types.add(testingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						testingData[x][z] = Double.toString((factor * types
								.indexOf(testingData[x][z])));
					}
				}
			} else if (z == 9) { // sex
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						if (!types.contains(testingData[x][z])) {
							types.add(testingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						testingData[x][z] = Double.toString((factor * types
								.indexOf(testingData[x][z])));
					}
				}
			} else if (z == 7) { // relationship
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						if (!types.contains(testingData[x][z])) {
							types.add(testingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						testingData[x][z] = Double.toString((factor * types
								.indexOf(testingData[x][z])));
					}
				}
			} else if (z == 13) { // country of origin
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						if (!types.contains(testingData[x][z])) {
							types.add(testingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						testingData[x][z] = Double.toString((factor * types
								.indexOf(testingData[x][z])));
					}
				}
			} else if (z == 5) { // civil status
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						if (!types.contains(testingData[x][z])) {
							types.add(testingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						testingData[x][z] = Double.toString((factor * types
								.indexOf(testingData[x][z])));
					}
				}
			} else if (z == 6) { // job
				ArrayList<String> types = new ArrayList<String>();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						if (!types.contains(testingData[x][z])) {
							types.add(testingData[x][z]);
						}
					}
				}
				double factor = mainFactor / types.size();
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						testingData[x][z] = Double.toString((factor * types
								.indexOf(testingData[x][z])));
					}
				}
			} else if (z == 0) { // age
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						double converted = Double.valueOf(testingData[x][z]);
						double result = converted * 1;
						testingData[x][z] = String.valueOf(result);
					}
				}
			} else if (z == 2) { // fnlwgt
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						double converted = Double.valueOf(testingData[x][z]);
						double result = converted * 1;
						testingData[x][z] = String.valueOf(result);
					}
				}
			} else if (z == 4) { // education (years)
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						double converted = Double.valueOf(testingData[x][z]);
						double result = converted * 1;
						testingData[x][z] = String.valueOf(result);
					}
				}
			} else if (z == 10) { // capital gained
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						double converted = Double.valueOf(testingData[x][z]);
						double result = converted * 3000;
						testingData[x][z] = String.valueOf(result);
					}
				}
			} else if (z == 11) { // capital lost
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						double converted = Double.valueOf(testingData[x][z]);
						double result = converted * 6000;
						testingData[x][z] = String.valueOf(result);
					}
				}
			} else if (z == 12) { // hours
				for (int x = 0; x < 16281; x++) {
					if (!(testingData[x][z].equals("?"))) {
						double converted = Double.valueOf(testingData[x][z]);
						double result = converted * 3000;
						testingData[x][z] = String.valueOf(result);
					}
				}
			} else if (z == 14) { // 50k factor is not missing any data
				for (int x = 0; x < 16281; x++) {
					if ((testingData[x][z].equals(" >50K"))) {
						testingData[x][z] = "1";
					} else {
						testingData[x][z] = "0";
					}
				}
			} else if (z == 15) { // saving primary key
				for (int x = 0; x < 16281; x++) {
					testingData[x][z] = String.valueOf(x);
				}
			}
		}

		// fix "?" values, replace them with average value for each column /
		// last two
		// columns are not included
		for (int z = 0; z < 14; z++) {
			double total = 0;
			double average;
			double goodRecords = 16281;
			for (int x = 0; x < 16281; x++) {
				if (!(testingData[x][z].equals("?"))) {
					total += Double.valueOf(testingData[x][z]);
				} else {
					goodRecords--;
				}
			}
			average = total / goodRecords;
			for (int x = 0; x < 16281; x++) {
				if ((testingData[x][z].equals("?"))) {
					testingData[x][z] = String.valueOf(average);
				}
			}
		}

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< FINAL VALIDATION
		// STARTS HERE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		// needs to count accuracy using 11 000 training records and 16 281
		// testing records.

		// converting data to doubles
		Double[][] finalTrainingData = new Double[11000][17];
		Double[][] finalTestingData = new Double[16281][16];

		for (int d = 0; d < 11000; d++) {
			for (int c = 0; c < 17; c++) {
				finalTrainingData[d][c] = Double.valueOf(trainingData[d][c]);
			}
		}
		for (int d = 0; d < 16281; d++) {
			for (int c = 0; c < 16; c++) {
				finalTestingData[d][c] = Double.valueOf(testingData[d][c]);
			}
		}

		// loop through test data and train data, count distance, sort from
		// smallest to
		// biggest.

		double[][] testDataResults = new double[16281][40]; // max 40 knn to
															// check

		int finalNumberTest = 16281; // 16 281 max / control

		for (int z = 0; z < finalNumberTest; z++) { // testing data loop

			System.out.println("Final test - current data index=" + z);

			double[][] distances = new double[11000][2]; // 0 - 50K factor, 1 -
															// distance

			for (int x = 0; x < 11000; x++) { // training data loop, saving
												// results in array
				distances[x][0] = finalTrainingData[x][14];
				distances[x][1] = knn.euclidean(finalTestingData[z][0],
						finalTrainingData[x][0], finalTestingData[z][1],
						finalTrainingData[x][1], finalTestingData[z][2],
						finalTrainingData[x][2], finalTestingData[z][3],
						finalTrainingData[x][3], finalTestingData[z][4],
						finalTrainingData[x][4], finalTestingData[z][5],
						finalTrainingData[x][5], finalTestingData[z][6],
						finalTrainingData[x][6], finalTestingData[z][7],
						finalTrainingData[x][7], finalTestingData[z][8],
						finalTrainingData[x][8], finalTestingData[z][9],
						finalTrainingData[x][9], finalTestingData[z][10],
						finalTrainingData[x][10], finalTestingData[z][11],
						finalTrainingData[x][11], finalTestingData[z][12],
						finalTrainingData[x][12], finalTestingData[z][13],
						finalTrainingData[x][13]);
			}

			ArrayList<Integer> shortestDist = new ArrayList<Integer>();// array
			// for
			// saving
			// shortest
			// distance
			// indexes
			for (int k = 0; k < 40; k++) { // setting some distance index to be
											// replaced
				shortestDist.add(0);
			}

			for (int g = 0; g < 11000; g++) {
				for (int a = 0; a < 40; a++) {
					if (distances[g][1] < distances[shortestDist.get(a)][1]) {
						shortestDist.remove(39); // remove last item
						shortestDist.add(a, g); // insert index of a smaller
						// one
						break;
					}
				}
			}

			// saving nearest 40 results to z testing data
			for (int r = 0; r < 40; r++) {
				testDataResults[z][r] = distances[shortestDist.get(r)][0];
			}

		} // end of testing data loop

		// counting predicted results 
		ArrayList<Double> results = new ArrayList<Double>();
		for (int h = 0; h < finalNumberTest; h++) {
			int positive = 0;
			int negative = 0;
			// decision based on bestKnn selected by 5 fold cross validation
			for (int d = 0; d < bestKnn; d++) {
				if (testDataResults[h][d] == 1.0) {
					positive++;
				} else {
					negative++;
				}
			}
			if (positive > negative) {
				results.add(1.0);
			} else {
				results.add(0.0);
			}
		}

		// counting guessed results
		double TrueOne = 0;
		double TrueZero = 0;
		double FalseOne = 0;
		double FalseZero = 0;

		double hits = 0.0;
		for (int g = 0; g < finalNumberTest; g++) {
			if (results.get(g) == 1.0 && (finalTestingData[g][14]) == 1.0) {
				hits++;
				TrueOne++;
			}
			if (results.get(g) == 0.0 && (finalTestingData[g][14]) == 0.0) {
				hits++;
				TrueZero++;
			}
			if (results.get(g) == 0.0 && (finalTestingData[g][14]) == 1.0) {
				FalseZero++;
			}
			if (results.get(g) == 1.0 && (finalTestingData[g][14]) == 0.0) {
				FalseOne++;
			}
		}

		double finalAccuracy = (hits / finalNumberTest);

		// print out the final results:
		System.out.println();
		System.out
				.println("Final testing results using 5fold(11000 records) best knn("
						+ bestKnn + ") on testing data(16281 records)");
		System.out.println();
		// confusion matrix
		System.out.println("Confusion matrix: ");
		System.out.println();
		System.out.println(TrueOne + " | " + FalseZero);
		System.out.println("----------------");
		System.out.println(FalseOne + " | " + TrueZero);
		System.out.println();
		// precision
		System.out.println("Precision: " + finalAccuracy);
		System.out.println();
		// sensitivity - true positive values
		System.out.println("Sensitivity: " + TrueOne / finalNumberTest);
		System.out.println();
		// specificity - true negative values
		System.out.println("Specificity: " + TrueZero / finalNumberTest);

	}

	public static double euclidean(double age1, double age2, double workclass1,
			double workclass2, double fnlwgt1, double fnlwgt2,
			double education1, double education2, double educationNum1,
			double educationNum2, double martialStatus1, double martialStatus2,
			double occupation1, double occupation2, double relationship1,
			double relationship2, double race1, double race2, double sex1,
			double sex2, double capitalGain1, double capitalGain2,
			double capitalLoss1, double capitalLoss2, double hoursPerWeek1,
			double hoursPerWeek2, double nativeCountry1, double nativeCountry2) {

		double distance = Math.sqrt(Math.pow((age1 - age2), 2)
				+ Math.pow((workclass1 - workclass2), 2)
				+ Math.pow((fnlwgt1 - fnlwgt2), 2)
				+ Math.pow((education1 - education2), 2)
				+ Math.pow((educationNum1 - educationNum2), 2)
				+ Math.pow((martialStatus1 - martialStatus2), 2)
				+ Math.pow((occupation1 - occupation2), 2)
				+ Math.pow((relationship1 - relationship2), 2)
				+ Math.pow((race1 - race2), 2) + Math.pow((sex1 - sex2), 2)
				+ Math.pow((capitalGain1 - capitalGain2), 2)
				+ Math.pow((capitalLoss1 - capitalLoss2), 2)
				+ Math.pow((hoursPerWeek1 - hoursPerWeek2), 2)
				+ Math.pow((nativeCountry1 - nativeCountry2), 2));

		return distance;
	}

}
