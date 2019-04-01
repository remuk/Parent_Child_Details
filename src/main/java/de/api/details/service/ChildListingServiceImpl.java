package de.api.details.service;

import de.api.details.model.Child;
import de.api.details.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChildListingServiceImpl implements ChildListingService{

    @Autowired
    ChildRepository childRepository;

    public List<Child> getDetailsByChildName(String childName) {

        List<Child> childList = childRepository.findChildBychildName(childName);

        return childList;
    }
}
