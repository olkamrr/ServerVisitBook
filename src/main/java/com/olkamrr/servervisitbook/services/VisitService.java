package com.olkamrr.servervisitbook.services;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.Schedule;
import com.olkamrr.servervisitbook.models.Student;
import com.olkamrr.servervisitbook.models.Visit;
import com.olkamrr.servervisitbook.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitService {
    private VisitRepository visitRepository;
    private StudentService studentService;
    private ScheduleService scheduleService;

    @Autowired
    public VisitService(VisitRepository visitRepository, StudentService studentService, ScheduleService scheduleService){
        this.visitRepository = visitRepository;
        this.studentService = studentService;
        this.scheduleService = scheduleService;
    }

    public Student findStudent(int id){
        Visit foundVisit = visitRepository.findById(id);
        Student student = foundVisit.getStudentId();
        return student;
    }

    public Schedule findSchedule(int id){
        Visit foundVisit = visitRepository.findById(id);
        Schedule lesson = foundVisit.getLessonId();
        return lesson;
    }

    public Visit save(Visit visit, int lessonId, int studentId){
        visit.setLessonId(scheduleService.findOne(lessonId));
        visit.setStudentId(studentService.findOne(studentId));
        return visitRepository.save(visit);
    }

    public Visit update(int id, Visit visit, Schedule lesson, Student student){
        visit.setId(id);
        visit.setLessonId(lesson);
        visit.setStudentId(student);
        return visitRepository.save(visit);
    }

    public List<Visit> visitsByLessons(String name, int semester, Group group) {
        List<Schedule> lessons = scheduleService.findSchedulesByNameAndSemesterAndGroup(name, semester, group);
        List<Visit> visitList = new ArrayList<>();
        for (Schedule schedule: lessons) {
            visitList.addAll(visitRepository.findVisitsByLessonIdAndConfirmationIsTrue(schedule));
        }
        return visitList;
    }

    public List<Visit> visitsByStudent(Student student) {
        return visitRepository.findVisitsByStudentIdAndConfirmationIsTrue(student);
    }
}
