package com.olkamrr.servervisitbook.services;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.Student;
import com.olkamrr.servervisitbook.models.User;
import com.olkamrr.servervisitbook.repositories.GroupRepository;
import com.olkamrr.servervisitbook.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    private GroupRepository repository;
    private StudentRepository studentRepository;
    private UserService userService;

    @Autowired
    public GroupService(GroupRepository repository, StudentRepository studentRepository, UserService userService){
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.userService = userService;
    }

    public Group findOne(int id) {
        Group foundGroup = repository.findById(id);
        return foundGroup;
    }

    public User findUser(int id) {
        Group foundGroup = repository.findById(id);
        User user = foundGroup.getUser();
        return user;
    }

    public Group save(Group group, int id){
        group.setUser(userService.findOne(id));
        return repository.save(group);
    }

    public Group update(int groupId, Group group, User user){
        group.setId(groupId);
        group.setUser(user);
        return repository.save(group);
    }

    public Group delete(int groupId){
        Group group = repository.findById(groupId);
        List<Student> students = studentRepository.findStudentsByGroupId(group);
        for (Student student: students) {
            studentRepository.delete(student);
        }
        repository.deleteById(groupId);
        return null;
    }

    public List<Group> getAll(){
        List<Group> groups = new ArrayList<>();
        Streamable.of(repository.findAll()).forEach(groups::add);
        return groups;
    }
}
