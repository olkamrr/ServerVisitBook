package com.olkamrr.servervisitbook.repositories;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    Schedule findById(int id);
    List<Schedule> findSchedulesByGroupId(Group group);
    List<Schedule> findSchedulesByGroupIdAndSemester(Group group, int semester);
}
