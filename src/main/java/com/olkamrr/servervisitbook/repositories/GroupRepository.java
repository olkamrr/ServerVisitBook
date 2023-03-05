package com.olkamrr.servervisitbook.repositories;

import com.olkamrr.servervisitbook.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group findById(int id);
}
