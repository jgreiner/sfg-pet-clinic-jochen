package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.FrontendUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public abstract class AbstractController {

    @Autowired
    public FrontendUtilityService frontendUtilityService;

    public String getColor() {
        return frontendUtilityService.getRandomColor();
    }

}
