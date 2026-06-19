package service;

import domain.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

import java.util.Set;

/*
  EmployeeServiceImpl.java
  EmployeeServiceImpl class
  Author: Robyn Dominique Stevens (222201789)
  Date: 19 June 2026
*/

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository = EmployeeRepositoryImpl.getRepository();

    private static EmployeeServiceImpl service = null;

    private EmployeeServiceImpl() {}

    public static EmployeeServiceImpl getService() {
        if (service == null) {
            service = new EmployeeServiceImpl();
        }
        return service;
    }

    @Override
    public Employee create(Employee entity) {
        return repository.create(entity);
    }

    @Override
    public Employee read(String id) {
        return repository.read(id);
    }

    @Override
    public Employee update(Employee entity) {
        return repository.update(entity);
    }

    @Override
    public boolean delete(String id) {
        return repository.delete(id);
    }

    @Override
    public Set<Employee> getAll() {
        return repository.getAll();
    }
}