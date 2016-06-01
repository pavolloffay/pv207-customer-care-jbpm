package fi.muni.pv207.registration.db;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fi.muni.pv207.registration.Customer;

/**
 * @author Pavol Loffay
 */
public class CustomerDatabase {

    public static Map<String, Customer> customerMap = new HashMap<>();
    static {

        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE, 15); // Adds 15 days

        customerMap.put("admin@customercare.com",
                new Customer("Honza", "admin@customercare.com", "Novak", c.getTime(), "PREMIUM"));
    }
}
