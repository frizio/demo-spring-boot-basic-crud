package cloud.frizio.dev.demospringbootbasiccrud.demospringbootbasiccrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  // Read all
  @GetMapping("/employees")
  public List<Employee> readAllEmployees() {
    return employeeService.findAll();
  }

  // Read by id
  @GetMapping("/employees/{id}")
  public Employee readEmployee(@PathVariable int id) {
    Employee employee = employeeService.findById(id);
    if (employee == null) {
      throw new RuntimeException("Employee id not found " + id);
    }
    return employee;
  }

  // Create
  @PostMapping("/employees")
  public void createEmployee(@RequestBody Employee employee) {
    employee.setId(0);
    employeeService.save(employee);
  }

  // Update
  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee) {
    employeeService.save(employee);
    return employee;
  }

  // Delete by id
  @DeleteMapping("/employees/{id}")
  public String deleteEmployee(@PathVariable int id) {
    Employee employee = employeeService.findById(id);
    if (employee == null) {
      throw new RuntimeException("Employee id not found " + id);
    } 
    employeeService.deleteById(id);
    return "Deleted employee with id: " + id;
  }

}