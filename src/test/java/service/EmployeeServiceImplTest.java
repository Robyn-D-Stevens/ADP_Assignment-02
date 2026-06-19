package service;

import domain.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
  EmployeeServiceImplTest.java
  EmployeeServiceImplTest class
  Author: Robyn Dominique Stevens (222201789)
  Date: 19 June 2026
*/

class EmployeeServiceImplTest {

    EmployeeServiceImpl employeeServiceImpl;

    @BeforeEach
    void setUp() {
        employeeServiceImpl = EmployeeServiceImpl.getService();
    }

    @Test
    void testGetService() {
        EmployeeServiceImpl result = EmployeeServiceImpl.getService();
        assertNotNull(result);
        assertSame(employeeServiceImpl, result);
    }

    @Test
    void testCreate() {

        Employee employee = new Employee.Builder()
                .setEmpId("EMP1001")
                .setFName("Karabo")
                .setLName("Modise")
                .setSalary(8500.00)
                .setEmail("KaraboM@gmail.com")
                .setPhone("0712345678")
                .setRole("IT Intern")
                .setEmpStatus(Employee.EmpStatus.ACTIVE)
                .build();

        Employee result = employeeServiceImpl.create(employee);

        assertNotNull(result);
        assertEquals("EMP1001", result.getEmpID());
    }

    @Test
    void testRead() {

        Employee employee = new Employee.Builder()
                .setEmpId("EMP1002")
                .setFName("Megan")
                .setLName("Botha")
                .setSalary(8500.00)
                .setEmail("MeganB@gmail.com")
                .setPhone("0723456789")
                .setRole("IT Intern")
                .setEmpStatus(Employee.EmpStatus.ACTIVE)
                .build();

        employeeServiceImpl.create(employee);

        Employee result = employeeServiceImpl.read("EMP1002");

        assertNotNull(result);
        assertEquals("Megan", result.getFName());
    }

    @Test
    void testUpdate() {

        Employee employee = new Employee.Builder()
                .setEmpId("EMP1003")
                .setFName("Tumelo")
                .setLName("Khumalo")
                .setSalary(8500.00)
                .setEmail("TumeloK@gmail.com")
                .setPhone("0734567890")
                .setRole("IT Intern")
                .setEmpStatus(Employee.EmpStatus.ACTIVE)
                .build();

        employeeServiceImpl.create(employee);

        Employee updated = new Employee.Builder()
                .setEmpId("EMP1003")
                .setFName("Tumelo")
                .setLName("Khumalo")
                .setSalary(8500.00)
                .setEmail("TumeloK@gmail.com")
                .setPhone("0734567890")
                .setRole("Junior Developer")
                .setEmpStatus(Employee.EmpStatus.ACTIVE)
                .build();

        Employee result = employeeServiceImpl.update(updated);

        assertNotNull(result);
        assertEquals("Junior Developer", result.getRole());
    }

    @Test
    void testDelete() {

        Employee employee = new Employee.Builder()
                .setEmpId("EMP1004")
                .setFName("Bongani")
                .setLName("Zulu")
                .setSalary(8500.00)
                .setEmail("BonganiZ@gmail.com")
                .setPhone("0745678901")
                .setRole("IT Intern")
                .setEmpStatus(Employee.EmpStatus.ACTIVE)
                .build();

        employeeServiceImpl.create(employee);

        boolean result = employeeServiceImpl.delete("EMP1004");

        assertTrue(result);
    }

    @Test
    void testGetAll() {

        Employee employee = new Employee.Builder()
                .setEmpId("EMP1005")
                .setFName("Refilwe")
                .setLName("Mahlangu")
                .setSalary(8500.00)
                .setEmail("RefilweM@gmail.com")
                .setPhone("0756789012")
                .setRole("IT Intern")
                .setEmpStatus(Employee.EmpStatus.ACTIVE)
                .build();

        employeeServiceImpl.create(employee);

        Set<Employee> result = employeeServiceImpl.getAll();

        assertNotNull(result);
        assertTrue(result.contains(employee));
    }
}
