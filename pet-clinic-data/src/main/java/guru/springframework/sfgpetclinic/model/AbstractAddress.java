package guru.springframework.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractAddress {


    private String address;
    private String city;
    private String zip;
    private String country;
}
