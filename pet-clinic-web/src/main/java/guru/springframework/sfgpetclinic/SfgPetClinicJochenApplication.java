package guru.springframework.sfgpetclinic;

import guru.springframework.sfgpetclinic.model.FakeData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SfgPetClinicJochenApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(SfgPetClinicJochenApplication.class, args);

        FakeData fd = app.getBean(FakeData.class);

        System.out.println(fd.getUsername());
    }

}
