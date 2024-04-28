import Skeleton.SimulationInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IPAddressGenerator {
    private static SimulationInput input;
    private static IPAddressGenerator instance;

    /**
     * the instance that the virus will use to generate a new set of IP addresses
     * @return the instance
     */
    public static synchronized IPAddressGenerator getInstance() {
        if (instance == null) {
            instance = new IPAddressGenerator(input);
        }
        return instance;
    }

    /**
     * constructor for IPAddressGenerator
     * @param input the input that is passed
     */
    public IPAddressGenerator(SimulationInput input) {
        this.input = input;
    }

    /**
     * this method generate random IPs based on how much time is given to the simulation
     * @return the ipAddress list
     */
    public List<String> generateRandomIPAddresses() {
        Random random = new Random();
        int timeDuration = input.getIntegerInput("Time");  // Assuming getIntegerInput is a non-static method now
        List<String> ipAddresses = new ArrayList<>();

        for (int i = 0; i < timeDuration; i++) {
            String ipAddress = String.format("%d.%d.%d.%d",
                    random.nextInt(256),  // Generate a random integer from 0 to 255
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256));
            ipAddresses.add(ipAddress);
        }
        return ipAddresses;
    }
}