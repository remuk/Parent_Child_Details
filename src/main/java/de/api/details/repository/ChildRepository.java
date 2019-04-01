package de.api.details.repository;

import de.api.details.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child,Long> {

    List<Child> findChildBychildName(String childName);
}
