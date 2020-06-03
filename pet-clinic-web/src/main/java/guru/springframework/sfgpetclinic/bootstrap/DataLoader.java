package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.FakeData;
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

    private final FakeData fakeData;




    public DataLoader(OwnerService ownerService, VetService vetService, FakeData fakeData) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.fakeData = fakeData;
    }

    @Override
    public void run(String... args) {

        System.out.println(fakeData.getPassword());

        System.out.println("################################### hallo");

        System.out.println("################################### data loader 3");

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

        vet2.setFirstName("Sam2");
        vet2.setLastName("Vettr2");

        vetService.save(vet2);




    }
}
