package cloud.frizio.dev.demospringbootbasiccrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

  private int id;
  private String firstName;
  private String lastName;
  private String email;
  
}
