package lab2.sw2.Controller;
import lab2.sw2.Entity.EmployeesEntity;
import lab2.sw2.Repository.EmployeesRepository;
import lab2.sw2.Repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeesController {

    @Autowired
    EmployeesRepository employeeRepository;

    @Autowired
    JobsRepository jobRepository;


    @GetMapping("")
    public String listEmployee(Model model){
        List<EmployeesEntity> lista = employeeRepository.findAll();
        model.addAttribute("listaEmployee",lista);
        return "Employee/list";
    }


    @GetMapping("/new")
    public String newEmployee(Model model){
        model.addAttribute("listaJob",jobRepository.findAll());
        return "Employee/newForm";
    }


    @PostMapping("/save")
    public String saveEmployee(EmployeesEntity employee,
                               RedirectAttributes attr){

        if (employee.getEmployee_id() != null){
            attr.addFlashAttribute("msg", "Actualizado exitosamente");
        }else {
            attr.addFlashAttribute("msg","Creado exitosamente");
        }
        employeeRepository.save(employee);

        return "redirect:/employee/";
    }

    @GetMapping("/edit")
    public String editEmployee(Model model,
                               @RequestParam("id") String id){
        Optional<EmployeesEntity> optEmployee = employeeRepository.findById(id);
        if(optEmployee.isPresent()){
            EmployeesEntity employee = optEmployee.get();
            model.addAttribute("employee",employee);
        }else{
            return "redirect:";
        }

        return "Employee/editForm";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") String id,
                                 RedirectAttributes attr){

        Optional<EmployeesEntity> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            employeeRepository.deleteById(id);
            attr.addFlashAttribute("msg","Empleado borrado exitosamente");
        }
        return "redirect:/employee/";

    }

}
