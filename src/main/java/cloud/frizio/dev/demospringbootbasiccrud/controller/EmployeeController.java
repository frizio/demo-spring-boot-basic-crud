package cloud.frizio.dev.demospringbootbasiccrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model) {
    Employee employee = new Employee();
    model.addAttribute("employee", employee);
    return "employees/employee-form";
  }

  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    // Save
    this.employeeService.save(employee);
    // Redirect to prevent duplicate submission
    return "redirect:/employees/list";
  }

  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("id") int id, Model model) {
    // Get employee from the service
    Employee employee = this.employeeService.findById(id);
    // Pre populate the form
    model.addAttribute("employee", employee);
    // Send to the form
    return "employees/employee-form";
  }

}