package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.*;
import com.olkamrr.servervisitbook.services.GroupService;
import com.olkamrr.servervisitbook.services.ScheduleService;
import com.olkamrr.servervisitbook.services.StudentService;
import com.olkamrr.servervisitbook.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/visit")
public class VisitController {
    private VisitService visitService;
    private StudentService studentService;
    private ScheduleService scheduleService;
    private GroupService groupService;

    @Autowired
    public VisitController(VisitService visitService, StudentService studentService, ScheduleService scheduleService, GroupService groupService){
        this.visitService = visitService;
        this.studentService = studentService;
        this.scheduleService = scheduleService;
        this.groupService = groupService;
    }

    @GetMapping("/{name}/{semester}/{groupId}")
    public String visitsByLessons(Model model, @PathVariable(value = "name") String name, @PathVariable(value = "semester") int semester, @PathVariable(value = "groupId") int groupId){
        Group group = groupService.findOne(groupId);
        model.addAttribute("visits", visitService.visitsByLessons(name, semester, group));
        return "visit/visits_by_lessons";
    }

    @GetMapping("/report/{name}/{semester}/{groupId}")
    public String report(Model model, @PathVariable(value = "name") String name, @PathVariable(value = "semester") int semester, @PathVariable(value = "groupId") int groupId){
        Group group = groupService.findOne(groupId);
        List<Visit> visits = visitService.visitsByLessons(name, semester, group);
        List<Student> students = studentService.studentByGroupOrderByLastNameAsc(groupId);
        List<Report> reportList = new ArrayList<>();
        Visit visitReport = new Visit();
        for (Student student: students) {
            Report report = new Report();
            report.setStudent(student);
            report.setN(0);
            report.setNb(0);
            report.setBe(0);
            report.setCount(0);
            for (Visit visit: visits) {
                if (student.getId() == visit.getStudentId().getId()) {
                    report.setLesson(visit.getLessonId().getName());
                    report.setCount(report.getCount() + 1);
                    visitReport = visit;
                    if (visit.getStatus().equals("Н")) report.setN(report.getN() + 1);
                    if (visit.getStatus().equals("НБ")) report.setNb(report.getNb() + 1);
                    if (visit.getStatus().equals("П")) report.setBe(report.getBe() + 1);
                }
            }
            int n = report.getN();
            int nb = report.getNb();
            int be = report.getBe();
            double count = report.getCount();
            double percentN = n / count * 100;
            double percentNb = nb / count * 100;
            double percentBe = be / count * 100;
            report.setPercentN(percentN);
            report.setPercentNb(percentNb);
            report.setPercentBe(percentBe);
            reportList.add(report);
        }
        model.addAttribute("reports", reportList);
        model.addAttribute("visit", visitReport);
        return "visit/report_by_lessons";
    }

    @GetMapping("/report/{studentId}")
    public String reportStudent(Model model, @PathVariable(value = "studentId") int studentId) {
        Student student = studentService.findOne(studentId);
        List<Visit> visitList = visitService.visitsByStudent(student);
        Group group = studentService.findGroup(studentId);
        List<Schedule> schedules = scheduleService.findLessons(group);
        List<Report> reportList = new ArrayList<>();
        for (Schedule schedule: schedules) {
            Report report = new Report();
            report.setLesson(schedule.getName());
            report.setSemester(schedule.getSemester());
            report.setTeacher(schedule.getTeacher().getLastName());
            report.setN(0);
            report.setNb(0);
            report.setBe(0);
            report.setCount(0);
            for (Visit visit: visitList) {
                if (schedule.getName().equals(visit.getLessonId().getName()) && schedule.getSemester() == visit.getLessonId().getSemester()) {
                    report.setCount(report.getCount() + 1);
                    if (visit.getStatus().equals("Н")) report.setN(report.getN() + 1);
                    if (visit.getStatus().equals("НБ")) report.setNb(report.getNb() + 1);
                    if (visit.getStatus().equals("П")) report.setBe(report.getBe() + 1);
                }
            }
            int n = report.getN();
            int nb = report.getNb();
            int be = report.getBe();
            double count = report.getCount();
            double percentBe = 0;
            double percentN = 0;
            double percentNb = 0;
            if (count != 0) {
                percentN = n / count * 100;
                percentNb = nb / count * 100;
                percentBe = be / count * 100;
            }
            report.setPercentN(percentN);
            report.setPercentNb(percentNb);
            report.setPercentBe(percentBe);
            reportList.add(report);
        }
        model.addAttribute("reports", reportList);
        model.addAttribute("student", student);
        return "visit/report_by_student";
    }
}
