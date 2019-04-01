package de.api.details.repository;

import de.api.details.model.ParentSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentSummaryRepository extends JpaRepository<ParentSummary,Long> {
}
