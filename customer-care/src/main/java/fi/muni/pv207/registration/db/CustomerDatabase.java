package fi.muni.pv207.registration.db;

import fi.muni.pv207.registration.Customer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavol Loffay
 */
public class CustomerDatabase {

    public static Map<String, Customer> customerMap = new HashMap<>();
    static {
        customerMap.put("admin@customercare.com", new Customer("Honza", "admin@customercasre.com", "Novak", new Date(), "PREMIUM"));
    }
}
