package cloud.frizio.dev.demospringbootbasiccrud.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController {

  @GetMapping("/hello")
  public String sayHello(Model model) {
    model.addAttribute("currentDate", new Date());
    return "index";
  }

}