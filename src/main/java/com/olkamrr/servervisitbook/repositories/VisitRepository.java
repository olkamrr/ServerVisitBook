package com.olkamrr.servervisitbook.repositories;

import com.olkamrr.servervisitbook.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Visit findById(int id);
}
