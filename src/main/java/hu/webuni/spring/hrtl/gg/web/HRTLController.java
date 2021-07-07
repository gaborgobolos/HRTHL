package hu.webuni.spring.hrtl.gg.web;

import hu.webuni.spring.hrtl.gg.dto.EmployeeDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HRTLController {
   private List<EmployeeDto> allEmployees = new ArrayList<>();
   {
   allEmployees.add(new EmployeeDto(1L, "Pista", "manager", 300000, LocalDate.parse("2002-10-20")));
   allEmployees.add(new EmployeeDto(2L, "Lajos", "manager", 400000, LocalDate.parse("2005-12-03")));
   allEmployees.add(new EmployeeDto(3L, "Jenő", "manager", 500000, LocalDate.parse("2002-06-10")));
   }
   
   @GetMapping("/")
    public String home(){
      return "index";
    }
    @GetMapping("/employees")
    public String listEmployees(Map<String, Object> model){
    model.put("employees",allEmployees);
    int hossz=allEmployees.size();
    long id=allEmployees.get(hossz-1).getId()+1;
    model.put("newEmployee", new EmployeeDto(id,"","",0,LocalDate.now()));
    return "employees";
    }
    @PostMapping("/employees")
    public String addEmployee(EmployeeDto employeeDto){
      allEmployees.add(employeeDto);
      return "redirect:employees";
    }
}
