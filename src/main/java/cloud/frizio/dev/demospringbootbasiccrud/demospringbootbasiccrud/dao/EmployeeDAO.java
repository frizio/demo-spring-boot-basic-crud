package cloud.frizio.dev.demospringbootbasiccrud.demospringbootbasiccrud.dao;

import java.util.List;

import cloud.frizio.dev.demospringbootbasiccrud.demospringbootbasiccrud.entity.Employee;

public interface EmployeeDAO {

  public List<Employee> findAll();
  
}