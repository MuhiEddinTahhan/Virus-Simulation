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


## Abstract classes and Interfaces:


### DatabaseDisplayStrategy (Interface)

• Purpose: This interface is designed to define a strategy for displaying data, specifically allowing for different ways to present malware-related data. It adheres to the Strategy Design Pattern, enabling the dynamic swapping of the database display algorithm at runtime depending on the context or specific requirements.


• Methods:

◇ display(): Abstract method intended to be implemented by classes that specify how the database should be displayed. Each implementation can display the database in a different format or style, such as verbose or minimalistic.


• Classes that implemented this interface:  SimpleDisplayStrategy

![Screenshot 2024-04-26 000422](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/74aec8c0-0235-4d6f-a5d6-59ed2376f977)


###MalwareActionObserver (Interface)


• Purpose: This interface is part of the Observer Design Pattern. It is used to define a standard for observers that need to react to changes or actions in a subject, in this case, malware actions.


• Methods:

◇ update(MalwareUnit malwareUnit, String action): Method that gets called to notify the observer about an action performed by a MalwareUnit. This allows the observer to perform specific reactions to different types of actions (like logging, altering configurations, etc.).


• Classes that implemented this interface:  LoggingObserver, MonitoringObserver

![Screenshot 2024-04-26 020054](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/62c74adf-5521-402e-aa12-11e20f43cdf5)


###MalwareActionSubject (Interface)


• Purpose: Complements the MalwareActionObserver by providing an interface for subjects. It allows subjects to manage (add, remove) observers and notify them of changes or actions.


• Methods:

◇ addObserver(MalwareActionObserver observer): Adds an observer to the subject's list of observers.

◇ removeObserver(MalwareActionObserver observer): Removes an observer from the subject's list of observers.

◇ notifyObservers(String action): Notifies all registered observers of an action, triggering their update method.


• Classes that implemented this interface:  MalwareUnit


![Screenshot 2024-04-26 020112](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/43eaef97-4638-4218-9865-67356f8bb27d)


###MalwareUnitTemplate (Abstract Class)


• Purpose: This abstract class serves as a template for creating different types of malware units. It utilizes the Template Method Design Pattern to define the skeleton of an algorithm, in this case, the steps involved in malware operations, while allowing its subclasses to redefine certain steps without changing the algorithm's structure.


• Methods:

◇ attack(): An abstract method that must be implemented by subclasses to define specific attack behaviours of different types of malware.

◇ attackHost(): A concrete method that calls the attack() method. This method provides a fixed algorithm structure for executing an attack while the specific details of the attack are defined in attack() by subclasses.


• Classes that extended this class:  Scan, SendingEmail, EstablishConnection, DumpSAMFile, CrackPassword, and DeleteLogs

![Screenshot 2024-04-26 020143](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/3142b7f9-beb8-4ab4-aa48-c478bc87259b)
