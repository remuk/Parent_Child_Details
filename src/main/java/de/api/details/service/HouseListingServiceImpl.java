package de.api.details.service;

import de.api.details.model.Parent;
import de.api.details.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HouseListingServiceImpl implements HouseListingService{

    @Autowired
    private ParentRepository parentRepository;

    public List<Parent> getHouseDetailsByParentname(String parentName) {

        List<Parent> parents = parentRepository
                                    .findParentByparentName(parentName);

        return parents;
    }
}
