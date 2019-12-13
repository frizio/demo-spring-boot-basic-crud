package cloud.frizio.dev.demospringbootbasiccrud.dao;

import java.util.List;

import cloud.frizio.dev.demospringbootbasiccrud.entity.Employee;

public interface EmployeeDAO {

  public List<Employee> findAll();

  public Employee findById(int id);

  public void save(Employee employee);

  public void deleteById(int id);
  
}