package de.api.details.repository;

import de.api.details.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child,Long> {

    List<Child> findChildBychildName(String childName);

    @Query(value = "select count(*) from parent_child_db.parent where ( " +
            "(select count(*) from parent_child_db.child c " +
            "inner join parent_child_db.parent p " +
            "on c.parent_id = p.id)=?1)",nativeQuery = true)
    Integer getCountOfChildren(Integer n);

}
