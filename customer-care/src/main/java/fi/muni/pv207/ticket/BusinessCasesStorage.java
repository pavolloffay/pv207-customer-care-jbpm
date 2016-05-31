package fi.muni.pv207.ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pavol Loffay
 */
public class BusinessCasesStorage {

    private static int counter = 0;
    private static final Map<Integer, List<BusinessCase>> businessCasesMap = new HashMap<>();

    public static void addBusinessCase(final BusinessCase businessCase) {
        if (businessCase.getId() != null) {
            businessCase.setId(counter);
        }
        List<BusinessCase> businessCasesForId = businessCasesMap.get(businessCase.getId());

        if (businessCasesForId == null) {
            businessCasesForId = new ArrayList<>();
        }

        businessCasesForId.add(businessCase);
        businessCasesMap.put(businessCase.getId(), businessCasesForId);
        counter++;
    }

    public static List<BusinessCase> getBusinessCase(Integer id) {
        return businessCasesMap.get(id);
    }

}
