package de.api.details.service;

import de.api.details.model.Child;
import de.api.details.model.ParentSummary;
import de.api.details.repository.ChildRepository;
import de.api.details.repository.ParentSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChildListingServiceImpl implements ChildListingService{

    @Autowired
    ChildRepository childRepository;

    @Autowired
    ParentSummaryRepository parentSummaryRepository;

    public List<Child> getDetailsByChildName(String childName) {

        List<Child> childList = childRepository.findChildBychildName(childName);

        return childList;
    }

    public Integer fetchCountOfChildren(Integer n) {

        Integer count = childRepository.getCountOfChildren(n);

        ParentSummary parentSummary = new ParentSummary(new Long(count),new Long(n));
        parentSummaryRepository.save(parentSummary);

        return count;
    }
}
