package com.olkamrr.servervisitbook.repositories;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.Schedule;
import com.olkamrr.servervisitbook.models.Student;
import com.olkamrr.servervisitbook.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Visit findById(int id);
    List<Visit> findVisitsByLessonIdAndConfirmationIsTrue(Schedule schedule);
    List<Visit> findVisitsByStudentIdAndConfirmationIsTrue(Student student);
}
