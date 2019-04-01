package de.api.details.controller;

import de.api.details.model.*;
import de.api.details.service.ChildListingService;
import de.api.details.service.HouseListingService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/")
public class RestAPIController {


    @Autowired
    private HouseListingService houseListingService;

    @Autowired
    private ChildListingService childListingService;

    @RequestMapping(value = "/house/{parentName}",method = RequestMethod.GET)
    public Map<String,String> getHouseDetails(@PathVariable("parentName") String parentName) {

        List<Parent> houseDetails =
                houseListingService.getHouseDetailsByParentname(parentName);

        Map<String,String> returnResult = new HashMap<>();
        if(!CollectionUtils.isEmpty(houseDetails)) {
            returnResult.put("Parent_Name", houseDetails.get(0).getParentName());
            returnResult.put("Parent_Age", houseDetails.get(0).getParentAge().toString());
            returnResult.put("Address", houseDetails.get(0).getHouse().getAddress());
            returnResult.put("Zip_Code", houseDetails.get(0).getHouse().getZipCode());
            returnResult.put("House_Type", houseDetails.get(0).getHouse().getHouseType().toString());
        }

        return returnResult;

    }

    @RequestMapping("/child/info/{childName}")
    public Map<String,String> getChildMealDetails(@PathVariable("childName") String childName) {

        List<Child> childDetails =
                childListingService.getDetailsByChildName(childName);

        Map<String,String> returnResult = new HashMap<>();
        if(!CollectionUtils.isEmpty(childDetails)) {
            returnResult.put("Child_Name", childDetails.get(0).getChildName());
            returnResult.put("Child_Age", childDetails.get(0).getChildAge().toString());
            returnResult.put("Parent_Name", childDetails.get(0).getParent().getParentName());
            returnResult.put("Parent_Age", childDetails.get(0).getParent().getParentAge().toString());

            Set<Meal> meals = new HashSet<>();
            meals = childDetails.get(0).getMeal();
            Iterator<Meal> iterator = meals.iterator();

            returnResult.put("Favourite_Meal", iterator.next().getMealname());
        }

        return returnResult;
    }

    @RequestMapping("/color/{childName}")
    public Map<String,String> getChildColorDetails(@PathVariable("childName") String childName) {

        List<Child> childDetails =
                childListingService.getDetailsByChildName(childName);

        Map<String,String> returnResult = new HashMap<>();
        childDetails.forEach(p->{
            if (p instanceof Son)
                returnResult.put("Bicycle_Color",((Son) p).getBicycleColor());
            else
                returnResult.put("Hair_Color",((Daughter) p).getHairColor());
        });

        return returnResult;

    }

    @RequestMapping("/persons/children/{n}")
    public Map<String,String> fetchCountOfChildren(@PathVariable("n") String nValue) {


        Integer valueTopass = nValue !=null ?
                Integer.parseInt(nValue) : null;

       Integer result = childListingService.fetchCountOfChildren(valueTopass);

       Map<String,String> resultToReturn = new HashMap<>();

       resultToReturn.put("amountOfPerson",result.toString());
       resultToReturn.put("amountOfChildren",nValue);


        return resultToReturn;

    }

}
