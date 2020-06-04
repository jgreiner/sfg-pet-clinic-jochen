package guru.springframework.sfgpetclinic.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FakePerson extends AbstractAddress {

    private String name;
}
