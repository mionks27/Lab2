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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @GetMapping("/nuevo")
    public String nuevoJob(){
        return "job/newForm";
    }

    @PostMapping("/guardar")
    public String guardar(JobsEntity joobs, RedirectAttributes redirectAttributes) {
        if (joobs.getJob_id() != null) {
            if (joobs.getMin_salary() > 0 && joobs.getMax_salary() > 0) {
                redirectAttributes.addFlashAttribute("mensaje", "JOB Creado Exitosamente");
                jobsRepository.save(joobs);
                return "redirect:/listaJ";
            }
        } else {
            redirectAttributes.addFlashAttribute("mensaje", "JOB Actualizado Exitosamente");
        }
        jobsRepository.save(joobs);
        return "redirect:/listaJ";
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
