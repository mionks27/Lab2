package lab2.sw2.Controller;
import lab2.sw2.Entity.DepartmentsEntity;
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
<<<<<<< HEAD
=======
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
>>>>>>> e6036960f8771565601ee6186a41aceb48c567e2

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

    @GetMapping("/delete")
    public String deleteJobs(@RequestParam("id") String id,
                                   RedirectAttributes attr){


        Optional<JobsEntity> optJobs = jobsRepository.findById(id);

        if (optJobs.isPresent()) {
            jobsRepository.deleteById(id);
            attr.addFlashAttribute("msg","Department borrado exitosamente");
        }
        return "redirect:/job/listaJ";

    }
}
