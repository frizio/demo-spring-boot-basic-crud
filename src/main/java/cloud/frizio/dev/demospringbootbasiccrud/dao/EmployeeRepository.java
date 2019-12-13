package cloud.frizio.dev.demospringbootbasiccrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cloud.frizio.dev.demospringbootbasiccrud.entity.Employee;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  // that's it for simple CRUD methods!!!!

  // Use JPQL "from Employee order by lastName asc"
  public List<Employee> findAllByOrderByLastNameAsc();
  
}