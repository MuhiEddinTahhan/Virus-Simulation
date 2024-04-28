# Virus-Simulation
Virus simulation that showcases implementations of design patterns
The Malware Simulation Program is designed to emulate various types of malware actions for educational purposes. It uses a structured approach to simulate actions such as scanning for hosts, sending phishing emails, establishing connections, dumping system files, cracking passwords, and deleting logs. The program is implemented in Java and extends a base class “Unit” to represent each type of malware as an object.

The program initializes the following:

![Screenshot 2024-04-25 231958](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/c26835b5-f9e2-4bab-983f-ee0ed4b055ca)


The MalwareUnit has a method that helps enumerate through actions like scanning, sending emails, etc. Each MalwareUnit created has one role to do:


![Screenshot 2024-04-25 232203](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/cc2cce85-2263-42d3-9d3e-ccfd9ef5cdae)


## MalwareUnit class methods:


1. Constructor: MalwareUnit(String name, SimulationInput input, Action nextAction, DatabaseDisplayStrategy strategy)
• Purpose: Initializes a new instance of MalwareUnit with specific parameters.
• Usage: Sets up the malware unit with a name, simulation input parameters, the next action it should perform, and the strategy for displaying database information. It also initializes IP addresses and associated passwords if they are not provided in the input.


2. Method: initializeSharedResources(SimulationInput input)
◇ Purpose: Ensures that IP addresses are shared and initialized correctly across multiple instances or parts of the simulation.
◇ Usage: This static method checks if the IP addresses are already initialized and if not, generates them using the IPAddressGenerator. It ensures that all instances of MalwareUnit use the same IP addresses, supporting consistency across the simulation environment.


3. Method: performAction()
◇ Purpose: Executes the action determined by the nextAction property.
◇ Usage: This method controls the workflow of the malware activities based on the specified action. It calls different methods associated with each action type (like scanning, sending emails, etc.), facilitating the simulation of various malware operations.


4. Method: submitStatistics()
   

◇ Purpose: Submits and logs statistics related to malware actions.


◇ Usage: This method is crucial for tracking the number of actions performed by the malware unit, updating the statistical data which can be used for analysis and monitoring the effectiveness or intensity of the malware simulation.


6. Method: setIPAddress()
◇ Purpose: Provides a mechanism to set or update the IP addresses being used in the simulation.
◇ Usage: This static method can be called to explicitly set the list of IP addresses if there is a need to refresh or change the IPs during the simulation.


7. Method: Database()
◇ Purpose: Displays or logs the IP addresses and their associated passwords.
◇ Usage: This static method is used to print out a list of all IP addresses and their corresponding passwords, providing a clear view of the data being managed by the malware unit. This is useful for debugging and ensuring that IP address assignments are as expected.

