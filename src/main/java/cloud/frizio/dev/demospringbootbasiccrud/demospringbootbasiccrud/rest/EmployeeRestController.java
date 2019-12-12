package cloud.frizio.dev.demospringbootbasiccrud.demospringbootbasiccrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.frizio.dev.demospringbootbasiccrud.demospringbootbasiccrud.entity.Employee;
import cloud.frizio.dev.demospringbootbasiccrud.demospringbootbasiccrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeService employeeService;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  // Expose "/employees" and return list of Employees
  @GetMapping("/employees")
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

}