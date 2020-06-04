package guru.springframework.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Pet extends BaseEntity{

    private String name;

    private PetType petType;

    private Owner owner;

    private LocalDate birthDate;
}
