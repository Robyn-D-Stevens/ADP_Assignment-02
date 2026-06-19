package factory;

import domain.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
  EmployeeFactoryTest.java
  EmployeeFactoryTest class
  Author: Robyn Dominique Stevens (222201789)
  Date: 19 June 2026
*/

class EmployeeFactoryTest {

    @Test
    void createEmployee() {

        Employee employee = EmployeeFactory.createEmployee(
                "Thandiwe",
                "Mokoena",
                8500.00,
                "ThandiweM@gmail.com",
                "0721234567",
                "IT Intern"
        );

        assertNotNull(employee);
        assertNotNull(employee.getEmpID());
        assertEquals("Thandiwe", employee.getFName());
        assertEquals("Mokoena", employee.getLName());
        assertEquals(8500.00, employee.getSalary());
        assertEquals("ThandiweM@gmail.com", employee.getEmail());
        assertEquals("0721234567", employee.getPhone());
        assertEquals("IT Intern", employee.getRole());
        assertEquals(Employee.EmpStatus.ACTIVE, employee.getEmpStatus());
    }

    @Test
    void createEmployee_generatesUniqueIds() {

        Employee first = EmployeeFactory.createEmployee(
                "Sipho", "Nkosi", 8500.00, "SiphoN@gmail.com", "0739876543", "IT Intern"
        );

        Employee second = EmployeeFactory.createEmployee(
                "Annelie", "van der Merwe", 8500.00, "AnnelieVDM@gmail.com", "0845551234", "IT Intern"
        );

        assertNotEquals(first.getEmpID(), second.getEmpID());
    }
}
