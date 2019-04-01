package de.api.details;

import de.api.details.model.*;
import de.api.details.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.*;

@SpringBootApplication
public class Application extends SpringBootServletInitializer
        implements CommandLineRunner {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private ParentSummaryRepository parentSummaryRepository;


    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    public static void main(String args[]) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {

        //Clear all db data
        mealRepository.deleteAllInBatch();
        childRepository.deleteAllInBatch();
        houseRepository.deleteAllInBatch();
        parentRepository.deleteAllInBatch();


        //creating a parent instance

        Parent parent = new Parent("John",31);

            House house = new House("Dahlem","14195", HouseType.HOUSE);

        Child daughter = new Daughter("Freya",2,"Pink");
        Child son = new Son("Treya",1,"Blue");

        Set<Child> childSet = new HashSet<>();
        childSet.add(daughter);
        childSet.add(son);

        Meal meal1 = new Meal("Noodles",new Date());
        Meal meal2 = new Meal("Chips",new Date());

        Meal meal3 = new Meal("Chocolate",new Date());
        Meal meal4 = new Meal("Ice Cream",new Date());

        Set<Meal> mealSet1 = new HashSet<>();
        mealSet1.add(meal1);
        mealSet1.add(meal2);

        Set<Meal> mealSet2 = new HashSet<>();
        mealSet2.add(meal3);
        mealSet2.add(meal4);

        parent.setHouse(house);

        house.setParent(parent);

        parent.setChild(childSet);

        daughter.setParent(parent);
        son.setParent(parent);

        daughter.setMeal(mealSet1);
        son.setMeal(mealSet2);

        meal1.setChild(daughter);
        meal2.setChild(daughter);

        meal3.setChild(son);
        meal4.setChild(son);



        parentRepository.save(parent);

        ParentSummary parentSummary = new ParentSummary();
        parentSummaryRepository.save(parentSummary);


    }

}
