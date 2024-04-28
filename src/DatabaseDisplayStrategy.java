import java.util.List;
import java.util.Map;

/**
 * the Database interface that is used to implement the strategy design pattern
 */
public interface DatabaseDisplayStrategy {
    /**
     * the method that will be implemented in SimpleDisplayStrategy concrete class taking ipAddresses and passwords as parameters
     * @param ipAddresses the list of IP addresses
     * @param passwords the list of the passwords that belong to the IP addresses
     */
    void display(List<String> ipAddresses, Map<String, String> passwords);
}
