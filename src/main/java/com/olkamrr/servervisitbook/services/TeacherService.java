package com.olkamrr.servervisitbook.services;

import com.olkamrr.servervisitbook.models.Teacher;
import com.olkamrr.servervisitbook.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public Teacher findOne(int id) {
        Teacher foundTeacher = teacherRepository.findById(id);
        return foundTeacher;
    }

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher update(int id, Teacher teacher){
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAll(){
        List<Teacher> teachers = new ArrayList<>();
        Streamable.of(teacherRepository.findAll()).forEach(teachers::add);
        return teachers;
    }
}
