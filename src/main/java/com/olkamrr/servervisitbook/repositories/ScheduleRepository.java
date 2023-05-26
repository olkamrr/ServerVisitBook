package com.olkamrr.servervisitbook.repositories;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    Schedule findById(int id);
    List<Schedule> findSchedulesByGroupId(Group group);
    List<Schedule> findSchedulesByGroupIdAndSemester(Group group, int semester);
    @Query("SELECT schedule FROM Schedule schedule WHERE schedule.groupId = :group group by schedule.name, schedule.semester")
    List<Schedule> findLessons(Group group);
    List<Schedule> findSchedulesByNameAndSemesterAndGroupId(String name, int semester, Group group);
}
