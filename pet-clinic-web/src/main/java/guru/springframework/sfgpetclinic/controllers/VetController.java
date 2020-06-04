package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class VetController extends AbstractController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());
        model.addAttribute("color", getColor());
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("lastUpdate", now.getHour() + "h" + now.getMinute() + ":" + now.getSecond());

        return "vets/index";
    }


}
