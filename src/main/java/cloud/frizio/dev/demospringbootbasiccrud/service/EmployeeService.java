package cloud.frizio.dev.demospringbootbasiccrud.service;

import java.util.List;

import cloud.frizio.dev.demospringbootbasiccrud.entity.Employee;


public interface EmployeeService {

  public List<Employee> findAll();

  public Employee findById(int id);

  public void save(Employee employee);

  public void deleteById(int id);

}
