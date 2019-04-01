package de.api.details.service;

import de.api.details.model.Parent;
import java.util.List;


public interface HouseListingService {

    List<Parent> getHouseDetailsByParentname(String parentName);

}
