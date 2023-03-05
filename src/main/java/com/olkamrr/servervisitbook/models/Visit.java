package com.olkamrr.servervisitbook.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String status;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idLesson")
    private Schedule lessonId;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idStudent")
    private Student studentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Schedule getLessonId() {
        return lessonId;
    }

    public void setLessonId(Schedule lessonId) {
        this.lessonId = lessonId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", lessonId=" + lessonId +
                ", studentId=" + studentId +
                '}';
    }
}
