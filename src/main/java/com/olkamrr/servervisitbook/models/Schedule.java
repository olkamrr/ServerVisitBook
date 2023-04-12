package com.olkamrr.servervisitbook.models;

import javax.persistence.*;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int semester;
    private String week;
    private String weekday;
    private String type;
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idTeacher")
    private Teacher teacher;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idGroup")
    private Group groupId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", semester=" + semester +
                ", week='" + week + '\'' +
                ", weekday='" + weekday + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
