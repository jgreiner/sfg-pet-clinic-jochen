package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.TestUtility;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void list() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        ResultActions resultActions = TestUtility.checkControllerUrl(mockMvc, "/owners", "owners/index");
        resultActions.andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void listByIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        ResultActions resultActions = TestUtility.checkControllerUrl(mockMvc, "/owners/index", "owners/index");
        resultActions.andExpect(model().attribute("owners", hasSize(2)));
        TestUtility.checkControllerUrl(mockMvc, "/owners/index.html", "owners/index");
    }

    @Test
    void findOwner() throws Exception {
        TestUtility.checkControllerUrl(mockMvc, "/owners/find", "404");
        verifyNoMoreInteractions(ownerService);
    }



}
