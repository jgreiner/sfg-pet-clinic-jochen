package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJpaService ownerJpaService;

    private final String lastName = "Smith";

    private Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setLastName(lastName);
        owner.setId(1L);
    }

    @Test
    void findByLastName() {


        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner smith = ownerJpaService.findByLastName(lastName);
        assertEquals(lastName, smith.getLastName());
    }

    @Test
    void findAll() {

        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> owners2 = ownerJpaService.findAll();
        assertNotNull(owners2);
        assertEquals(owners.size(), owners2.size());
    }

    @Test
    void findById() {

        when(ownerRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(owner));

        Owner smith = ownerJpaService.findById(1L);
        assertEquals(owner.getId(), smith.getId());

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner owner = ownerJpaService.findById(1L);

        assertNotNull(owner);


    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerJpaService.findById(1L);

        assertNull(owner);
    }


    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOwner = ownerJpaService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerJpaService.delete(owner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}
