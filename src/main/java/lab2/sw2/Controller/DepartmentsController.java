package lab2.sw2.Controller;
import lab2.sw2.Entity.DepartmentsEntity;
import lab2.sw2.Entity.LocationsEntity;
import lab2.sw2.Repository.DepartmentsRepository;
import lab2.sw2.Repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
}
