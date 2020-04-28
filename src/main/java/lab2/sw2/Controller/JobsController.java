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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/new")
    public String newEmployee(Model model){
        model.addAttribute("job",jobsRepository.findAll());
        return "job/newForm";
    }

    @GetMapping("/editar")
    public String editEmployee( Model model, @RequestParam("id") String id
                                ){
        Optional<JobsEntity> job = jobsRepository.findById(id);
        if (job.isPresent()){
            JobsEntity job2 = job.get();
            model.addAttribute("job",job2);
        }
        return "job/editForm";
    }

}
