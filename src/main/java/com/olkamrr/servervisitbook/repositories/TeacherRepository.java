package com.olkamrr.servervisitbook.repositories;

import com.olkamrr.servervisitbook.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findById(int id);
}
