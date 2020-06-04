package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatType = petTypeService.save(cat);


        System.out.println("################################### hallo");

        Owner owner1 = new Owner();

        owner1.setFirstName("Jochen");
        owner1.setLastName("Greiner");
        owner1.setAddress("Mühltasltr 99");
        owner1.setCity("Heidelberg");
        owner1.setTelephone("+49123456");

        Pet jochensDog = new Pet();
        jochensDog.setPetType(savedDogType);
        jochensDog.setOwner(owner1);
        jochensDog.setName("WauWau");
        jochensDog.setBirthDate(LocalDate.now());

        owner1.getPets().add(jochensDog);

        Pet jochensCat = new Pet();
        jochensCat.setPetType(savedCatType);
        jochensCat.setOwner(owner1);
        jochensCat.setName("MiauMiau");
        jochensCat.setBirthDate(LocalDate.now());

        owner1.getPets().add(jochensCat);

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Jochen2");
        owner2.setLastName("Greiner2");
        owner2.setAddress("Mühltasltr 120");
        owner2.setCity("Heidelberg");
        owner2.setTelephone("+49125653456");

        Pet jochen2sCat = new Pet();
        jochen2sCat.setPetType(savedCatType);
        jochen2sCat.setOwner(owner1);
        jochen2sCat.setName("MiauMiau2222");
        jochen2sCat.setBirthDate(LocalDate.now());

        owner2.getPets().add(jochen2sCat);

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
