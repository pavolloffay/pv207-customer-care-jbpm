package fi.muni.pv207.registration.db;

import fi.muni.pv207.registration.Customer;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Pavol Loffay
 */
public class CustomerDatabase {

    public static Map<String, Customer> customerMap = new HashMap<>();
    static {
        customerMap.put("admin@customercare.com", new Customer("Honza", "admin@customercasre.com", "Novak", new Date(), "PREMIUM"));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
	String dateInString = "01-01-2017";
        Date date = new Date();
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException ex) {
            Logger.getLogger(CustomerDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        customerMap.put("martin@email.com", new Customer("Martin", "martin@email.com", "Polak", date, "PREMIUM"));
    }
}
