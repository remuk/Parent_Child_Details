package de.api.test;

import de.api.details.controller.RestAPIController;
import de.api.details.model.*;
import de.api.details.service.ChildListingService;
import de.api.details.service.HouseListingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestRestApiController {

    private MockMvc mockMvc;

    @InjectMocks
    private RestAPIController restController;

    @MockBean
    private HouseListingService houseListingService;

    @MockBean
    private ChildListingService childListingService;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(restController)
                .build();
    }

    /*
     * to test - /house/{ParentName}
     */
    @Test
    public void testgetHouseDetails() throws Exception {

        Parent parent = new Parent("Prateek",31);
        parent.setHouse(new House("paschim vihar","110063", HouseType.HOUSE));

        List<Parent> parents = new ArrayList<>();
        parents.add(parent);

        when(houseListingService.getHouseDetailsByParentname(anyString())).thenReturn(parents);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/house/Prateek"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Address").value("paschim vihar"));
    }

    /*
     * to test - /child/info/{childName}
     */
    @Test
    public void testgetChildMealDetails() throws Exception {

        Parent parent = new Parent("Prateek",31);
        Child daughter = new Daughter("Freya",2,"Pink");
        Meal meal1 = new Meal("Maggie",new Date());
        Set<Meal> mealSet = new LinkedHashSet<>();
        mealSet.add(meal1);
        daughter.setParent(parent);
        daughter.setMeal(mealSet);

        List<Child> childList = new ArrayList<>();
        childList.add(daughter);

        when(childListingService.getDetailsByChildName(anyString())).thenReturn(childList);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/child/info/Freya"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Parent_Name").value("Prateek"))
                .andExpect(jsonPath("$.Favourite_Meal").value("Maggie"));
    }

    /*
     * to test - /color/{childName}"
     */
    @Test
    public void testgetChildColorDetails() throws Exception {

        Parent parent = new Parent("Prateek",31);
        Child daughter = new Daughter("Freya",2,"Pink");
        Meal meal1 = new Meal("Maggie",new Date());
        Set<Meal> mealSet = new LinkedHashSet<>();
        mealSet.add(meal1);
        daughter.setParent(parent);
        daughter.setMeal(mealSet);

        List<Child> childList = new ArrayList<>();
        childList.add(daughter);

        when(childListingService.getDetailsByChildName(anyString())).thenReturn(childList);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/color/Freya"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Hair_Color").value("Pink"));
    }


}
