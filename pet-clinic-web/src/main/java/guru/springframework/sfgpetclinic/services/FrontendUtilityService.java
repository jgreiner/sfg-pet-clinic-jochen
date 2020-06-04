package guru.springframework.sfgpetclinic.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FrontendUtilityService {

    public String getRandomColor() {
        Random obj = new Random();
        int randNum = obj.nextInt(0xffffff + 1);
        return String.format("#%06x", randNum);
    }
}
