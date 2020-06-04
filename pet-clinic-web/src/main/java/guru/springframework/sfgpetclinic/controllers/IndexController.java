package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.impl.FakePersonServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final FakePersonServiceImpl fakePersonServiceImpl;

    public IndexController(FakePersonServiceImpl fakePersonServiceImpl) {
        this.fakePersonServiceImpl = fakePersonServiceImpl;
    }

    @RequestMapping({"","/","index.html","index"})
    public String index(Model model){

        model.addAttribute("person", fakePersonServiceImpl.get());
        return "index";
    }
}
