package cloud.frizio.dev.demospringbootbasiccrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.frizio.dev.demospringbootbasiccrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  // that's it for simple CRUD methods!!!!
  
}