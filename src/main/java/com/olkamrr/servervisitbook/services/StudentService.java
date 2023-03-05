package com.olkamrr.servervisitbook.services;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.Student;
import com.olkamrr.servervisitbook.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private GroupService groupService;

    @Autowired
    public StudentService(StudentRepository studentRepository, GroupService groupService){
        this.studentRepository = studentRepository;
        this.groupService = groupService;
    }

    public Student findOne(int id) {
        Student foundStudent = studentRepository.findById(id);
        return foundStudent;
    }

    public Group findGroup(int id){
        Student foundStudent = studentRepository.findById(id);
        Group group = foundStudent.getGroupId();
        return group;
    }

    public Student save(Student student, int id){
        student.setGroupId(groupService.findOne(id));
        return studentRepository.save(student);
    }

    public Student update(int studentId, Student student, Group group){
        student.setId(studentId);
        student.setGroupId(group);
        return studentRepository.save(student);
    }

    public Student updateGroup(int studentId, Student student, Group group){
        student.setId(studentId);
        student.setGroupId(group);
        return studentRepository.save(student);
    }

    public Student delete(int studentId){
        studentRepository.deleteById(studentId);
        return null;
    }

    public List<Student> studentByGroupOrderByLastNameAsc(int groupId){
        List<Student> students = studentRepository.findStudentsByGroupIdOrderByLastNameAsc(groupService.findOne(groupId));
        return students;
    }
}
