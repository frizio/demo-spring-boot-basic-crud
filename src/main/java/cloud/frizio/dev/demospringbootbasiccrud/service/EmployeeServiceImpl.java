package cloud.frizio.dev.demospringbootbasiccrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.frizio.dev.demospringbootbasiccrud.dao.EmployeeRepository;
import cloud.frizio.dev.demospringbootbasiccrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> findAll() {
    return this.employeeRepository.findAllByOrderByLastNameAsc();
  }

  @Override
  public Employee findById(int id) {
    Optional<Employee> result = this.employeeRepository.findById(id);;
    Employee employee = null;
    if (result.isPresent()) {
      employee = result.get();
    } else {
      throw new RuntimeException("Employee not found with id: " + id);
    }
    return employee;
  }

  @Override
  @Transactional
  public void save(Employee employee) {
    this.employeeRepository.save(employee);
  }

  @Override
  @Transactional
  public void deleteById(int id) {
    this.employeeRepository.deleteById(id);
  }

  
}