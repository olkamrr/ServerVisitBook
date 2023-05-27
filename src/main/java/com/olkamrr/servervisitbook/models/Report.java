package com.olkamrr.servervisitbook.models;

public class Report {
    int count;
    Student student;
    String lesson;
    String teacher;
    int semester;
    int n;
    int nb;
    int be;
    double percentN;
    double percentNb;
    double percentBe;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public int getBe() {
        return be;
    }

    public void setBe(int be) {
        this.be = be;
    }

    public double getPercentN() {
        return percentN;
    }

    public void setPercentN(double percentN) {
        this.percentN = percentN;
    }

    public double getPercentNb() {
        return percentNb;
    }

    public void setPercentNb(double percentNb) {
        this.percentNb = percentNb;
    }

    public double getPercentBe() {
        return percentBe;
    }

    public void setPercentBe(double percentBe) {
        this.percentBe = percentBe;
    }
}
