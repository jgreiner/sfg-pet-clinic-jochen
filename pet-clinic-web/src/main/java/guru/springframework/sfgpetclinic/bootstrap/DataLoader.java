package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("################################### hallo");

        Owner owner1 = new Owner();

        owner1.setFirstName("Jochen");
        owner1.setLastName("Greiner");

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Jochen2");
        owner2.setLastName("Greiner2");

        ownerService.save(owner2);

        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Vettr");

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("oxel");
        vet2.setLastName("Vettr2");

        vetService.save(vet2);

        Vet vet3 = new Vet();

        vet3.setFirstName("peter");
        vet3.setLastName("Vetteranias");

        vetService.save(vet3);




    }
}
