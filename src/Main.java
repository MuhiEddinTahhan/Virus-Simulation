/**
 * Name: Muhi Eddin Tahhan
 * Date: January 25th, 2024
 * Description: Simulation of Malware and how it functions
 */

import Skeleton.SimulationInput;
import Skeleton.StatisticsContainer;
import java.util.ArrayList;

/**
 * The main class is responsible for the testing. It has a helper method
 * that makes it easier to run many tests.
 **/
public class Main {

	/**
	 * Runs a test with the given input and returns the statistics
	 * produced from the test run. Simplifies the testing process.
	 * @param input The input to run the test with.
	 * @return The statistics of the test run.
	 */
	public static StatisticsContainer runTest(SimulationInput input) {
		// Initialize the stats singleton here so the input can
		// be ignored in future calls
		StatisticsContainer stats = StatisticsContainer.getInstance(input);
		Matrix.run(input);

		return stats;
	}

	/**
	 * See method above for details.
	 **/
	public static StatisticsContainer runTest(ArrayList<ArrayList<String>> input) {
		return runTest(new SimulationInput(input));
	}

	/**
	 * main function is used to apply the tests we wrote for the MalwareUnit class
	 * @param args the test arguments
	 */
	public static void main(String[] args) {
		MalwareUnitTest test = new MalwareUnitTest();
		test.testBasicFunctionality();
		test.testConcurrency();
		test.testStress();
		test.testEdgeCases();
		test.testIPGeneratorClass();
	}
}
