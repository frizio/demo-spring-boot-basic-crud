package cloud.frizio.dev.demospringbootbasiccrud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cloud.frizio.dev.demospringbootbasiccrud.model.Employee;


@Controller
public class EmployeeController {

  private List<Employee> employees;

  // Load employee data
  @PostConstruct
  private void loadData() {
    Employee employee1 = new Employee(1, "Al", "Allen", "al@email.com");
    Employee employee2 = new Employee(2, "Bob", "Bale", "bob@email.com");
    Employee employee3 = new Employee(3, "Carl", "Carlsonn", "carl@email.com");
    this.employees = new ArrayList<>();
    this.employees.add(employee1);
    this.employees.add(employee2);
    this.employees.add(employee3);
  }

  // Mapping for /list
  @GetMapping("/list")
  public String listEmployees(Model model) {
    model.addAttribute("employees", employees);
    return "list-employees";
  }
}