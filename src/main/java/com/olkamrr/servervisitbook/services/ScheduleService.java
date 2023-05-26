package com.olkamrr.servervisitbook.services;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.Schedule;
import com.olkamrr.servervisitbook.models.Student;
import com.olkamrr.servervisitbook.models.Teacher;
import com.olkamrr.servervisitbook.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;
    private GroupService groupService;
    private TeacherService teacherService;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, GroupService groupService, TeacherService teacherService){
        this.scheduleRepository = scheduleRepository;
        this.groupService = groupService;
        this.teacherService = teacherService;
    }

    public Schedule findOne(int id) {
        Schedule foundLesson = scheduleRepository.findById(id);
        return foundLesson;
    }

    public Group findGroup(int id){
        Schedule foundLesson = scheduleRepository.findById(id);
        Group group = foundLesson.getGroupId();
        return group;
    }

    public Schedule save(Schedule lesson, int id){
        lesson.setGroupId(groupService.findOne(id));
        return scheduleRepository.save(lesson);
    }

    public Schedule update(int id, Schedule lesson, Group group){
        lesson.setId(id);
        lesson.setGroupId(group);
        return scheduleRepository.save(lesson);
    }

    public Schedule delete(int id){
        scheduleRepository.deleteById(id);
        return null;
    }

    public List<Schedule> schedulesByGroup(int groupId){
        List<Schedule> lesson = scheduleRepository.findSchedulesByGroupId(groupService.findOne(groupId));
        return lesson;
    }

    public List<Schedule> schedulesByGroupAndSemester(int groupId, int semester){
        List<Schedule> lesson = scheduleRepository.findSchedulesByGroupIdAndSemester(groupService.findOne(groupId), semester);
        return lesson;
    }

    public List<Schedule> findLessons (int groupId) {
        return scheduleRepository.findLessons(groupService.findOne(groupId));
    }

    public List<Schedule> findSchedulesByNameAndSemesterAndGroup(String name, int semester, Group group) {
        return scheduleRepository.findSchedulesByNameAndSemesterAndGroupId(name, semester, group);
    }
}
