package de.api.details.repository;

import de.api.details.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Long>{

    List<Parent> findParentByparentName(String parentName);
}
