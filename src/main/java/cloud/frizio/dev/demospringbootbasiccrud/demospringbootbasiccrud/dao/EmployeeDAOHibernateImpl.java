package cloud.frizio.dev.demospringbootbasiccrud.demospringbootbasiccrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cloud.frizio.dev.demospringbootbasiccrud.demospringbootbasiccrud.entity.Employee;


@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

  // Define field for entity manager
  private EntityManager entityManager;

  //Set up constructor injection
  public EmployeeDAOHibernateImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public List<Employee> findAll() {
    // Get the current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);
    // Create a query (using native Hibernate API)
    Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
    // Execute query and get result list
    List<Employee> employees = theQuery.getResultList();
    // Return the result
    return employees;
  }

  @Override
  public Employee findById(int id) {
    Session currentSession = entityManager.unwrap(Session.class);
    Employee employee = currentSession.get(Employee.class, id);
    return employee;
  }

  @Override
  public void save(Employee employee) {
    Session currentSession = entityManager.unwrap(Session.class);
    currentSession.saveOrUpdate(employee);
  }

  @Override
  public void deleteById(int id) {
    Session currentSession = entityManager.unwrap(Session.class);
    currentSession.createQuery("delete from Employee where id=:employeeId")
                  .setParameter("employeeId", id)
                  .executeUpdate();
  }
  
}
