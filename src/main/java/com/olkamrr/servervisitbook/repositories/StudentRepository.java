package com.olkamrr.servervisitbook.repositories;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findById(int id);
    List<Student> findStudentsByGroupId(Group group);
    List<Student> findStudentsByGroupIdOrderByLastNameAsc(Group group);
}
