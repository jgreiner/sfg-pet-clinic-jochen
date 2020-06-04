package guru.springframework.sfgpetclinic.services;

import com.github.javafaker.Faker;
import guru.springframework.sfgpetclinic.model.FakePerson;
import guru.springframework.sfgpetclinic.repositories.FakePersonRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class FakePersonService implements FakePersonRepository {

    public FakePerson get() {

        Faker faker = new Faker(Locale.GERMAN);
        String name = faker.name().fullName();
        String address = faker.address().streetAddress();
        String city = faker.address().cityName();

        FakePerson person = new FakePerson();
        person.setName(name);
        person.setAddress(address);
        person.setCity(city);

        return person;

    }
}
