package cloud.frizio.dev.demospringbootbasiccrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cloud.frizio.dev.demospringbootbasiccrud.entity.Employee;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  // that's it for simple CRUD methods!!!!
  
}