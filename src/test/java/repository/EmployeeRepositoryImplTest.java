package repository;

import domain.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
  EmployeeRepositoryImplTest.java
  EmployeeRepositoryImplTest class
  Author: Robyn Dominique Stevens (222201789)
  Date: 19 June 2026
*/

class EmployeeRepositoryImplTest {

    @Test
    void create() {

        Employee employee = new Employee.Builder()
                .setEmpId("EMP0001")
                .setFName("Lindiwe")
                .setLName("Dlamini")
                .setSalary(8500.00)
                .setEmail("LindiweD@gmail.com")
                .setPhone("0823456789")
                .setRole("IT Intern")
                .setEmpStatus(Employee.EmpStatus.ACTIVE)
                .build();

        EmployeeRepository repo = EmployeeRepositoryImpl.getRepository();

        Employee saved = repo.create(employee);

        assertEquals("EMP0001", saved.getEmpID());
    }

    @Test
    void read() {

        EmployeeRepository repo = EmployeeRepositoryImpl.getRepository();

        Employee employee = repo.read("EMP0001");

        if (employee != null) {
            assertEquals("EMP0001", employee.getEmpID());
        }
    }

    @Test
    void update() {

        EmployeeRepository repo = EmployeeRepositoryImpl.getRepository();

        Employee employee = new Employee.Builder()
                .setEmpId("EMP0002")
                .setFName("Johan")
                .setLName("Pretorius")
                .setSalary(8500.00)
                .setEmail("JohanP@gmail.com")
                .setPhone("0834567890")
                .setRole("IT Intern")
                .setEmpStatus(Employee.EmpStatus.ACTIVE)
                .build();

        repo.create(employee);

        Employee updated = new Employee.Builder()
                .setEmpId("EMP0002")
                .setFName("Johan")
                .setLName("Pretorius")
                .setSalary(9000.00)
                .setEmail("JohanP@gmail.com")
                .setPhone("0834567890")
                .setRole("IT Intern")
                .setEmpStatus(Employee.EmpStatus.ACTIVE)
                .build();

        Employee result = repo.update(updated);

        assertNotNull(result);
        assertEquals(9000.00, result.getSalary());
    }

    @Test
    void delete() {

        EmployeeRepository repo = EmployeeRepositoryImpl.getRepository();

        Employee employee = new Employee.Builder()
                .setEmpId("EMP0003")
                .setFName("Naledi")
                .setLName("Sithole")
                .setSalary(8500.00)
                .setEmail("NalediS@gmail.com")
                .setPhone("0845678901")
                .setRole("IT Intern")
                .setEmpStatus(Employee.EmpStatus.ACTIVE)
                .build();

        repo.create(employee);

        boolean result = repo.delete("EMP0003");

        assertTrue(result);
        assertNull(repo.read("EMP0003"));
    }
}
