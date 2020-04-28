package lab2.sw2.Controller;
import lab2.sw2.Entity.DepartmentsEntity;

import lab2.sw2.Entity.LocationsEntity;
import lab2.sw2.Repository.DepartmentsRepository;
import lab2.sw2.Repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Department")
public class DepartmentsController {



    @Autowired
    DepartmentsRepository departmentsRepository;
    @Autowired
    LocationsRepository locationsRepository;
    @GetMapping(value = {"","/ListaDep"})
    public String listar(Model model){
        List<DepartmentsEntity> listaDep = departmentsRepository.findAll();
        List<LocationsEntity> listaLoc = locationsRepository.findAll();
        model.addAttribute("listaDep", listaDep);
        model.addAttribute("listaLoc", listaLoc);
        return "Department/DepTabla";
    }



    @GetMapping("/agregar")
    public String agregar(){ return "Department/agregar"; }

    @PostMapping("/guardar")
    public String guardar(DepartmentsEntity departments, RedirectAttributes redirectAttributes){
        if(departments.getDepartment_id()==0){
            List<DepartmentsEntity>listaActual = departmentsRepository.findAll();
            departments.setDepartment_id((listaActual.size()*10)+10);
            redirectAttributes.addFlashAttribute("mensaje","Departamento Creado Exitosamente");
        }
        else
        {
            redirectAttributes.addFlashAttribute("mensaje","Departamento Actualizado Exitosamente");
        }
        departmentsRepository.save(departments);
        return "redirect:/Department/";
    }

    @GetMapping("/editar")
    public String editar(){
        
        return "";
    }

    @GetMapping("/delete")
    public String deleteDepartment(@RequestParam("id") int id,
                                 RedirectAttributes attr){


        Optional<DepartmentsEntity> optDepartment = departmentsRepository.findById(id);

        if (optDepartment.isPresent()) {
            departmentsRepository.deleteById(id);
            attr.addFlashAttribute("msg","Department borrado exitosamente");
        }
        return "redirect:/Department/";

    }




}
