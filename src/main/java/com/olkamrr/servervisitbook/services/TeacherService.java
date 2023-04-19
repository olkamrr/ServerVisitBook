package com.olkamrr.servervisitbook.services;

import com.olkamrr.servervisitbook.models.Teacher;
import com.olkamrr.servervisitbook.models.User;
import com.olkamrr.servervisitbook.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;
    private UserService userService;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, UserService userService){
        this.teacherRepository = teacherRepository;
        this.userService = userService;
    }

    public Teacher findOne(int id) {
        Teacher foundTeacher = teacherRepository.findById(id);
        return foundTeacher;
    }

    public User findUser(int id) {
        Teacher foundTeacher = teacherRepository.findById(id);
        User user = foundTeacher.getUser();
        return user;
    }

    public Teacher save(Teacher teacher, int id) {
        teacher.setUser(userService.findOne(id));
        return teacherRepository.save(teacher);
    }

    public Teacher update(int id, Teacher teacher, User user){
        teacher.setId(id);
        teacher.setUser(user);
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAll(){
        List<Teacher> teachers = new ArrayList<>();
        Streamable.of(teacherRepository.findAll()).forEach(teachers::add);
        return teachers;
    }
}
