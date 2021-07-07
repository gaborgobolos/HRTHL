package hu.webuni.spring.hrtl.gg.web;

import hu.webuni.spring.hrtl.gg.dto.EmployeeDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private Map<Long,EmployeeDto> employees=new HashMap<>();
    {
     employees.put(1L,new EmployeeDto(1L,"abc","kkt",200000,LocalDate.now()));
     employees.put(2L,new EmployeeDto(2L,"def","kft",500000,LocalDate.now()));
    }
    @GetMapping
    public List<EmployeeDto> getAll(){
      return new ArrayList<>(employees.values());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable long id){
       EmployeeDto employeeDto=employees.get(id);
       if(employeeDto!=null)
               return ResponseEntity.ok(employeeDto);
       else 
           return ResponseEntity.notFound().build();
    }
    @PostMapping
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
     employees.put(employeeDto.getId(), employeeDto);
     return employeeDto;
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> modifyEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto){
     if(!employees.containsKey(id)){
      return ResponseEntity.notFound().build();
     }
     employeeDto.setId(id);
     employees.put(id, employeeDto);
     return ResponseEntity.ok(employeeDto);
    }
    public void deleteEmployee(@PathVariable long id){
     employees.remove(id);
    }
    
    
}
