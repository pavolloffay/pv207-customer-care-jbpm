package fi.muni.pv207.ticket.db;

import fi.muni.pv207.ticket.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDatabase {

    public static Map<Integer, Employee> employees = new HashMap<>();
    static {
        employees.put(1, new Employee("OPERATOR", null, 1));
        employees.put(2, new Employee("DEVELOPER", null, 2));
    }
}
