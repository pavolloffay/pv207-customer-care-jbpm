package fi.muni.pv207.registration.db;

import java.util.HashMap;
import java.util.Map;

import fi.muni.pv207.registration.Customer;

/**
 * @author Pavol Loffay
 */
public class CustomerDatabase {

    public static Map<String, Customer> customerMap = new HashMap<>();
    static {
        customerMap.put("admin@customercare.com", new Customer("Honza", "admin@customercasre.com", "Novak"));
    }
}
