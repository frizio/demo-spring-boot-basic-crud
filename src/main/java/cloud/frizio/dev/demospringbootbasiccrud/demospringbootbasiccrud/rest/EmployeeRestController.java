package cloud.frizio.dev.demospringbootbasiccrud.demospringbootbasiccrud.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.frizio.dev.demospringbootbasiccrud.demospringbootbasiccrud.dao.EmployeeDAO;
import cloud.frizio.dev.demospringbootbasiccrud.demospringbootbasiccrud.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeDAO employeeDAO;

  // Inject Employee DAO (Dirty)
  public EmployeeRestController(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  // Expose "/employees" and return list of Employees
  @GetMapping("/employees")
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

}