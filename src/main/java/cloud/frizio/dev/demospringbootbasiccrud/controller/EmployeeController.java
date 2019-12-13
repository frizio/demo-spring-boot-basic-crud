package cloud.frizio.dev.demospringbootbasiccrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cloud.frizio.dev.demospringbootbasiccrud.entity.Employee;
import cloud.frizio.dev.demospringbootbasiccrud.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  // Mapping for /list
  @GetMapping("/list")
  public String listEmployees(Model model) {
    List<Employee> employees = this.employeeService.findAll();
    model.addAttribute("employees", employees);
    return "employees/list-employees";
  }
}