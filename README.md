# Virus-Simulation
Virus simulation that showcases implementations of design patterns
The Malware Simulation Program is designed to emulate various types of malware actions for educational purposes. It uses a structured approach to simulate actions such as scanning for hosts, sending phishing emails, establishing connections, dumping system files, cracking passwords, and deleting logs. The program is implemented in Java and extends a base class “Unit” to represent each type of malware as an object.

The program initializes the following:

![Screenshot 2024-04-25 231958](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/c26835b5-f9e2-4bab-983f-ee0ed4b055ca)


The MalwareUnit has a method that helps enumerate through actions like scanning, sending emails, etc. Each MalwareUnit created has one role to do:


![Screenshot 2024-04-25 232203](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/cc2cce85-2263-42d3-9d3e-ccfd9ef5cdae)


## MalwareUnit class methods


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


### MalwareActionObserver (Interface)


• Purpose: This interface is part of the Observer Design Pattern. It is used to define a standard for observers that need to react to changes or actions in a subject, in this case, malware actions.


• Methods:

◇ update(MalwareUnit malwareUnit, String action): Method that gets called to notify the observer about an action performed by a MalwareUnit. This allows the observer to perform specific reactions to different types of actions (like logging, altering configurations, etc.).


• Classes that implemented this interface:  LoggingObserver, MonitoringObserver

![Screenshot 2024-04-26 020054](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/62c74adf-5521-402e-aa12-11e20f43cdf5)


### MalwareActionSubject (Interface)


• Purpose: Complements the MalwareActionObserver by providing an interface for subjects. It allows subjects to manage (add, remove) observers and notify them of changes or actions.


• Methods:

◇ addObserver(MalwareActionObserver observer): Adds an observer to the subject's list of observers.

◇ removeObserver(MalwareActionObserver observer): Removes an observer from the subject's list of observers.

◇ notifyObservers(String action): Notifies all registered observers of an action, triggering their update method.


• Classes that implemented this interface:  MalwareUnit


![Screenshot 2024-04-26 020112](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/43eaef97-4638-4218-9865-67356f8bb27d)


### MalwareUnitTemplate (Abstract Class)


• Purpose: This abstract class serves as a template for creating different types of malware units. It utilizes the Template Method Design Pattern to define the skeleton of an algorithm, in this case, the steps involved in malware operations, while allowing its subclasses to redefine certain steps without changing the algorithm's structure.


• Methods:

◇ attack(): An abstract method that must be implemented by subclasses to define specific attack behaviours of different types of malware.

◇ attackHost(): A concrete method that calls the attack() method. This method provides a fixed algorithm structure for executing an attack while the specific details of the attack are defined in attack() by subclasses.


• Classes that extended this class:  Scan, SendingEmail, EstablishConnection, DumpSAMFile, CrackPassword, and DeleteLogs

![Screenshot 2024-04-26 020143](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/3142b7f9-beb8-4ab4-aa48-c478bc87259b)

## Other Classes

### IPAddressGenerator Class 


The IPAddressGenerator class is responsible for dynamically generating IP addresses when no specific IPs are provided to the system. This functionality is critical in simulations where the user does not specify target IP addresses, allowing the system to create a realistic network environment by simulating interactions with various generated IPs.

• Methods:

◇ generateRandomIPAddresses(): This is the primary method of the IPAddressGenerator class. It generates a list of IP addresses based on the parameters defined within the method or passed through the constructor. The method typically involves random generation techniques to ensure a diverse set of IPs, mimicking real-world scenarios where malware might interact with different systems across the internet.

![Screenshot 2024-04-26 021752](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/201ab9b6-3c98-44ad-be64-589ea7d75f6c)


### MalwareUnitTest Class

The MalwareUnitTest class is designed to conduct automated tests on the MalwareUnit class. It evaluates the functionality of malware simulations under controlled conditions to ensure that the malware behaves as expected across different scenarios.

• Methods:

◇ testBasicFunctionality(): Tests the basic operations of the MalwareUnit such as executing actions like scanning, sending emails, etc. It ensures that the unit can perform its fundamental tasks.

◇ testConcurrency(): This test checks the MalwareUnit's ability to handle simultaneous actions on multiple threads, simulating a real-world scenario where malware might have to interact with multiple systems concurrently.

◇ testStress(): Pushes the MalwareUnit to its limits by requiring it to perform a high number of actions in a short amount of time. This tests the robustness and efficiency of the malware under stress conditions.

◇ testEdgeCases(): Focuses on how the MalwareUnit handles boundary or unusual conditions, such as zero time to perform actions or an empty list of target IPs.

◇ testIPGeneratorClass(): Focuses on testing the IPAddressGenrator class to see by giving an empty list with a time to perform the simulation.

## Design and Implementations decisions

The program is designed to create a new MalwareUnit object for each IP address that is being passed and a virus for each type of action. The viruses are created based on a switch that takes nextAction's variable as the indication of what the virus should do:

![Screenshot 2024-04-25 233239](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/20a83ca4-47f4-4795-b124-7ed2003993da)

Statistics are being submitted based on the Actions that the Malware unit performs and how many active units are being created for the list of IPs that were given. For the actions that the virus performs, each action is a separate class that extends its functionality from MalwareUnitTemplate which is an abstract class. The reason why I chose to make a template is to give me more flexibility with accessing the attacks, in addition, to not having to initialize a new object every time. 

![Screenshot 2024-04-25 234037](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/5a363454-12e8-4e19-90c5-cfae53187296)

## Used Design Patterns

• Template Pattern: The MalwareUnit class uses the template method pattern via its abstract superclass Unit, where the performAction() method is overridden to execute different malware actions based on the malware unit's current state. Also, it is used with the attacks of the viruses. It is shown in the abstract class MalwareUnitTemplate and every action class extends from that class and overrides the method attack(). The reason why I chose the template method for the viruses' actions is because most of the actions have the same algorithm with some minor differences. 

• Singleton Pattern: Used in classes like IPAddressGenerator to ensure that there is a single instance of the IP addresses generated for the viruses in case there is no input from the user. The reason why I chose Singleton is because all the viruses should work on the same IP addresses. therefore it is important that the IP generator has only one instance.

• Strategy Pattern: The program utilizes the strategy pattern to change the display behaviour of the simulation output through the DatabaseDisplayStrategy interface. This allows changing the output format without altering the virus objects. I chose the Strategy pattern because it allows us the flexibility to implement more classes that are more specialized in the representation of the data. In this program, this interface has been used to show the info that the viruses have like the IPs and their passwords. We could create another class that could display more specified info about the target for example.

• Factory Method: The IPAddressGenerator class represents a factory method pattern that encapsulates the creation of IP address lists, abstracting the complexity of IP generation.

• Observer Pattern: I used the observer pattern to add the Logging and Monitoring functionality to the MalwareUnit. I made 2 interfaces. MalwareActionObserver where this interface represents an observer in the Observer design pattern specific to malware actions. MalwareActionSubject is an interface where actions like adding, removing, and notifying observers are being introduced. The update method is being overridden in the LoggingObserver and the MonitoringObserver classes where each class has its own functionality.

## Choice of logic

• The program heavily relies on lists to manage IPs and concurrent threads to simulate real-time malware operations.

• Enum is used to manage types of actions, ensuring a robust way of handling different operations by malware units.

• Hash Maps were used to store the passwords with their proper IP address.

• Switcher was used because it was easier to use with an enum to indicate the functionality of the virus than doing it with if-else.

• Threads were used to start virus instances.

## Usage of DRY and SOLID

• DRY (Don't Repeat Yourself): Shared functionalities like IP generation and sleeping between actions are abstracted in separate methods or classes, reducing repetition.

• SOLID:

◇ Single Responsibility Principle: Each class has a single responsibility, e.g., IPAddressGenerator only generates IPs.

◇ Open/Closed Principle: The system is open for extension but closed for modification, demonstrated by the ability to add new types of malware actions without altering existing code.

◇ Liskov Substitution Principle: Subclasses of Unit like MalwareUnit class, can substitute for their parent without disrupting the expected behavior.

◇ Interface Segregation and Dependency Inversion: The use of interfaces in the program ensures that specific functionalities are not needlessly exposed to classes that do not require them like the DatabaseDisplayStrategy interface where a class that implements it is only concerned about the specific logic that it wants to implement without altering the interface itself which achieves the Interface Segregation. For Dependency Inversion, we can see this characteristic is applied with all the interfaces in the simulation, as well as, the abstract class MalwareUnitTemplate where we saw that abstraction like the template class does not depend on what the action is going to be, but the action classes like Scan depend on the abstract class.

## Synchronization choices

The one place that the Synchronization is presented is within the Matrix class where the viruses will be created as threads to run with the simulation. The threads will be added to a list of threads so that each thread will have a turn and they will wait until the end of the previous thread to start:

![Screenshot 2024-04-26 014944](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/1d047c0b-faf8-4a8f-abe6-486145d973dd)

![Screenshot 2024-04-26 015001](https://github.com/MuhiEddinTahhan/Virus-Simulation/assets/96084107/381824c4-64fb-48f4-b62b-1ae416fa0b4d)
