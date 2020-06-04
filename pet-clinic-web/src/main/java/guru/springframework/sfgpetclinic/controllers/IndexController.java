package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.FakePersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final FakePersonService fakePersonService;

    public IndexController(FakePersonService fakePersonService) {
        this.fakePersonService = fakePersonService;
    }

    @RequestMapping({"","/","index.html","index"})
    public String index(Model model){

        model.addAttribute("person", fakePersonService.get());
        return "index";
    }
}
