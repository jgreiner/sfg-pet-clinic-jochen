package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    Long ownerId = 1L;
    String lastName = "Greiner";

    @BeforeEach
    void setUp() {

        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        Owner o = new Owner();
        o.setLastName(lastName);
        o.setId(ownerId);

        ownerMapService.save(o);
    }

    @Test
    void findAll() {

        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void save() {

        Owner owner = new Owner();
        owner.setId(2L);
        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(savedOwner.getId(), 2L);


    }

    @Test
    void saveNoId() {

        Owner owner = new Owner();

        Owner savedOwner = ownerMapService.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());


    }

    @Test
    void findById() {
        Owner o = ownerMapService.findById(ownerId);
        assertEquals(ownerId, o.getId());

    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }
}
