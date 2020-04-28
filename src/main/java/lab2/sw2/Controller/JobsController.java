package lab2.sw2.Controller;
import lab2.sw2.Entity.JobsEntity;
import lab2.sw2.Entity.LocationsEntity;
import lab2.sw2.Repository.JobsRepository;
import lab2.sw2.Repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobsController {

    @Autowired
    JobsRepository jobsRepository;

    @GetMapping("/listaJ")
    public String listaJob(Model model){
        List<JobsEntity> lista_job = jobsRepository.findAll();
        model.addAttribute("listaj",lista_job);
        return "job/lista";
    }


}
