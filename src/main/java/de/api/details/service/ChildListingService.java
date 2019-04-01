package de.api.details.service;

import de.api.details.model.Child;

import java.util.List;

public interface ChildListingService {

    List<Child> getDetailsByChildName(String childName);

    Integer fetchCountOfChildren(Integer n);
}
