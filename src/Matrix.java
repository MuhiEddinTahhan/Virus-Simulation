import Skeleton.SimulationInput;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;


/**
 * The class that is responsible for running the simulation.
 * You will need to modify the run method to initialize, and run all of your units.
 */
public class Matrix {
	private static final List<Thread> activeVirusThreads = new ArrayList<>();		//initialize the viruses threads
	private static final List<MalwareUnit> viruses = new ArrayList<>();				//initialize a list of viruses

	/**
	 * the run method takes the simulation input as a parameter. It creates 6 viruses (based on the operations that the virus have) and start running the simulation
	 * @param input the input that is passed by the SimulationInput class
	 */
	public static void run(SimulationInput input) {
		int numberOfActions = input.getIntegerInput("ActionsPerSecond");

		// Initialize viruses and their respective threads (6 was chosen because the MalwareUnit has 6 operations)
		for (int i = 0; i < 6; i++) {
			MalwareUnit.Action actionType = MalwareUnit.Action.values()[i % MalwareUnit.Action.values().length];	//initialize the virus's action type
			MalwareUnit virus = new MalwareUnit("Virus_" + i, input, actionType, new MalwareUnit.SimpleDisplayStrategy());	//initialize the virus based on the action type
			MalwareUnit.LoggingObserver logObserver = new MalwareUnit.LoggingObserver();		//initialize a new logger
			MalwareUnit.MonitoringObserver monObserver = new MalwareUnit.MonitoringObserver();	//initialize a new monitor
			viruses.add(virus);								//add it to the viruses list
			Thread virusThread = new Thread(virus);			//initialize a new thread
			virusThread.start();							//start the thread
			activeVirusThreads.add(virusThread);			//add the thread to the List of active threads
			virus.addObserver(logObserver);					//add action to log
			virus.addObserver(monObserver);					//add action to monitor

			// Sleep to space out virus activations
			try {
				Thread.sleep(1000 / numberOfActions);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;  // Properly handle interruption for clean shutdown
			}
		}

		// Wait for all virus threads to complete
		for (Thread thread : activeVirusThreads) {
			try {
				thread.join();  // Wait for this thread to die
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.err.println("Simulation was interrupted.");
				return;  // Exit if the main thread is interrupted
			}
		}
		System.out.println("Simulation ended. All viruses have completed execution.");
		System.out.println();
		viruses.getFirst().displayDatabase();			//print the database that the virus
		System.out.println();
	}
}
